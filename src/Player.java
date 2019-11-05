//Nikolaos Alexiadis - 2491021A

public class Player {
    private String name;
    private char symbol;
    public Player(String name, char symbol) {
//      Creates a player, storing their name and symbol
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public String toString() {
        return this.name;
    }
}
