public abstract class Sorter {
    protected int comparisons;
    protected int[] arr;

    public Sorter(int[] arr) {
        this.arr = arr;
        this.comparisons = 0;
    }

    public abstract String getName();

    public int getComparisons() {
        return comparisons;
    }

    public boolean isSorted() {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1] < arr[i]) return false;
        }
        return true;
    }

    public abstract void sort();

    public void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public String toString() {
        return String.format("Sorting Algorithm: %s\nComparisons: %s times", getName(), getComparisons());
    }
}