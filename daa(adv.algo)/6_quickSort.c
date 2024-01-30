#include <stdio.h>

void printArray(int *A, int n)
{
    for (int i = 0; i < n; i++)
    {
        printf("%d ", A[i]);
    }
    printf("\n");
}

int partition(int A[], int low, int high) // Partition and swap
{
    int pivot = A[low];
    int i = low + 1;
    int j = high;
    int temp;

    do
    {
        while (A[i] <= pivot)
        {
            i++;
        }

        while (A[j] > pivot)
        {
            j--;
        }

        if (i < j)
        {
            temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    } while (i < j);

    // Swap A[low] and A[j]
    temp = A[low];
    A[low] = A[j];
    A[j] = temp;
    return j;

}

void quickSort(int A[], int low, int high)
{
    int partitionIndex; // Index of pivot after partition
    int pass=1;

    if (low < high)
    {
        partitionIndex = partition(A, low, high);
        printArray(A,9);
        quickSort(A, low, partitionIndex - 1);  // sort left subarray first n
        quickSort(A, partitionIndex + 1, high); // sort right subarray
    }
}

int main()
{
    int A[] = {3, 5, 2, 13, 12, 3, 2, 13, 45};
    // 3, 5, 2, 13, 12, 3, 2, 13, 45

    // 3, 2i, 2, 13, 12, 3, 5j, 13, 45
    // 3, 2, 2, 13i, 12, 3j, 5, 13, 45
    // 3, 2, 2, 3j, 12i, 13, 5, 13, 45 --> firs call to partition returns 3
    int n = sizeof(A) / sizeof(int);
    printf("Before Quick Sort: ");
    printArray(A, n);
    quickSort(A, 0, n - 1);
    printf("After Quick Sort:  ");
    printArray(A, n);
    return 0;
}