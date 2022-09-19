public class BubbleSort extends Sorter {
    int arrayIndex = 0, compareIndex;

    public BubbleSort(int[] arr) {
        super(arr);
    }

    public String getName() {
        return "Bubble Sort";
    }

    public void sort() {
        if (arr[compareIndex + 1] < arr[compareIndex]) {
            swap(compareIndex);
        }

        if (compareIndex+1 >= arr.length-arrayIndex-1) {
            arrayIndex++;
            compareIndex = 0;
        }

        else {
            compareIndex++;
        }
    }
}