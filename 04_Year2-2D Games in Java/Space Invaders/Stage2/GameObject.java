package Space_Invaders.Stage2;
import java.awt.*;

public class GameObject {
    private int x,y;
    //Integers that will be assigned random values
    int red,green,blue,movX,movY;
    private Color c;

    public GameObject(){
        //Generate random integer values for each color value
        red = (int)(Math.random()*256);
        green = (int)(Math.random()*256);
        blue = (int)(Math.random()*256);

         c = new Color(red,green,blue);

        //Random values for x,y (0-600)
        x = (int)(Math.random()*599);
        y = (int)(Math.random()*599);
    }

    public void move(){
        //Each tile will move anywhere between 10 - -10 pixels on its x and y axis each time move() is called
        movX = (int)((Math.random()*10)-(Math.random()*10));
        movY = (int)((Math.random()*10)-(Math.random()*10));

        //The movement amount will be added to its current coordinates
        x = x + movX;
        y = y + movY;
    }

    public void paint(Graphics g) {
        g.setColor(c);
        g.fillRect(x,y,40,40);
    }
}
