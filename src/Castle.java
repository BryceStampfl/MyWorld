import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;


// TODO Add method to initAttributes
public class Castle extends Structure implements Drawable {
    private  String IMAGE_PATH;
    private Image castleImage;
    private ImageView imageView;
    private Rectangle r;

    public Castle (int xLoc, int yLoc, int id){
        this.IMAGE_PATH = "/res/Castle" + (id+1) +".png";
        System.out.println(IMAGE_PATH);
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
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);
    }


}

