package com.TeamHEC.LocomotionCommotion.Goal.Graph;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.TeamHEC.LocomotionCommotion.Map.Station;

class Node implements Comparable<Node>
{
  
  public final MapObj mapobj;
 public Node(MapObj st) 
    {
     this.mapobj = st;  //sets name of node to name of station
       
     this.edges = new ArrayList<Edge>(); 
    } 
   
 public ArrayList<Edge> edges;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Node previous;    
    
   
    public MapObj getMapObj() 
    {
     return mapobj; //returns name of node
    }
    
    
    public int compareTo(Node other)
    {
        return Double.compare(this.minDistance, other.minDistance); //compares this distance to anotdher node
    }
 
 
}
