package org.games;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
public class PlayerStats {
    private Integer gamesPlayed;
    private Map<Move, Integer> moveStats;
    private Map<Result, Integer> resultStats;

    public PlayerStats() {
        gamesPlayed = 0;
        resultStats = new HashMap<>();
        moveStats = new HashMap<>();
        for (Move move : Move.values()) {
            moveStats.put(move, 0);
        }

        for (Result result : Result.values()) {
            resultStats.put(result, 0);
        }
    }

    void updateMoveStats(Move move) {
        moveStats.put(move, moveStats.get(move) + 1);
    }

    void updateResultStats(Result result) {
        log.info("Updating Result : {}", result.name());
        gamesPlayed++;
        resultStats.put(result, resultStats.get(result) + 1);
    }

}
