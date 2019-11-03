
public abstract class GameUnit implements Drawable {
    int hp, att, def, moveSpeed;

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public int getHp(){
        return hp;
    }

    public int getAtt(){
        return att;
    }

    public int getDef(){
        return def;
    }
}
