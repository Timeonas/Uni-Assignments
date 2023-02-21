package Space_Invaders.Stage4;
import java.awt.*;

public class Alien extends Sprite2D {
    public Alien(Image i, int windowWidth) {
        //Call to super class's constructor
        super(i, windowWidth);
        //Set initial speed
        setXSpeed(2);
    }
    public boolean move() {
        //Upon each move method call, add speed value
        x +=xSpeed;
        //If the aliens are out of bounds, return false to signal main application to change the value of speed
        if(x>winWidth){
            return false;
        } else if (x<35) {
            return false;
        }
        //If aliens are within bounds, return true to continue with the speed
        return true;
    }

    public void reverseDirection(){
        //Switch speed and increment y value to move aliens closer to player
        if(xSpeed==2) {
            setXSpeed(-2);
        }
        else {
            setXSpeed(2);
        }
        y+=5;
    }
    }
