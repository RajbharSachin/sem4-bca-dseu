#include <stdio.h>

// Function to perform binary search recursively
int binary_search_rec(int arr[], int left, int right, int x) {
    if (left <= right) {
        int mid = left + (right - left) / 2;

        // If the element is present at the middle itself
        if (arr[mid] == x)
            return mid;

        // If element is smaller than mid, then it can only be present in left subarray
        if (arr[mid] > x)
            return binary_search_rec(arr, left, mid - 1, x);

        // Else the element can only be present in right subarray
        return binary_search_rec(arr, mid + 1, right, x);
    }

    // Element is not present in array
    return -1;
}

// Function to perform binary search non-recursively
int binary_search_nonrec(int arr[], int n, int x) {
    int left = 0, right = n - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        // If the element is present at the middle itself
        if (arr[mid] == x)
            return mid;

        // If element is smaller than mid, then it can only be present in left subarray
        if (arr[mid] > x)
            right = mid - 1;

        // Else the element can only be present in right subarray
        else
            left = mid + 1;
    }

    // Element is not present in array
    return -1;
}

// Function to print an array
void print_array(int arr[], int n) {
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int main() {
    int arr[] = {2, 3, 4, 10, 40};
    int n = sizeof(arr) / sizeof(arr[0]);
    int x = 10;

    printf("Original array:\n");
    print_array(arr, n);

    // Perform binary search recursively
    int result_rec = binary_search_rec(arr, 0, n - 1, x);
    if (result_rec == -1)
        printf("%d not found recursively in the array\n", x);
    else
        printf("%d found recursively at index %d\n", x, result_rec);

    // Perform binary search non-recursively
    int result_nonrec = binary_search_nonrec(arr, n, x);
    if (result_nonrec == -1)
        printf("%d not found non-recursively in the array\n", x);
    else
        printf("%d found non-recursively at index %d\n", x, result_nonrec);

    return 0;
}
