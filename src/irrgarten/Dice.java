/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

import java.util.Random;

/**
 * @author francisco y miriam
 */
public class Dice {
    private static int MAX_USES = 5;
    private static float MAX_INTELLIGENCE = 10.0f;
    private static float MAX_STRENGTH = 10.0f;
    private static float RESURRECT_PROB =  0.3f;
    private static int WEAPONS_REWARD = 2;
    private static int SHIELDS_REWARD = 3;
    private static int HEALTH_REWARD = 5;
    private static int MAX_ATTACK = 3;
    private static int MAX_SHIELD = 2;
    
    private static Random generator = new Random();
    
    public static int randomPost (int max) {
        return generator.nextInt(max);
    }
    
    public static int whoStarts (int nplayers) {
        return generator.nextInt(nplayers);
    }
    
    public static float randomIntelligence() {
        return generator.nextFloat(MAX_INTELLIGENCE);
    }
    
    public static float randomStrength() {
        return generator.nextFloat(MAX_STRENGTH);
    }
    
    /*public static boolean resuctPlayer() {
       return generator.nextBoolean(RESURRECT_PROB);
    }
    */
}
