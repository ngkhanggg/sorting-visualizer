public class SelectionSort extends Sorter {
    private int arrayIndex = 0, compareIndex = arrayIndex + 1;

    public SelectionSort(Visualizer array) {
        super(array);
    }

    @Override
    public String getName() {
        return "Selection Sort";
    }

    public void sort() {
        if (array.getValue(compareIndex) < array.getValue(arrayIndex)) {
            array.swap(arrayIndex, compareIndex);
            comparisons++;
        }

        if (compareIndex+1 >= array.getArraySize()) {
            arrayIndex++;
            compareIndex = arrayIndex + 1;
        }
        
        else {
            compareIndex++;
        }
    }
}
