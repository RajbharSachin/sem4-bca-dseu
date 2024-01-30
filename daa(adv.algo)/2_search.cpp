#include <stdio.h>

// Recursive binary search function
int binary_search(int arr[], int left, int right, int target) {
    // Check base case
    if (right >= left) {
        int mid = left + (right - left) / 2;

        // If the element is present at the middle itself
        if (arr[mid] == target)
            return mid;

        // If element is smaller than mid, then it can only be present in left subarray
        if (arr[mid] > target)
            return binary_search(arr, left, mid - 1, target);

        // Else the element can only be present in right subarray
        return binary_search(arr, mid + 1, right, target);
    }

    // Element is not present in array
    return -1;
}

// Recursive linear search function
int linear_search(int arr[], int left, int right, int target) {
    // Check base case
    if (left > right)
        return -1;

    // If element is present at the current index
    if (arr[left] == target)
        return left;

    // Recursively search the rest of the array
    return linear_search(arr, left + 1, right, target);
}

int main() {
    int arr[] = {2, 5, 7, 9, 12, 16, 18, 22, 24, 26};
    int n = sizeof(arr) / sizeof(arr[0]);
    int target = 18;

    // Perform binary search
    int binary_index = binary_search(arr, 0, n - 1, target);
    if (binary_index == -1) {
        printf("Element not present in array.\n");
    } else {
        printf("Element found at index %d (using binary search).\n", binary_index);
    }

    // Perform linear search
    int linear_index = linear_search(arr, 0, n - 1, target);
    if (linear_index == -1) {
        printf("Element not present in array.\n");
    } else {
        printf("Element found at index %d (using linear search).\n", linear_index);
    }

    return 0;
}
