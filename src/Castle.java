import javafx.scene.shape.Shape;

public class Castle extends Structure implements Drawable {
    private final String imagePath = "";



    public Castle (){
        hp += 100;
        att += 10;
        def += 10;
    }

    @Override
    public String getDrawing() {
        return null;
    }

    @Override
    public Shape getShape() {
        return null;
    }
}
