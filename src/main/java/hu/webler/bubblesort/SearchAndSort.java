package hu.webler.bubblesort;

import java.util.Arrays;

public class SearchAndSort {

    public static void main(String[] args) {

        binarySearchExample();
        bubbleSortExample();
    }

    public static void binarySearchExample() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 6;

        int result = binarySearch(arr, target);

        System.out.println("Binary Search Result: " + result);
    }

    public static void bubbleSortExample() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Before Bubble Sort: " + Arrays.toString(arr));

        bubbleSort(arr);

        System.out.println("After Bubble Sort: " + Arrays.toString(arr));
    }

    public static int binarySearch(int arr[], int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        return -1; // Target not found
    }

    public static void bubbleSort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}