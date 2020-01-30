package GameUnits;

import GUI.ImageManager;
import GameUnits.GameUnit;
import javafx.scene.image.ImageView;

public class Soldier extends GameUnit {
    private ImageView imageView;


    public void update(){
        System.out.println("Before update: X=" + getXPos() + " Y=" + getYPos());
        System.out.println("ImageView before:" + imageView.getX()+ " Y=" + imageView.getY());

        setXPos(getXPos() + getMoveSpeed());
        setYPos(getYPos() + getMoveSpeed());
        imageView.setX(getXPos());
        imageView.setY(getYPos());
        System.out.println("After update: X=" + getXPos() + " Y=" + getYPos());
        System.out.println("ImageView After:" + imageView.getX()+ " Y=" + imageView.getY());

    }

    public Soldier(int nationID, int x, int y){
        this.nationID = nationID;
        this.setXPos(x);
        this.setYPos(y);
        setMoveSpeed(10);
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
