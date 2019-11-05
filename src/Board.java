//Nikolaos Alexiadis - 2491021A

public class Board {
    private int rows;
    private int columns;
    private Column[] colArr;

    public Board(int rows, int columns) {
//        Creates a board with the given number of rows and columns
//        Also creates and array of columns and initializes the indices
//        to Column object instances with the given amount of rows
        this.rows = rows;
        this.columns = columns;
        colArr = new Column[this.columns];
        for (int i = 0; i < columns ; i++) {
            colArr[i] = new Column(rows);
        }
    }

    public Column[] getColArr() {
//        Getter for the columns array
        return colArr;
    }

    public boolean add(Counter obj, int colNumber) {
//        Adds a counter to the given column using the add method from the Column class
//        Returns true if successful, false otherwise
        if(colArr[colNumber].add(obj)) return true;
        return false;
    }

    public String toString() {
//        Produces a string representation of the board
        String res = "";
//        Loops through all the columns and appends a vertical line and the column's index to the result String
//        For the last column, also appends a vertical line after the index number
        for (int i = 0; i < columns ; i++) {
            if(i == columns - 1) res += "|" + i + "|";
            else res += "|" + i;
        }
        res += "\n";
        for (int i = 0; i < columns ; i++) {
            res += "--";
        }
        res += "\n";
//        Loops through all positions on the board and appends the corresponding Counter character
//        using the displayRow method from the Column class
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(j == columns - 1) res += "|" + colArr[j].displayRow(i)+ "|";
                else res += "|" + colArr[j].displayRow(i);
            }
            res += "\n";
        }
//        Returns the resulting String
        return res;
    }

    public boolean isFull() {
//        Loops through all the columns of the board and calls the "isFull" method
//        from the Column class on each. If all columns are full, the board is full
//        so the method returns true. Otherwise, returns false
        for (int i = 0; i < columns ; i++) {
            if(!colArr[i].isFull()) return false;
        }
        return true;
    }

    public boolean checkWin(int winCondition) {
//        Loops through all rows and columns, assuring that the current position is not null
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(colArr[j].getArr()[i] != null) {
//                      Checks if the required number of counters exist on the board vertically
                    if(i <= rows - winCondition) {
                        int count = 0;
                        for (int k = 1; k < winCondition; k++) {
                            if (colArr[j].getArr()[i].equals(colArr[j].getArr()[i + k])) {
                                count++;
//                                If the current position matches the desired neighboring ones
//                                "windCondition - 1" times, returns true
                                if(count == winCondition - 1) return true;
                            }
                        }
                    }
//                       Checks if the required number of counters exist on the board horizontally
                    if(j <= columns - winCondition) {
                        int count = 0;
                        for (int k = 1; k < winCondition; k++) {
                            if (colArr[j].getArr()[i].equals(colArr[j + k].getArr()[i])) {
                                count++;
                                if(count == winCondition - 1) return true;
                            }
                        }
                    }
//                       Checks if the required number of counters exist on the first half of the board diagonally
                    if(i <= rows - winCondition && j <= columns - winCondition) {
                        int count = 0;
                        for (int k = 1; k < winCondition; k++) {
                            if (colArr[j].getArr()[i].equals(colArr[j + k].getArr()[i+k])) {
                                count++;
                                if(count == winCondition - 1) return true;
                            }
                        }
                    }
//                       Checks if the required number of counters exist on the second half of the board diagonally
                    if(i <= rows - winCondition && j >=  winCondition - 1) {
                        int count = 0;
                        for (int k = 1; k < winCondition; k++) {
                            if (colArr[j].getArr()[i].equals(colArr[j - k].getArr()[i+k])) {
                                count++;
                                if(count == winCondition - 1) return true;
                            }
                        }
                    }
                }
            }
        }
//        If there is no match returns false
        return false;
    }
}

