/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author francisco
 */
public class Monster {
    private static int INITIALHEALTH = 5;
    private String name;
    private float intelligence;
    private float strength;
    private float health;
    private int row;
    private int col;

    public Monster(String name, float intelligence, float strength) {
        this.name = name;
        this.intelligence = intelligence;
        this.strength = strength;
    }
    
    public boolean dead() {
        throw new UnsupportedOperationException();
    }
    
    public float attack() {
        throw new UnsupportedOperationException();
    }
    
    public boolean deffend(float receivedAttack) {
        throw new UnsupportedOperationException();
    }
    
    public void setPos(int row, int col) {
        
    }

    @Override
    public String toString() {
        return "Monster{" + "name=" + name + ", intelligence=" + intelligence + ", strength=" + strength + ", health=" + health + ", row=" + row + ", col=" + col + '}';
    }
    
    private void gotWounded() {
        
    }
}
