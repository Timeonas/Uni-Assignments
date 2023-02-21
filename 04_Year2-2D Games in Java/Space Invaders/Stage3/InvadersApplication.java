package Space_Invaders.Stage3;

//Importing necessary Java libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InvadersApplication extends JFrame implements KeyListener, Runnable {

    private static String workingDirectory;
    private static boolean isInitialised = false;
    private static final Dimension WindowSize = new Dimension(600,600);
    private static final int NUMALIENS = 30;
    private Sprite2D[] Aliens = new Sprite2D[NUMALIENS];
    private Sprite2D PlayerShip;

    public InvadersApplication(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width/2 - WindowSize.width/2;
        int y = screensize.height/2 - WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);
        this.setTitle("Week 3 Java Game Development Assignment");

        ImageIcon icon = new ImageIcon(workingDirectory + "\\ct255-images\\alien_ship_1.png");
        Image alienImage = icon.getImage();

        for(int i = 0; i<NUMALIENS; i++){
            Aliens[i] = new Sprite2D(alienImage);
        }

        icon = new ImageIcon(workingDirectory + "\\ct255-images\\player_ship.png");
        Image shipImage = icon.getImage();
        PlayerShip = new Sprite2D(shipImage);
        //The player ship's position is set manually in order to display it separate from the alien icons
        PlayerShip.setPosition(300,530);

        isInitialised = true;

        Thread t = new Thread(this);
        t.start();

        //A key listener for the arrow key and a thread is started
        addKeyListener(this);

        isInitialised = true;
    }

    public void run(){
        while(1==1) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) { }

            for (int i = 0; i < NUMALIENS; i++) {
                Aliens[i].moveEnemy();
            }
            PlayerShip.movePlayer();
            this.repaint();
        }
    }

    //If a key is held/typed, a switch statement is used to check if its the right or left arrow key.
    //Depending on the key, the Sprite2D's xSpeed variable is modified (i.e., speed of movement is increased)
    //On each key stroke refresh, moveplayer() is called to updated the position of the image based on the speed
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> PlayerShip.setXSpeed(-4);
            case KeyEvent.VK_RIGHT -> PlayerShip.setXSpeed(4);
        }
    }
    //When an arrow key is released the speed is set to 0 (To stop movement)
    public void keyReleased(KeyEvent e) {
       if(e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_RIGHT){
           PlayerShip.setXSpeed(0);
       }
    }
    public void keyTyped(KeyEvent e){}

    public void paint(Graphics g){
        if (!isInitialised)
            return;

        //Paint a black tile to cover the screen on each paint call
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WindowSize.width,WindowSize.height);


        //Run each aliens paint method to repaint them with their new positions
        for(int i = 0; i<NUMALIENS; i++){
            Aliens[i].paint(g);
        }

        //Paint the player ship
        PlayerShip.paint(g);
    }

    //Application's entry point
    public static void main(String[] args){
        //Setting up the user directory in order to navigate to the images folder
        workingDirectory = System.getProperty("user.dir");
        InvadersApplication w = new InvadersApplication();
    }
}

