package Space_Invaders.Stage2;

import java.awt.*;
import javax.swing.*;

public class Assignment2 extends JFrame implements Runnable {
    private static final Dimension WindowSize = new Dimension(600,600);
    //Max number of tiles are defined.
    private static final int NUMGAMEOBJECTS = 30;
    //A gameobject array to hold all the tiles.
    private GameObject[] GameObjectsArray = new GameObject[NUMGAMEOBJECTS];

    public Assignment2(){
        this.setTitle("Week 2 Java Game Development Assignment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Display the window, centred on the screen
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width/2 - WindowSize.width/2;
        int y = screensize.height/2 - WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);

        //Create 30 tiles on the screen
        for(int i = 0; i<NUMGAMEOBJECTS; i++){
            GameObjectsArray[i] = new GameObject();
        }

        //Create and start a thread.
        Thread t = new Thread(this);
        t.start();
    }

    public void run(){
        while(true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Infinitely loop through each tile and run their move method
            for (int i = 0; i < NUMGAMEOBJECTS; i++)
                GameObjectsArray[i].move();
            this.repaint();
        }
    }

    public void paint(Graphics g){
        //At the beginning of each new animation, create a white canvass to avoid a trail for each tile
        g.setColor(Color.WHITE);
        g.fillRect(0,0,600,600);

        //Run each tiles paint method
        for(int i = 0; i<NUMGAMEOBJECTS; i++){
            GameObjectsArray[i].paint(g);
        }
    }

    public static void main(String[] args){
        Assignment2 tt = new Assignment2();
    }

}
