public class BubbleSort extends Sorter {
    private int arrayIndex = 0, compareIndex;

    public BubbleSort(Visualizer array) {
        super(array);
    }

    public String getName() {
        return "Bubble Sort";
    }

    public void sort() {
        if (array.getValue(compareIndex + 1) < array.getValue(compareIndex)) {
            array.swap(compareIndex + 1, compareIndex);
            comparisons++;
        }

        if (compareIndex+1 >= array.getArraySize()-arrayIndex-1) {
            arrayIndex++;
            compareIndex = 0;
        }

        else {
            compareIndex++;
        }
    }
}