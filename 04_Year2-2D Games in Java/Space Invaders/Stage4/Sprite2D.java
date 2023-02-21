package Space_Invaders.Stage4;
import java.awt.*;
public class Sprite2D{
    //Coordinate variables to hold the position of the icon
    protected double x,y;
    //Speed variable that is changes the movement of aliens and player
    protected double xSpeed=0;
    //Image variable to hold the icon image
    protected Image myImage;
    //Screen width to ensure proper bounds are set based on screen size
    int winWidth;

    public Sprite2D(Image i, int windowWidth) {
        //Set the image and window width
        myImage = i;
        winWidth = windowWidth;
    }

    public void setPosition(double xx, double yy){
        //Set the location of the object that is desired.
        x = xx;
        y = yy;
    }

    public void setXSpeed(double dx){
        //Method used to set the speed of the player ship and the aliens movement in grid form
        xSpeed = dx;
    }

    public void paint(Graphics g) {
        //Paint the icon image on the screen with the x and y coordinates+
        g.drawImage(myImage,(int)x,(int)y,null);
    }
}
