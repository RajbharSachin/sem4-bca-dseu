#include <stdio.h>

void printArray(int* A, int n){
    for(int i = 0; i < n; i++)
    {
        printf("%d ", A[i]);
    }
    printf("\n");
}

void insertionSort(int *A, int n){
    int key, j;
    for(int i = 1; i<n; ++i)
    {
        key = A[i]; //All key insert one by one
        j = i-1;
        // Loop for each pass
        while(j>=0 && A[j] > key){ // > for ascending
            A[j+1] = A[j]; 
            j--;
        }
        
        A[j+1] = key;
        printArray(A, n); // printing every pass

    }
} 
int main(){
    //  -1  0    1    2    3   4    5
    //      12,  54,  65,  7,  23,  9
    int A[] = {12, 54, 65, 7, 23, 9};
    int n = sizeof(A)/sizeof(int);
    printf("Original Array:- ");
    printArray(A, n);
    insertionSort(A, n);
    printf("Sorted Array:- ");
    printArray(A, n);
    return 0;
}