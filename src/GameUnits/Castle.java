package GameUnits;

import GUI.ImageManager;
import javafx.scene.image.ImageView;


public class Castle extends Structure implements Drawable {
    private ImageView imageView;

    public Castle (int xLoc, int yLoc, int id){
        setAtt(10);
        setDef(100);
        setHp(100);
        this.nationID = id;
        this.setXPos(xLoc);
        this.setYPos(yLoc);
        initImageView();
    }


    // Need to create the Image once to share it to multiple objects.
    private void initImageView(){
        imageView = ImageManager.getInstance().getImage(nationID,getClass().getSimpleName());
        imageView.setX(getXPos());
        imageView.setY(getYPos());
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
    }

    public void update(){

    }

    public ImageView getImageView(){
        return imageView;
    }

}

