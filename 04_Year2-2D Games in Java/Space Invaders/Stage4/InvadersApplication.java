package Space_Invaders.Stage4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;

public class InvadersApplication extends JFrame implements KeyListener, Runnable {
    //  Member Variables
    private BufferStrategy strategy;
    private static String workingDirectory;
    private static boolean isInitialised = false;

    //WindowSize is increased
    private static final Dimension WindowSize = new Dimension(800,600);
    private static final int NUMALIENS = 30;
    private final Alien[] Aliens = new Alien[NUMALIENS];
    private final Spaceship PlayerShip;

    public InvadersApplication(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width/2 - WindowSize.width/2;
        int y = screensize.height/2 - WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);
        this.setTitle("Week 4 Java Game Development Assignment");

        ImageIcon icon = new ImageIcon(workingDirectory + "\\ct255-images\\alien_ship_1.png");
        Image alienImage = icon.getImage();

        //Number of buffers is specified after setbounds() and setvisable() are called.
        createBufferStrategy(2);
        strategy = getBufferStrategy();

        //Variables to store grid formation coordinates.
        double fooX = 0;
        double barY = 0;

        for(int i = 0; i<NUMALIENS; i++){
            //New alien object instantiated.
            Aliens[i] = new Alien(alienImage, WindowSize.width);
            //Modulus is used to display 6 rows of 5 aliens
            if(i%5==0){
                //On the first iteration, 0%5 is 0 so these are also the initial values.
                fooX = 35;
                //40 pixels between each row of aliens
                barY += 40;
            }
            //70 pixels between each alien in the row
            else {
                fooX += 70;
            }
            //Used to set the initial grid position of the aliens
            Aliens[i].setPosition((fooX), (barY));
        }

        icon = new ImageIcon(workingDirectory + "\\ct255-images\\player_ship.png");
        Image shipImage = icon.getImage();
        PlayerShip = new Spaceship(shipImage, WindowSize.width);
        //The player ship's position is set manually in order to display it separate from the alien icons
        PlayerShip.setPosition(300,530);

        //A key listener for the arrow key and a thread is started
        Thread t = new Thread(this);
        t.start();

        addKeyListener(this);

        //Boolean to imply the images are ready to be printed
        isInitialised = true;
    }

    public void run(){
        while(1==1) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) { }

            //Loop through each alien and call their move method.
            for (int i = 0; i < NUMALIENS; i++) {
                //If one move method returns false, (i.e., an alien has hit the bound limit)
                if(!Aliens[i].move()) {
                    //Loop through the rest of the aliens after the alien that hit the bound limit
                    for(int j=(i+1); j < NUMALIENS; j++){
                        //So all aliens can be in the same position before being moved down closer towards the player
                        Aliens[j].move();
                    }
                    //Call reversedirection() for all aliens, so they are moved down
                    //and speed changed in the opposite direction
                    for(int c = 0; c< NUMALIENS; c++) {
                        Aliens[c].reverseDirection();
                    }
                    //Break out of first for loop to move to the next iteration of movement for all aliens
                    break;
                }
            }
            //Move the player and force a repaint on everything on the screen
            PlayerShip.move();
            this.repaint();
        }
    }

    //If a key is held/typed, a switch statement is used to check if it's the right or left arrow key.
    //Depending on the key, the player ship's xSpeed variable is modified (i.e., speed of movement is increased)
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
        //If not initialized do not print
        if (!isInitialised)
            return;

        //Redirect drawing calls
        g = strategy.getDrawGraphics();

        //Paint a black tile to cover the screen on each paint call
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WindowSize.width,WindowSize.height);


        //Run each aliens paint method to repaint them with their new positions
        for(int i = 0; i<NUMALIENS; i++){
            Aliens[i].paint(g);
        }

        //Paint the player ship
        PlayerShip.paint(g);

        //Flipping the buffers/
        strategy.show();
    }

    //Application's entry point
    public static void main(String[] args){
        //Setting up the user directory in order to navigate to the images folder
        workingDirectory = System.getProperty("user.dir");
        InvadersApplication w = new InvadersApplication();
    }
}
