package GameUnits;

import GameUnits.Drawable;
import GameUnits.GameUnit;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class WorkerUnit extends GameUnit implements Drawable {



    public String getPathToImage(){
        return "";
    }

    public Shape getShape(){
        Rectangle r = new Rectangle(10, 10, 15, 15);
        return r;
    }

    @Override
    public ImageView getImageView() {
        return null;
    }
    public void update(){

    }
}
