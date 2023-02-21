package Space_Invaders.Stage3;

import java.awt.*;

public class Sprite2D{
    //Coordinate variables to hold the position of the icon
    private double x,y;
    //Speed variable that is changed on each key input
    private double xSpeed=0;
    //Image variable to hold the icon image
    private Image myImage;

    public Sprite2D(Image i) {
        //On each declaration of the object, randomise the location for the aliens
        x = (int)(Math.random()*600);
        y = (int)(Math.random()*600);
        //Set the image
        myImage = i;
    }

    public void moveEnemy(){
        //Each tile will move anywhere between 10 - -10 pixels on its x and y axis each time move() is called
        x += 10*(Math.random()-Math.random());
        y += 10*(Math.random()-Math.random());

        if(x<0)
            x=0;
        else if (x>600)
            x=600;
        if(y<50)
            y=50;
        else if(y>400)
            y=400;
    }

    public void setPosition(double xx, double yy){
        //Set the location of the object that is desired
        x = xx;
        y = yy;
    }

    public void movePlayer(){
        if(x>=5&&x<=540)
            x+=xSpeed;
        else if(x>5)
            x-=5;
        else
            x+=5;
    }

    public void setXSpeed(double dx){
        //Method used to set the speed of the player ship
        xSpeed = dx;
    }

    public void paint(Graphics g) {
        //Paint the icon image on the screen with the x and y coordinates+
        g.drawImage(myImage,(int)x,(int)y,null);
    }
}
