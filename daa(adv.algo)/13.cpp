#include <stdio.h>
#include <stdlib.h>

// Structure to represent an edge in the graph
struct Edge {
    int src, dest, weight;
};

// Structure to represent a subset for union-find
struct Subset {
    int parent;
    int rank;
};

// Comparator function to use in sorting the edges by weight
int comparator(const void* p1, const void* p2) {
    struct Edge* edge1 = (struct Edge*)p1;
    struct Edge* edge2 = (struct Edge*)p2;
    return edge1->weight - edge2->weight;
}

// Function to find the parent of a subset (uses path compression)
int find(struct Subset subsets[], int i) {
    if (subsets[i].parent != i)
        subsets[i].parent = find(subsets, subsets[i].parent);
    return subsets[i].parent;
}

// Function to perform union of two subsets (uses union by rank)
void unionSet(struct Subset subsets[], int x, int y) {
    int xroot = find(subsets, x);
    int yroot = find(subsets, y);
    if (subsets[xroot].rank < subsets[yroot].rank)
        subsets[xroot].parent = yroot;
    else if (subsets[xroot].rank > subsets[yroot].rank)
        subsets[yroot].parent = xroot;
    else {
        subsets[yroot].parent = xroot;
        subsets[xroot].rank++;
    }
}

// Function to find the minimum cost spanning tree using Kruskal's Algorithm
void kruskalMST(int V, int E, struct Edge edges[]) {
    struct Edge result[V]; // Stores the resultant MST
    int e = 0; // Index variable for result[]
    int i = 0; // Index variable for sorted edges array

    // Sort all the edges in non-decreasing order of their weight
    qsort(edges, E, sizeof(struct Edge), comparator);

    // Allocate memory for creating V subsets
    struct Subset* subsets = (struct Subset*)malloc(V * sizeof(struct Subset));

    // Create V subsets with single elements
    for (int v = 0; v < V; v++) {
        subsets[v].parent = v;
        subsets[v].rank = 0;
    }

    // Keep adding edges to the MST until V-1 edges are added
    while (e < V - 1 && i < E) {
        struct Edge next_edge = edges[i++];

        int x = find(subsets, next_edge.src);
        int y = find(subsets, next_edge.dest);

        // If including this edge doesn't form a cycle, add it to the MST
        if (x != y) {
            result[e++] = next_edge;
            unionSet(subsets, x, y);
        }
    }

    // Print the edges of the MST
    printf("Minimum Cost Spanning Tree:\n");
    int minCost = 0;
    for (i = 0; i < e; i++) {
        printf("%d -- %d == %d\n", result[i].src, result[i].dest, result[i].weight);
        minCost += result[i].weight;
    }
    printf("Minimum Cost: %d\n", minCost);
}

// Driver code
int main() {
    int V = 4; // Number of vertices
    int E = 5; // Number of edges

    struct Edge edges[] = { {0, 1, 10}, {0, 2, 6}, {0, 3, 5}, {1, 3, 15}, {2, 3, 4} };

    kruskalMST(V, E, edges);

    return 0;
}
