import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


// TODO Add method to initAttributes
public class Castle extends Structure implements Drawable {
    private final String IMAGE_PATH = "/res/Castle1.png";
    private Image castleImage;
    private ImageView imageView;

    public Castle (int xLoc, int yLoc){
        setAtt(10);
        setDef(100);
        setHp(100);
        this.setXPos(xLoc);
        this.setYPos(yLoc);
        initImageView();
    }

    public ImageView getImageView(){
        return imageView;
    }


    // Need to create the Image once to share it to multiple objects.
    private void initImageView(){
        this.castleImage = new Image(IMAGE_PATH);
        imageView = new ImageView(castleImage);
        imageView.setX(getXPos());
        imageView.setY(getYPos());
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        imageView.setPreserveRatio(true);
    }


}

