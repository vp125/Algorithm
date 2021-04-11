package miu.edu.cs435.lab11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphList {
    private HashMap<Character, List<Character>> graph;

    GraphList(){
        graph = new HashMap<>();
    }

    void addVertex(char vertex){
        graph.put(vertex, new ArrayList<Character>());
    }

    void addEdge(char vertex1, char vertex2){
        if(!graph.containsKey(vertex1)){
            System.out.println("Cannot find vertex " + vertex1 + " in graph");
            return;
        }
        if(!graph.containsKey(vertex2)){
            System.out.println("Cannot find vertex " + vertex2 + " in graph");
            return;
        }
        graph.get(vertex1).add(vertex2);
        graph.get(vertex2).add(vertex1);
    }
}
