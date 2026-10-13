package irrgarten;

/**
 * @author francisco manuel de céspedes y miriam pulido
 */
public class Weapon {
    private float power;
    private int uses;

    public Weapon(float power, int uses) {
        this.power = power;
        this.uses = uses;
    }
    
    public float attack() {
        if (uses > 0) {
            uses--;
            return power;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "W[" + power + ", " + uses + "]";
    }
    
    public boolean discard() {
        return Dice.discardElement(uses);
    }
    
}
