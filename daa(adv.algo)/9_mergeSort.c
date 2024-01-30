#include <stdio.h>

void printArray(int *A, int n)
{
    for (int i = 0; i < n; i++)
    {
        printf("%d ", A[i]);
    }
    printf("\n");
}

void mergeSort(int A[], int B[], int C[], int m, int n)
{
    int i,j,k;
    i=j=k=0;
    while(i<m && i<n){
        if(A[i]<B[j]){
            C[k] = A[i];
            i++;k++;
        }
        else{
          C[k] = B[j];
          j++;k++; 
        }
    }
    while(i<m){       // Copy all remaining elements from A to C
        C[k] = A[i];
        k++; i++;
    }
    while(j<n){       // """                         from B to C
        C[k] = A[j];
        k++; j++;
    }
}


void merge(int A[], int mid, int low, int high)
{
    int i, j, k, B[100];
    i=low; 
    j=mid+1; 
    k=low;

    while(i<=mid && j<=high){
        if(A[i]<A[j]){
            B[k] = A[i];
            i++;
            k++;
        }
        else{
           B[k] = A[j];
           j++;
           k++; 
        }
    }
    while(i<=mid){       // Copy all remaining elements from A to C
        B[k] = A[i];
        k++; 
        i++;
    }
    while(j<=high){       // """                         from B to C
        B[k] = A[j];
        k++; 
        j++;
    }
    for(i=low; i<=high; i++)
    {
        A[i] = B[i];
    }
}

void mergeSortRec(int A[], int low, int high)
{
    int mid;
    if(low<high){
        mid = (low+high)/2;
        mergeSortRec(A,low,mid);
        mergeSortRec(A,mid+1,high);
        merge(A,mid,low,high);
    }
}

int main() 
{ 
    // Merging two arrays
    int A[] = {7, 8, 11};
    int B[] = {1, 2, 3};
    int C[10];
    int m = sizeof(A) / sizeof(int);
    int n = sizeof(B) / sizeof(int);
    printf("Before Merge Sort:-\n");
    printf("A[]: ");
    printArray(A, m);
    printf("B[]: ");
    printArray(B, n);
    mergeSort(A, B, C, m, n);
    printf("After Merge Sort:- ");
    printArray(C,m+n);
    printf("\n\n");

    // Merge Sort then merge
    int X[] = {3, 5, 2, 13, 12, 3, 2, 13, 45};
    int size = sizeof(X) / sizeof(int);
    int low = 0; 
    int high = size-1; 
    printf("Before Merge Sort in Single Array: ");
    printArray(X, size);
    mergeSortRec(X, low, high);
    printf("After Merge Sort in Single Array:  ");
    printArray(X, size);

    return 0;
}