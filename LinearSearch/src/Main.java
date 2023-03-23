public class Main {
    public static void main(String[] args) {

        // Linear Search - Iterate through a collection one element at a time

        // runtime complexity: O(n)

        // disadvantages ?
        // 1. Slow for large data sets

        // advantages ?
        // 1. Fast for searches of small to medium data sets
        // 2. Does not need to be sorted
        // 3. Useful for data structures that do not have random access (Linked List)

        int[] array = {9, 5, 6, 7, 1, 0, 15, 23, 2};

        int index = linearSearch(array, 1);

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
    }

    private static int linearSearch(int[] array, int value) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        return -1;
    }
}