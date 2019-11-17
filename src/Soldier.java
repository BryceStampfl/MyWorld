import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Soldier extends GameUnit {

    public Soldier(){

    }


    public ImageView getImageView(){
        return (new ImageView(new Image("Castle1.png")));
    }

    public void update(){
        this.setXPos(this.getXPos() + getMoveSpeed());
        this.setYPos(this.getYPos() + getMoveSpeed());

    }

}
