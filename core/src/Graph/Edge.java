
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Edge
{
    public final Node target;
    public final double weight;
    public Edge(Node tget, double wait)    //given a target node and a weight we have an edge. 
    
    { 
     
    this.target = tget;
    this.weight = wait;
    
    }
}