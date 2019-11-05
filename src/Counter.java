//Nikolaos Alexiadis - 2491021A

public class Counter {
    private Player player;
    public Counter(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean equals(Object obj) {
//      Checks if the input parameter is of type Counter.
//      If so, returns true if the input Counter has the same player as the instance, false otherwise.
        if(obj instanceof  Counter) {
            Counter other = (Counter) obj;
            return this.getPlayer() == other.getPlayer();
        }
        return false;
    }

    public String toString() {
//      Returns the player's symbol in String format
        return String.valueOf(player.getSymbol());
    }
}
