public class SelectionSort extends Sorter {
    private int arrayIndex = 0, compareIndex = arrayIndex + 1;

    public SelectionSort(int[] arr) {
        super(arr);
    }

    @Override
    public String getName() {
        return "Selection Sort";
    }

    public void sort() {
        if (arr[compareIndex] < arr[arrayIndex]) {
            swap(arrayIndex, compareIndex);
            comparisons++;
        }

        if (compareIndex+1 >= arr.length) {
            arrayIndex++;
            compareIndex = arrayIndex + 1;
        }
        else {
            compareIndex++;
        }
    }
}
