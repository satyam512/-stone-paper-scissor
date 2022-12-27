package org.games;

import lombok.Data;

@Data
public class Player {
    private String playerName;
    private InputProvider inputProvider;
    private PlayerStats playerStats;
    public Player(String playerName, InputProvider inputProvider) {
        playerStats = new PlayerStats();
        this.playerName = playerName;
        this.inputProvider = inputProvider;
    }

    public Move makeMove() {
        Move currentMove = inputProvider.makeMove();
        playerStats.updateMoveStats(currentMove);
        return currentMove;
    }

    public PlayerStats getPlayerStats() {
        return playerStats;
    }

    public void updatePlayerStats(Result result) {
        playerStats.updateResultStats(result);
    }
}
