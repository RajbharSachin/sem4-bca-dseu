#include <stdio.h>

// Number of vertices in the graph
#define V 5

// Utility function to find the vertex with minimum distance value
int min_distance(int dist[], int visited[]) {
    int min = __INT_MAX__, min_index;

    for (int i = 0; i < V; i++) {
        if (visited[i] == 0 && dist[i] < min) {
            min = dist[i];
            min_index = i;
        }
    }

    return min_index;
}

// Function to print the minimum spanning tree
void print_mst(int parent[], int graph[V][V]) {
    printf("Minimum Spanning Tree:\n");
    for (int i = 1; i < V; i++)
        printf("%d - %d\t%d\n", parent[i], i, graph[i][parent[i]]);
}

// Function to find the minimum spanning tree using Prim's algorithm
void prim_mst(int graph[V][V]) {
    int parent[V];
    int dist[V];
    int visited[V];

    for (int i = 0; i < V; i++) {
        dist[i] = __INT_MAX__;
        visited[i] = 0;
    }

    dist[0] = 0;
    parent[0] = -1;

    for (int i = 0; i < V - 1; i++) {
        int u = min_distance(dist, visited);
        visited[u] = 1;

        for (int v = 0; v < V; v++) {
            if (graph[u][v] && visited[v] == 0 && graph[u][v] < dist[v]) {
                parent[v] = u;
                dist[v] = graph[u][v];
            }
        }
    }

    print_mst(parent, graph);
}

int main() {
    // Graph represented as adjacency matrix
    int graph[V][V] = {{0, 2, 0, 6, 0},
                       {2, 0, 3, 8, 5},
                       {0, 3, 0, 0, 7},
                       {6, 8, 0, 0, 9},
                       {0, 5, 7, 9, 0}};

    prim_mst(graph);

    return 0;
}
