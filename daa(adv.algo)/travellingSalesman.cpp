#include <stdio.h> 
#include <stdlib.h> 
#include <limits.h>

#define MAX_CITIES 10

int distanceMatrix[MAX_CITIES][MAX_CITIES];
int numCities;
int bestPath[MAX_CITIES];
int bestCost = INT_MAX;

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

void permute(int *path, int start, int end)
{
    if (start == end)
    {
        int currentCost = 0;

        for (int i = 0; i < numCities - 1; i++)
        {

            currentCost += distanceMatrix[path[i]][path[i + 1]];
        }

        currentCost += distanceMatrix[path[numCities - 1]][path[0]]; // return to starting city

        if (currentCost < bestCost)
        {
            bestCost = currentCost;
            for (int i = 0; i < numCities; i++)
            {
                bestPath[i] = path[i];
            }
        }
    }

    else
    {

        for (int i = start; i <= end; i++)
        {
            swap(&path[start], &path[i]);
            permute(path, start + 1, end);
            swap(&path[start], &path[i]); // backtrack
        }
    }
}

void solveTSP()
{
    int path[MAX_CITIES];

    for (int i = 0; i < numCities; i++)
    {
        path[i] = i;
    }

    permute(path, 0, numCities - 1);
}

int main()
{

    printf("Enter the number of cities: ");
    scanf("%d", &numCities);

    printf("Enter the distance matrix:\n");
    for (int i = 0; i < numCities; i++)
    {
        for (int j = 0; j < numCities; j++)
        {
            scanf("%d", &distanceMatrix[i][j]);
        }
    }

    solveTSP();

    printf("Best Path: ");

    for (int i = 0; i < numCities; i++)
    {
        printf("%d ", bestPath[i]);
    }

    printf("\nBest Cost: %d\n", bestCost);

    return 0;
}
