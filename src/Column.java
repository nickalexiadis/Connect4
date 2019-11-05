//Nikolaos Alexiadis - 2491021A

public class Column {
    private int numRows;
    private Counter[] arr;
    public Column(int numRows) {
//        Creates a column object, storing the number of rows and an array of Counter objects
        this.numRows = numRows;
        arr = new Counter[this.numRows];
    }

    public boolean isFull() {
//        Checks if the first(top) element of the array is empty
//        If it is, the column isn't full, so the method returns false
//        If the top element isn't empty, the column is full, so the method returns true
        if(arr[0] == null) return false;
        return true;
    }

    public boolean add(Counter obj) {
//        Loops through all the rows of the column array, starting at the end(bottom)
//        If the row is empty, adds the Counter at that index and returns true
//        If the row isn't empty, the loop continues until the top of the column
//        If the column is full, returns false
        for(int i = this.numRows - 1; i >= 0; i--) {
            if(arr[i] == null) {
                arr[i] = obj;
                return true;
            }
        }
        return false;
    }

    public String displayRow(int rowNumber) {
//        Returns a String with the Counter character at the given row, using the toString method from the Counter class
//        If there is no Counter at that row, returns a String with a space character
        if(arr[rowNumber] == null) return " ";
        else return arr[rowNumber].toString();
    }

    public void display() {
//        Loops through all the rows of the column instance
//        and prints the corresponding String using the displayRow method
        for (int i = 0; i < this.numRows ; i++) {
            System.out.println(displayRow(i));
        }
    }

    public Counter[] getArr() {
//        Getter for the array of Counters
        return arr;
    }
}
