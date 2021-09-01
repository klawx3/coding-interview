package cl.klawx3.datastructure.graph;

import java.util.HashMap;
import java.util.Map;

public class GVertex {
    private String value;
    private Map<GVertex, Integer> adjacentVertex;
    
    public GVertex(String value){
        this.value = value;
        adjacentVertex = new HashMap<>();
    }

    public void addAdjacentVertex(GVertex otherVertex, int weight){
        adjacentVertex.put(otherVertex, weight);
    }
}
