import javafx.scene.image.ImageView;

public class Castle extends Structure implements Drawable {
    private final String imagePath = "/res/Castle1.png";
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

    private void initImageView(){
        imageView = new ImageView(imagePath);
        imageView.setX(this.getXPos());
        imageView.setY(this.getYPos());
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        imageView.setPreserveRatio(true);
    }
}

