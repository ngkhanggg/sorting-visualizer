public class BubbleSort extends Sorter {
    public BubbleSort(int[] arr) {
        super(arr);
    }

    public String getName() {
        return "Bubble Sort";
    }

    public void sort() {
        if (!isSorted()) {
            start = System.nanoTime();
            for (int i = 0; i < arr.length-1; i++) {
                for (int j = 0; j < arr.length-i-1; j++) {
                    if (arr[j] > arr[j+1]) {
                        swap(j);
                    }
                    comparisons++;
                }
            }
            end = System.nanoTime();
        }
        else {
            System.out.println("Array is already sorted");
        }
    }
}