package com.TeamHEC.LocomotionCommotion.Goal.Graph;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.Map.MapObj;
public class Node implements Comparable<Node>
{
  
 public final MapObj mapobj;
 
 public Node(MapObj st) 
    {
     this.mapobj = st;  //sets node to the station/junction passed
       
     this.edges = new ArrayList<Edge>(); 
    } 
   
 	public ArrayList<Edge> edges;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Node previous;    
    
   
    public MapObj getMapObj() 
    {
     return mapobj; // not really needed as mapobj is public 
    }
    
    
    public int compareTo(Node other)
    {
        return Double.compare(this.minDistance, other.minDistance); //compares this distance to anotdher node
    }
 
 
}
