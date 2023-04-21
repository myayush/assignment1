package com.psl.gems.client;

import com.psl.gems.play.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TestClient {

    public static void main(String[] args) {
        // Create a new game
        Game game = new Game();

        // Register two players
        Player suresh = new Player("Suresh");
        Player ramesh = new Player("Ramesh");
        game.registerPlayer(suresh);
        game.registerPlayer(ramesh);

        // Start the game
        game.play();

        // Write the output to cardgame.html
        try {
            FileWriter writer = new FileWriter("cardgame.html");
            writer.write("<!DOCTYPE html>\n");
            writer.write("<html lang=\"en\">\n");
            writer.write("<head>\n");
            writer.write("<title>Document</title>\n");
            writer.write("</head>\n");
            writer.write("<body>\n");
            writer.write("<section>\n");

            for (Player player : game.getPlayers()) {
                writer.write("<div id=\"" + player.getName() + "\">\n");
                ArrayList<Card> cards = player.getCardsInHand();
                for (Card card : cards) {
                    writer.write("<div data-card=\"" + card.toString() + "\" />\n");
                }
                writer.write("</div>\n");
            }

            writer.write("</section>\n");
            writer.write("</body>\n");
            writer.write("</html>\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to cardgame.html");
            e.printStackTrace();
        }
    }
}
