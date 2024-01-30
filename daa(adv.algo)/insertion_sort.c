#include <stdio.h>

void insertionSort(int arr[], int n) {
    int i, key, j;
    for(i=1; i<n; i++)
    {
        key = arr[i]; //1 2
        j = i-1; //0 1

        while(j>=0 && arr[j] > key) {
            arr[j+1] = arr[j];
            j=j-1;
        }
        arr[j+1] = key;
    }
}

int main() {
    int arr[] = {12, 31, 25, 8, 32, 17};
    int n = sizeof(arr)/sizeof(arr[0]);

    insertionSort(arr, n);

    for(int i=0; i<n; i++){
        printf("%d ", arr[i]);
    }
    return 0;
}