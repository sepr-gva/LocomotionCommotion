package com.TeamHEC.LocomotionCommotion.Goal.Graph;

public class Edge
{
    public final Node target;
    public final float weight;
    public Edge(Node tget, float weight)    //given a target node and a weight we have an edge. 
    
    { 
     
    this.target = tget;
    this.weight = weight;
    
    }
}