package org.games;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Data
@Slf4j
@NoArgsConstructor
public class HumanInputProvider implements InputProvider{
    private Scanner scanner = new Scanner(System.in);
    @Override
    public Move makeMove() {
        System.out.println("Choose the move :\n 1. Stone, \n 2. Paper, \n 3. Scissors");
        Integer moveValue = scanner.nextInt() - 1;

        if(moveValue >=0 && moveValue < 3) {
            Move computerMove = Move.values()[moveValue];
            return computerMove;
        }
        log.info("{} move is selected. ", Move.INVALID.name());
        return Move.INVALID;
    }
}
