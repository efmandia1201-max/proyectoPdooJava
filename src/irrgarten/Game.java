/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author francisco
 */
public class Game {
    private static final int MAX_ROUNDS = 10;
    private int currentPlayerIndex;
    private String log;
    
    public Game(int nplayers) {
        currentPlayerIndex = nplayers;
    }
    
    public boolean finished() {
        throw new UnsupportedOperationException();
    }
    
    public boolean nextStep(Directions preferredDirection) {
        throw new UnsupportedOperationException();
    }
    
    public GameState getGameState() {
        throw new UnsupportedOperationException();
    }
    
    // ################ MÉTODOS PRIVADOS ################
    private void configureLabyrinth() {
        
    }
    
    private void nextPlayer() {
        
    }
}
