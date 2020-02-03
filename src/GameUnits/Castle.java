package GameUnits;

import GUI.ImageManager;
import Utility.Point;

public class Castle extends Structure implements Drawable {

    public Castle (int nationID, Point location){
        setAtt(10);
        setDef(100);
        setHp(100);
        setNationID(nationID);
        setImageView(ImageManager.getInstance().getImage(nationID,getClass().getSimpleName()));
        setLocation(location);
    }

    public void update(){
    }

}

