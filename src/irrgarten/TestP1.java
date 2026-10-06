/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * @author francisco y miriam
 */

public class TestP1 {
    private static final int N = 100; // número de llamadas en las pruebas de Dice
 
    public static void main(String[] args) {
        testEnums();
        testWeapon();
        testShield();
        testGameState();
        testDice();
    }
    

    // ---------------------------------------------------------------- Enumerados
    private static void testEnums() {
        System.out.println("=== Enumerados ===");
        for (Directions d : Directions.values()) {
            System.out.println("Directions: " + d);
        }
        for (Orientation o : Orientation.values()) {
            System.out.println("Orientation: " + o);
        }
        for (GameCharacter c : GameCharacter.values()) {
            System.out.println("GameCharacter: " + c);
        }
        Directions dir = Directions.UP;
        System.out.println("Direction elegida: " + dir);
    }
 
    // -------------------------------------------------------------------- Weapon
    private static void testWeapon() {
        System.out.println("\n=== Weapon ===");
        Weapon w1 = new Weapon(2.0f, 3);
        Weapon w2 = new Weapon(Dice.weaponPower(), Dice.usesLeft());
 
        System.out.println("w1 = " + w1);
        System.out.println("w2 = " + w2);
 
        // Tras agotar los usos, attack() debe devolver 0
        for (int i = 0; i < 5; i++) {
            System.out.println("w1.attack() = " + w1.attack() + "  ->  " + w1);
        }
 
        // discard() delega en Dice.discardElement con los usos restantes
        System.out.println("discard() de un arma con u usos, " + N + " llamadas:");
        for (int u = 0; u <= 5; u++) {
            Weapon w = new Weapon(1.0f, u);
            int trues = 0;
            for (int i = 0; i < N; i++) {
                if (w.discard()) {
                    trues++;
                }
            }
            System.out.println("  usos=" + u + " -> true " + trues + "/" + N);
        }
    }
 
    // -------------------------------------------------------------------- Shield
    private static void testShield() {
        System.out.println("\n=== Shield ===");
        Shield s1 = new Shield(3.0f, 4);
        Shield s2 = new Shield(Dice.shieldPower(), Dice.usesLeft());
 
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
 
        for (int i = 0; i < 6; i++) {
            System.out.println("s1.protect() = " + s1.protect() + "  ->  " + s1);
        }
 
        System.out.println("discard() de un escudo con u usos, " + N + " llamadas:");
        for (int u = 0; u <= 5; u++) {
            Shield s = new Shield(1.0f, u);
            int trues = 0;
            for (int i = 0; i < N; i++) {
                if (s.discard()) {
                    trues++;
                }
            }
            System.out.println("  usos=" + u + " -> true " + trues + "/" + N);
        }
    }
 
    // ----------------------------------------------------------------- GameState
    private static void testGameState() {
        System.out.println("\n=== GameState ===");
        GameState gs1 = new GameState("Laberinto 5x5", "Jugador 0", "Monstruo 0",
                0, false, "Comienza la partida");
        GameState gs2 = new GameState("Laberinto 3x3", "Jugador 1", "Monstruo 1",
                1, true, "El jugador 1 ha ganado");
 
        for (GameState gs : new GameState[]{gs1, gs2}) {
            System.out.println("labyrinth=" + gs.getLabyrinth()
                    + " | players=" + gs.getPlayers()
                    + " | monsters=" + gs.getMonsters()
                    + " | currentPlayer=" + gs.getCurrentPlayer()
                    + " | winner=" + gs.getWinner()
                    + " | log=" + gs.getLog());
        }
    }
 
    // ---------------------------------------------------------------------- Dice
    private static void testDice() {
        System.out.println("\n=== Dice (" + N + " llamadas por método) ===");
 
        checkInt("randomPos(10)        esperado [0, 9]", () -> Dice.randomPos(10));
        checkInt("whoStarts(4)         esperado [0, 3]", () -> Dice.whoStarts(4));
        checkFloat("randomIntelligence()  esperado [0, 10[", Dice::randomIntelligence);
        checkFloat("randomStrength()      esperado [0, 10[", Dice::randomStrength);
        checkBool("resurrectPlayer()   esperado ~30%", Dice::resurrectPlayer);
        checkInt("weaponsReward()      esperado [0, 2]", Dice::weaponsReward);
        checkInt("shieldsReward()      esperado [0, 3]", Dice::shieldsReward);
        checkInt("healthReward()       esperado [0, 5]", Dice::healthReward);
        checkFloat("weaponPower()         esperado [0, 3[", Dice::weaponPower);
        checkFloat("shieldPower()         esperado [0, 2[", Dice::shieldPower);
        checkInt("usesLeft()           esperado [0, 5]", Dice::usesLeft);
        checkFloat("intensity(7.5f)       esperado [0, 7.5[", () -> Dice.intensity(7.5f));
 
        System.out.println("discardElement(u): esperado 100%, 80%, 60%, 40%, 20%, 0%");
        for (int u = 0; u <= 5; u++) {
            final int uses = u;
            checkBool("  discardElement(" + uses + ")", () -> Dice.discardElement(uses));
        }
    }
 
    private static void checkInt(String name, IntSupplier f) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int v = f.getAsInt();
            min = Math.min(min, v);
            max = Math.max(max, v);
        }
        System.out.println(name + " -> min=" + min + " max=" + max);
    }
 
    private static void checkFloat(String name, Supplier<Float> f) {
        float min = Float.MAX_VALUE;
        float max = -Float.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            float v = f.get();
            min = Math.min(min, v);
            max = Math.max(max, v);
        }
        System.out.println(name + " -> min=" + min + " max=" + max);
    }
 
    private static void checkBool(String name, BooleanSupplier f) {
        int trues = 0;
        for (int i = 0; i < N; i++) {
            if (f.getAsBoolean()) {
                trues++;
            }
        }
        System.out.println(name + " -> true " + trues + "/" + N);
    }
}