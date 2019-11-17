import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;


// TODO Add method to initAttributes
public class Castle extends Structure implements Drawable {
    private String IMAGE_PATH;
    private ImageView imageView;

    public Castle (int xLoc, int yLoc, int id){
        this.IMAGE_PATH = "/res/Castles/Castle" + (id+1) +".png";
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
        imageView = new ImageView(new Image(IMAGE_PATH));
        imageView.setX(getXPos());
        imageView.setY(getYPos());
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
    }

    public void update(){
      /*  this.setXPos(this.getXPos() +1);
        this.setYPos(this.getYPos() +1);
        this.imageView.setX(this.getXPos());
        this.imageView.setY(this.getYPos()); */
    }


}

