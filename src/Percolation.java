import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {

    int[] sitesStatus;
    WeightedQuickUnionUF sitesId;
    int numberOfSitesOpen;

    public Percolation(int n) {

        int size = n * n + 2;

        sitesId = new WeightedQuickUnionUF(size);
        sitesStatus = new int[size];
        numberOfSitesOpen = 0;
    }

    public void open(int row, int col) {

        // open site (row, col) if it is not open already
        Validate(row, col);
        int elementIndex = twoDementionalCoordinatesConvertation(row, col);
        if (!isOpen(row, col)) {
            sitesStatus[elementIndex] = 1;
        }
        for (int i = 1; i < 3; i++) {
            if (isIndexCorrect(row*(-1)^i)) {
                if (isOpen((row*(-1)^i)), col) {
                     int neighbourIndex = twoDementionalCoordinatesConvertation();
                    sitesId.union();
                }
            }
        }

    }

    public boolean isOpen(int row, int col) {

        // is site (row, col) open?
        int elementIndex = twoDementionalCoordinatesConvertation(row, col);
        return (sitesStatus[elementIndex] == 1);

    }

    public boolean isFull(int row, int col) {

        // is site (row, col) full?
        // need to check if it is connected to any cell on the top
    }

    public int numberOfOpenSites()       // number of open sites

    public boolean percolates()              // does the system percolate?

    private int twoDementionalCoordinatesConvertation(int row, int col) {

        // converts 2d coordinates into 1d
        int gridSize = (int) Math.sqrt(sitesStatus.length - 2);

        return ((row - 1) * gridSize + col);
    }

    private void Validate(int row, int col) {

        // Checks if row or column indexes are correct
        // throws exception if either is incorrect
        if (!isIndexCorrect(row) || (!isIndexCorrect(col))) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
    }

    private boolean isIndexCorrect(int index) {

        // checks if row or col parameter meets requirements
        int gridSize = (int) Math.sqrt(sitesStatus.length - 2);

        return (index > 0 && index <= gridSize);
    }
}

class Demo {
    //  DON'T FORGET TO CHANGE THE LOCATION OF MAIN
    public static void main(String[] args) {
        int n = StdIn.readInt();
        Percolation check = new Percolation(n);
        int row1 = StdIn.readInt();
        int col1 = StdIn.readInt();
        int row2 = StdIn.readInt();
        int col2 = StdIn.readInt();
        check.open(row1, col1);
        check.open(row2, col2);
        if (check.sitesId.connected(((row1 - 1) * n + col1 - 1), ((row2 - 1) * n + col2 - 1))) {
            System.out.println("It does work");
        }
    }// test client (optional)
}
