/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 * @author francisco y miriam
 */
public class Shield {
    private float protection;
    private int uses;
    
    public Shield (float protection, int uses) {
        this.protection = protection;
        this.uses = uses;
    }
    
    public float protect () {
        if (uses > 0) {
            uses--;
            return protection;
        }
        return 0; 
    }
    
    public boolean discard() {
        return Dice.discardElement(uses);
    }
    
    @Override
    public String toString() {
        return "S[" + protection + "," + uses + "]";
    }
}
