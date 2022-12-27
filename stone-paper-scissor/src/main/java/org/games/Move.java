package org.games;

import lombok.Data;

public enum Move {
    STONE("stone"),
    PAPER("paper"),
    SCISSORS("scissors"),

    INVALID("Invalid Move");

    private String value;

    Move(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
