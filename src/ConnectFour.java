//Nikolaos Alexiadis - 2491021A

import java.util.Random;

public class ConnectFour {
    public static void main(String[] args) {
//        Task 1 - C
//        Player p1 = new Player( "Clive" , 'x' );
//        Counter c = new Counter(p1);
//        System.out.println(c.getPlayer().toString() + ", " + c.toString());

//        Task 2 - C
//        Column col = new Column( 4 );
//        for ( int i= 0 ;i< 5 ;i++) {
//            Boolean result = col.add( new Counter(p1));
//            System.out.println(result);
//        }

//        Task 2 - E
//        Column col = new Column( 6 );
//        Player p1 = new Player( "Clive" , 'o' );
//        Player p2 = new Player( "Sharon" , 'x' );
//        for ( int i= 0 ;i< 3 ;i++) {
//            col.add( new Counter(p1));
//            col.add( new Counter(p2));
//        }
//        col.display();

//        Task 3 - D
//        Board board = new Board( 6 , 7 );
//        Player p1 = new Player( "Clive" , 'o' );
//        Player p2 = new Player( "Sharon" , 'x' );
//        board.add( new Counter(p2), 6 );
//        board.add( new Counter(p1), 3 );
//        board.add( new Counter(p2), 4 );
//        board.add( new Counter(p1), 4 );
//        board.add( new Counter(p2), 5 );
//        board.add( new Counter(p1), 5 );
//        board.add( new Counter(p2), 6 );
//        board.add( new Counter(p1), 5 );
//        board.add( new Counter(p2), 6 );
//        board.add( new Counter(p1), 6 );
//        System.out.println(board);

        play(6,7,4);
    }

    public static void play(int rows, int columns, int winCondition) {
//        "winCondition" refers to the number of Counters in a line that are required to win
//        Creates a new board with the given number of rows and columns
        Board board = new Board(rows, columns);
//        Creates 2 players with their corresponding symbols
        Player p1 = new Player("Yoda", 'o');
        Player p2 = new Player("Obi-wan", 'x');

//          While the board isn't full, the game will continue
        while(!board.isFull()) {
//              Creates a Random object that will be used to determine players' moves
            Random rand = new Random();

//              Assigns the first player's move randomly to a valid column
            int p1Move = rand.nextInt(columns);
//              While the randomly selected column is full, tries to select another
//              If the board is full and no columns are available breaks out of the loop and continues
            while(board.getColArr()[p1Move].isFull()) {
                p1Move = rand.nextInt(columns);
                if(board.isFull()) break;
            }
//              Adds the player's move to the board
            board.add(new Counter(p1), p1Move);
//              Checks to see if Player1 has won. If yes, then prints the final board and returns
            if(board.checkWin(winCondition)) {
                System.out.println("Player1 - " + p1 + " wins! \n");
                System.out.println(board);
                return;
            }

//              As above, but for Player2
            int p2Move = rand.nextInt(columns);
            while(board.getColArr()[p2Move].isFull()) {
                p2Move = rand.nextInt(columns);
                if(board.isFull()) break;
            }
            board.add(new Counter(p2), p2Move);
            if(board.checkWin(winCondition)) {
                System.out.println("Player2 - " + p2 + " wins! \n");
                System.out.println(board);
                return;
            }

//              If no player has won and the board is full, prints that the game is a draw
            if(board.isFull()) {
                System.out.println("This game is a draw! \n");
                System.out.println(board);
                return;
            }
        }
    }
}
