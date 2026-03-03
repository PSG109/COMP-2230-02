public class SortingAlgorithms {

    /** Bubble Sort - Stable */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /** Selection Sort */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    /** Insertion Sort - Stable */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /** Merge Sort - Recursive, Stable */
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int i = 0; i < n2; i++) R[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    /** K-th smallest element */
    public static int findKthSmallest(int[] arr, int k) {
        mergeSort(arr, 0, arr.length - 1);
        return arr[k - 1];
    }

    /** K-th largest element */
    public static int findKthLargest(int[] arr, int k) {
        mergeSort(arr, 0, arr.length - 1);
        return arr[arr.length - k];
    }
}

/* 
run the code with the following test cases:
int[] arr1 = {64, 34, 25, 12, 22, 11, 90};

bubbleSort(arr1);
System.out.println("Sorted array: " + Arrays.toString(arr1));   

int[] arr2 = {64, 25, 12, 22, 11};
selectionSort(arr2);
System.out.println("Sorted array: " + Arrays.toString(arr2));

int[] arr3 = {12, 11, 13, 5, 6};
insertionSort(arr3);
System.out.println("Sorted array: " + Arrays.toString(arr3));


int[] arr4 = {38, 27, 43, 3, 9, 82, 10};
mergeSort(arr4, 0, arr4.length - 1);

System.out.println("Sorted array: " + Arrays.toString(arr4));

int[] arr5 = {3, 1, 2, 5, 4};
System.out.println("3rd smallest: " + findKthSmallest(arr5,
3));
System.out.println("2nd largest: " + findKthLargest(arr5,
2));
*/