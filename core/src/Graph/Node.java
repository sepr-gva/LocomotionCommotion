
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import com.TeamHEC.LocomotionCommotion.Map.Station;

class Node implements Comparable<Node>

{
  public String name;
  public final Station station;
 public Node(Station st) 
    {
     this.station = st;  //sets name of node to name of station
     this.name = st.getName();  
     this.edges = new ArrayList<Edge>(); 
    } 
   
 public ArrayList<Edge> edges;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Node previous;
    
    
   
    public String toString() 
    {
     return name; //returns name of node
    }
    
    
    public int compareTo(Node other)
    {
        return Double.compare(this.minDistance, other.minDistance); //compares this distance to anotdher node
    }
 
 
}
