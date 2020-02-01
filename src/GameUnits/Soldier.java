package GameUnits;

import GUI.ImageManager;
import GameUnits.GameUnit;
import javafx.scene.image.ImageView;

public class Soldier extends GameUnit {
    private ImageView imageView;


    public void update(){
        setXPos(getXPos() + getMoveSpeed());
        setYPos(getYPos() + getMoveSpeed());
        imageView.setX(getXPos());
        imageView.setY(getYPos());
        }

    public Soldier(int nationID, int x, int y){
        this.nationID = nationID;
        this.setXPos(x);
        this.setYPos(y);
        setMoveSpeed(0);
        initImageView();
    }


    private void initImageView(){
        imageView = ImageManager.getInstance().getImage(nationID, getClass().getSimpleName());
        imageView.setX(getXPos());
        imageView.setY(getYPos());
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        imageView.setPreserveRatio(true);
    }


    @Override
    public ImageView getImageView() {
        return imageView;
    }
}
