package Space_Invaders.Stage4;
import java.awt.*;

public class Spaceship extends Sprite2D {
    public Spaceship(Image i,int windowWidth) {
        //Call to superclass
        super(i, windowWidth);
    }
    public void move(){
        //Bounds where player movement is allowed are set
        if(x>=5&&x<=winWidth)
            x+=xSpeed;
        //If the player is out of bounds, set them back within bounds
        else if(x>800)
            x-=5;
        else
            x+=5;
    }
}
