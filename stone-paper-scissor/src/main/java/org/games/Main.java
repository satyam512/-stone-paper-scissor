package org.games;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static HumanInputProvider humanInputProvider= new HumanInputProvider();
    private static ComputerInputProvider computerInputProvider= new ComputerInputProvider();
    public static void main(String[] args) {

        System.out.printf("Enter you player name : ");
        String playerName = scanner.nextLine();
        Player player1 = new Player(playerName, humanInputProvider);
        Player player2 = new Player("Computer Player", computerInputProvider);

        Game game = new Game(player1, player2);
        String nextInput = "Continue";

        while(!(nextInput.equalsIgnoreCase("quit") || (nextInput.equalsIgnoreCase("exit")))) {
            System.out.println("Game number : " + (game.getRounds() + 1));
            game.playGameRound();
            System.out.println("Enter quit/exit to quit");
            nextInput = scanner.nextLine();
        }
        System.out.println("Player Stats are : " + player1.getPlayerStats());
        System.out.println("Hello world!");
    }
}