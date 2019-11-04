public class GameLogic {
    private MyWorld world;

    public static void main(String[] args){
        GameLogic g = new GameLogic();
        g.initWorld();
    }

    private MyWorld initWorld(){
        return (new MyWorld());
    }
}
