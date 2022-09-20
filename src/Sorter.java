public abstract class Sorter {
    protected Visualizer array;
    protected int comparisons;

    public Sorter(Visualizer array) {
        this.array = array;
        this.comparisons = 0;
    }

    public abstract String getName();

    public int getComparisons() {
        return comparisons;
    }

    public boolean isSorted() {
        for (int i = 0; i < array.getArraySize()-1; i++) {
            if (array.getValue(i+1) < array.getValue(i)) return false;
        }
        return true;
    }

    public abstract void sort();

    public String toString() {
        String s1, s2;
        s1 = String.format("Sorting Algorithm: %s\n", getName());
        s2 = String.format("Comparisons: %s times\n", getComparisons());
        return s1+s2;
    }
}