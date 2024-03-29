package com.psl.gems.play;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players;
    private Pack pack;
   
    public Game() {
        this.players = new ArrayList<>();
        this.pack = new Pack();
    }

    public void registerPlayer(Player player) {
        players.add(player);
    }
    
    public List<Player> getPlayers(){
    	return players;
    }

    public void play() {
        // Shuffle the pack
        pack.shuffle();

        // Deal 3 cards to each player
       
            for (int i = 0; i < 3; i++) {
            	 for (Player player : players) {
            		 
                  player.addCard(pack.draw());
            }
        }

        // Determine the winner
        Player winner = determineWinner();

        // Print the result
        System.out.println("The winner is " + winner.getName() + " with " + winner.getHighestCard().toString());
    }

    private Player determineWinner() {
        Player winner = players.get(0);

        for (int i = 1; i < players.size(); i++) {
            Player currentPlayer = players.get(i);
            if (currentPlayer.getHighestCard().getValue() > winner.getHighestCard().getValue()) {
                winner = currentPlayer;
            }
        }

        return winner;
    }

}