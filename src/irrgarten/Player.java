/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

import java.util.ArrayList;

/**
 *
 * @author francisco
 */
public class Player {
    private final static int MAX_WEAPONS = 2;
    private final static int MAX_SHIELDS = 3;
    private final static int INITIAL_HEALTH = 10;
    private final static int HITS2LOSE = 3;
    private String name;
    private char number;
    private float intelligence;
    private float strength;
    private float health;
    private int row;
    private int col;
    private int consecutiveHits = 0;

    public Player(char number, float intelligence, float strength) {
        this.number = number;
        this.intelligence = intelligence;
        this.strength = strength;
    }
    
    public void resurrect() {
        
    }

    public char getNumber() {
        return number;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    public void setPos(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    public boolean dead() {
        throw new UnsupportedOperationException();
    }
    
    public Directions move(Directions direction, ArrayList<Directions> validMoves) {
        throw new UnsupportedOperationException();
    }
    
    public float attack() {
        throw new UnsupportedOperationException();
    }
    
    public boolean deffend(float receivedAttack) {
        throw new UnsupportedOperationException();
    }
    
    public void receiveReward() {
        
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", number=" + number + ", intelligence=" + intelligence + ", strength=" + strength + ", health=" + health + ", row=" + row + ", col=" + col + ", consecutiveHits=" + consecutiveHits + '}';
    }
    
    // ################ MÉTODOS PRIVADOS ################
    
    private void receiveWeapon(Weapon w) {
        
    }
    
    private void receiveShield(Shield s) {
        
    }
    
    private Weapon newWeapon() {
        throw new UnsupportedOperationException();
    }
    
    private Shield newShield() {
        throw new UnsupportedOperationException();
    }
    
    private float sumWeapons() {
        throw new UnsupportedOperationException();
    }
    
    private float sumShields() {
        throw new UnsupportedOperationException();
    }
    
    private float defensiveEnergy() {
        throw new UnsupportedOperationException();
    }
    
    private boolean manageHit(float receivedAttack) {
        throw new UnsupportedOperationException();
    }
    
    private void resetHits() {
        
    }
    
    private void gotWounded() {
        
    }
    
    private void incConsecutiveHits() {
        
    }
}
