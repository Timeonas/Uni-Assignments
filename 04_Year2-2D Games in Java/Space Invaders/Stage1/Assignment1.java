package Space_Invaders.Stage1;
import java.awt.*;
import javax.swing.*;

public class Assignment1 extends JFrame {
    private static final Dimension WindowSize = new Dimension(600,600);

    public Assignment1() {
        //Create and set up the window.
        this.setTitle("Week 1 Java Game Development Assignment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Display the window, centred on the screen
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width/2 - WindowSize.width/2;
        int y = screensize.height/2 - WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);
    }

    public static void main(String[] args) {
        Assignment1 w = new Assignment1();
    }

    public void paint ( Graphics g ) {
        //Pixels from left and right border: 25px
        //X coordinate range of squares 25px-575px
        //Gap between each square: 10px
        //Width and Height of Square: 40px Width 40px Height

        //Axis Coordinates
        int x,y;
        //RGB Coordinates
        int red,green,blue;
        //Loop through y coordinates, start 40px from the top border and increment by 50px
        for(y = 40; y<=550; y+=50){
            //Loop through x coordinates, start 29px from the left border and increment by 50px
            for(x = 29; x<=550; x+=50){
                //Set random RGB Values (0-255)
                red = (int)(Math.random()*256);
                green = (int)(Math.random()*256);
                blue = (int)(Math.random()*256);

                //Assign a color with the random RGB values
                Color c = new Color(red,green,blue);
                g.setColor(c);
                g.fillRect(x,y,40,40);
            }
        }
    }

}
