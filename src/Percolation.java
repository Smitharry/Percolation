import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {

    private WeightedQuickUnionUF grid;
    private boolean[] siteIsOpen;
    private int gridSize;
    private int numberOfSitesOpen;

    public Percolation(int n) {
        gridSize = n;
        siteIsOpen = new boolean[gridSize^2];
        grid = new WeightedQuickUnionUF( gridSize^2 + 2 );
        numberOfSitesOpen = 0;
    }

    private int getIndex (int row, int col) {
        return (row - 1)*gridSize  + col;
    }

    private void connectToNeighbours (int row, int col) {

        int checkedIndex;
        int siteIndex = getIndex(row, col);
        if (isValidIndex(row - 1) && isValidIndex(col) && isOpen(row - 1, col)) {
            checkedIndex = getIndex(row - 1, col);
            grid.union(checkedIndex, siteIndex);
        }

        if (isValidIndex(row + 1) && isValidIndex(col) && isOpen(row + 1, col)) {
            checkedIndex = getIndex(row + 1, col);
            grid.union(checkedIndex, siteIndex);
        }

        if (isValidIndex(row) && isValidIndex(col - 1) && isOpen(row, col - 1)) {
            checkedIndex = getIndex(row, col - 1);
            grid.union(checkedIndex, siteIndex);
        }

        if (isValidIndex(row) && isValidIndex(col + 1) && isOpen(row, col + 1)) {
            checkedIndex = getIndex(row, col + 1);
            grid.union(checkedIndex, siteIndex);
        }

    }
    private boolean isValidIndex (int index) {
        return (index > 0 && index <= gridSize);
    }
    public void open(int row, int col) {

        // Доделать соединение с соседями
        if (!isValidIndex(row) || !isValidIndex(col))
            return;

        int index = getIndex(row, col) - 1;
        if (!isOpen(row, col))
            siteIsOpen[index] = true;

        numberOfSitesOpen++;

        connectToNeighbours(row, col);

    }

    public boolean isOpen(int row, int col) {
        int index = getIndex(row, col) - 1;
        return siteIsOpen[index];
    }
}

