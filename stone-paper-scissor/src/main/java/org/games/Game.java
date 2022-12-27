package org.games;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class Game {
    private Integer rounds;
    private Player player1;
    private Player player2;

    public boolean isPlayer1Win(Move player1Move, Move player2Move) {
        return player1Move.equals(Move.STONE) && player2Move.equals(Move.SCISSORS)
                || (player1Move.equals(Move.SCISSORS) && player2Move.equals(Move.PAPER))
                || (player1Move.equals(Move.PAPER) && player2Move.equals(Move.STONE));
    }

    public Game(Player player1, Player player2) {
        rounds = 0;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void playGameRound() {
        rounds++;
        Move player1move = player1.makeMove();
        Move player2move = player2.makeMove();

        if(player1move.equals(Move.INVALID)) {
            System.out.println("Invalid move made ... ");
            return;
        }

        log.info("{} Move is {}", player1.getPlayerName(), player1move.getValue());
        log.info("{} Move is {}", player2.getPlayerName(), player2move.getValue());

        if(player2move.getValue().equals(player1move.getValue())) {
            player1.updatePlayerStats(Result.DRAW);
            player2.updatePlayerStats(Result.DRAW);
            System.out.println("Game ended in Draw");
            return;
        }

        if(isPlayer1Win(player1move, player2move)) {
            System.out.println("here ");
            player1.updatePlayerStats(Result.WIN);
            player2.updatePlayerStats(Result.LOSE);
            System.out.println("Winner is : " + player1.getPlayerName());
            return;
        }

        player1.updatePlayerStats(Result.LOSE);
        player2.updatePlayerStats(Result.WIN);
        System.out.println("Winner is : " + player2.getPlayerName());
    }
}
