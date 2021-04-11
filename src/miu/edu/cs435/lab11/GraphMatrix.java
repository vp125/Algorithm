package miu.edu.cs435.lab11;

import java.util.*;

public class GraphMatrix {
    private char[][] matrix;
    private List<Character> component;
    private boolean[] visited;

    GraphMatrix(char n){
        matrix = new char[n][n];
        component = new ArrayList<>();
        visited = new boolean[n];
    }

    GraphMatrix(char a[][]){
        matrix = new char[a.length][a.length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                matrix[i][j] = a[i][j];
            }
        }
        component = new ArrayList<>();
        visited = new boolean[a.length];
    }

    void addEdge(int v1, int v2){
        if(v1 > matrix.length) {
            System.out.println("Vector v1 index is out of range!");
            return;
        }
        if(v2 > matrix.length) {
            System.out.println("Vector v2 index is out of range!");
        }
        matrix[v1][v2] = 1;
        matrix[v2][v1] = 1;
    }

    void printComponent(){
        System.out.print("Component: { ");
        for(char i : component) {
            int c = i + 65;
            System.out.print("" + String.valueOf(Character.valueOf((char)c)) + " ");
        }
        System.out.println("}");
    }

    void dfs(char v) {
        visited[v] = true;
        component.add(v);
        for(char i=0;i<matrix.length;i++) {
            if(matrix[v][i] == 1){ // edge bw v <--> i found
                if(visited[i] == false) {
                    dfs(i);
                }
            }
        }
    }

    void bfs(char v) {
        Queue<Character> Q = new ArrayDeque<>();
        Q.add(v);
        visited[v] = true;
        while(!Q.isEmpty()){
            char u = Q.remove();
            component.add(u);
            for(char i=0;i<matrix.length;i++){
                if(matrix[u][i] == 1) { // edge bw u <--> i found
                    if (visited[i] == false) {
                        Q.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
    }

    void findComponentsDFS() {
        // clear previous visited
        for(int i=0;i<matrix.length;i++){
            visited[i] = false;
        }
        for(char i=0;i<matrix.length;i++){
            if(visited[i] == false){
                component.clear();
                dfs(i);
                printComponent();
            }
        }
    }

    void findComponentsBFS() {
        // clear previous visited
        for(int i=0;i<matrix.length;i++){
            visited[i] = false;
        }
        for(char i=0;i<matrix.length;i++){
            if(visited[i] == false){
                component.clear();
                bfs(i);
                printComponent();
            }
        }
    }

    public static void main(String[] args) {
        char a[][] =
                {
                        {0, 1, 1, 0, 0, 1, 0, 0, 0},
                        {1, 0, 0, 0, 0, 1, 0, 0, 0},
                        {1, 0, 0, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 1},
                        {0, 0, 0, 1, 0, 0, 0, 0, 1},
                        {1, 1, 1, 0, 0, 0, 0, 1, 0},
                        {0, 0, 1, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 1, 1, 0, 0, 0, 0},
                };

        GraphMatrix gp = new GraphMatrix(a);
        System.out.println("Found Components by DFS");
        gp.findComponentsDFS();
        System.out.println("");
        System.out.println("Found Components by BFS");
        gp.findComponentsBFS();
    }
}
