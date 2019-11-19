import javafx.scene.image.ImageView;

public class Soldier extends GameUnit {
    private ImageView imageView;


    public void update(){
        this.setXPos(this.getXPos() + getMoveSpeed());
        this.setYPos(this.getYPos() + getMoveSpeed());
        imageView = ImageManager.getInstance().getImage(nationID, getClass().getSimpleName());
    }

    public Soldier(int nationID, int x, int y){
        this.nationID = nationID;
        this.setXPos(x);
        this.setYPos(y);
        imageView = ImageManager.getInstance().getImage(nationID, getClass().getSimpleName());
        imageView = initImageViewSettings(this.imageView);
    }

    @Override
    public ImageView getImageView() {
        return imageView;
    }

    private ImageView initImageViewSettings(ImageView imageView){
        imageView.setX(getXPos());
        imageView.setY(getYPos());
        imageView.setFitHeight(500);
        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);
        return imageView;
    }
}
