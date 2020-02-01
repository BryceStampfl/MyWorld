package GUI;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public final class ImageManager {
    private static final ImageManager INSTANCE = new ImageManager();
    private ArrayList<Image> castles;
    private ArrayList<Image> knights;
    private int NUM_CASTLES = 3;
    private int NUM_KNIGHTS = 3;


    public static ImageManager getInstance(){
        return INSTANCE;
    }

    public ImageView getImage( int nationID,String c) {

        if (c.equals("Knight")) {
            return new ImageView(knights.get(nationID));

        }
        else if (c.equals("Castle")) {
            return new ImageView(castles.get(nationID));
        }
        else {
            System.out.println("ERROR RETURNING");
        }
        return new ImageView(knights.get(0));
    }

    public ImageManager(){
        castles = initCastleArray();
        knights = initKnightArray();
    }
    /// This class is awful need to add polymorphism using string editing.
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
}