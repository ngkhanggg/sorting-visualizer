public abstract class Sorter {
    protected long start, end;
    protected int comparisons;
    protected int[] arr;

    public Sorter(int[] arr) {
        this.arr = arr;
        this.comparisons = 0;
    }

    public abstract String getName();

    public long getExecutionTime() {
        return end-start;
    }

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

    public void swap(int index) {
        int temp = arr[index];
        arr[index] = arr[index+1];
        arr[index+1] = temp;
    }

    public String toString() {
        return String.format("Sorting Algorithm: %s\nExecution Time: %s nanoseconds\nComparisons: %s times", getName(), getExecutionTime(), getComparisons());
    }
}