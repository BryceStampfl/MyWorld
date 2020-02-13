package GameUnits;

import GUI.ImageManager;
import Utility.Point;

public class Castle extends StructureGameUnit{
    

    public Castle (int nationID, Point location){
        setNationID(nationID);
        setImageView(ImageManager.getInstance().getImage(nationID,getClass().getSimpleName()));
        setLocation(location);
    }

    public void update(){
    }

}

