package GUI;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public final class ImageManager {
    private static final ImageManager INSTANCE = new ImageManager();
    private ArrayList<Image> castles;
    private ArrayList<Image> knights;

    private final int NUM_CASTLES = 3;
    private final int NUM_KNIGHTS = 3;
    private final int knightDim = 50;
    private final int castleDim = 200;



    public ImageView getImage( int nationID,String c) {
        if (c.equals("Knight")) {
            ImageView imageView = new ImageView(knights.get(nationID));
            imageView.setFitHeight(knightDim);
            imageView.setFitWidth(knightDim);
            imageView.setPreserveRatio(true);
            return imageView;

        }
        else if (c.equals("Castle")) {
            ImageView imageView = new ImageView(castles.get(nationID));
            imageView.setFitHeight(castleDim);
            imageView.setFitWidth(castleDim);
            imageView.setPreserveRatio(true);
            return imageView;
        }
        else {
            System.out.println("ERROR RETURNING");
        }
        return new ImageView(knights.get(0));
    }

    public  ArrayList<Image> initCastleArray(){
        castles = new ArrayList<Image>();
        for (int i = 0; i < NUM_CASTLES; i++){
            castles.add((new Image("/resources/Castles/Castle" + i + ".png")));
        }
        return castles;
    }
    public  ArrayList<Image> initKnightArray(){
        knights = new ArrayList<Image>();
        for (int i = 0; i < NUM_KNIGHTS; i++){
            knights.add((new Image("/resources/Knights/Knight" + i + ".png")));
        }
        return knights;
    }


    public static ImageManager getInstance(){
        return INSTANCE;
    }
    public ImageManager(){
        castles = initCastleArray();
        knights = initKnightArray();
    }

    public int getKnightDim(){
        return knightDim;
    }
}