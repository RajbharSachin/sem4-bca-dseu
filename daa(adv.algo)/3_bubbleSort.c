#include <stdio.h>

void printArray(int* A, int n){
    for(int i = 0; i < n; i++)
    {
        printf("%d ", A[i]);
    }
    printf("\n");
}

void bubbleSort(int* A, int n){
    int isSorted = 0;
    for(int i = 0; i<n-1; ++i) // (n-1) Passes
    {
        printf("Working on pass number %d\n", i+1); 
        isSorted = 1;
        for(int j=0; j<n-1-i; j++) // Comparisons in each pass
        {
            if(A[j]>A[j+1])
            {
                A[j+1] = A[j+1]+A[j];
                A[j] = A[j+1]-A[j];
                A[j+1] = A[j+1]-A[j];
                isSorted = 0;
            }
        }
        if(isSorted){
            return;
        }
        printArray(A, n); // printing every pass
    }
}

int main(){
    int A[] = {12, 54, 65, 7, 23, 9};
    // int A[] = {1, 2, 3, 4, 5,6};
    int n = sizeof(A)/sizeof(int);
    printf("Original Array:- ");
    printArray(A, n); // Printing before sorting
    bubbleSort(A, n);
    printArray(A, n); // Printing after sorting
    return 0;
}