package org.games;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Data
@Slf4j
public class ComputerInputProvider implements InputProvider{
    private Random random = new Random();
    @Override
    public Move makeMove() {
        System.out.println("Choosing the move ...");
        int randomNumber = random.nextInt(3);
        Move computerMove = Move.values()[randomNumber];
        return computerMove;
    }
}
