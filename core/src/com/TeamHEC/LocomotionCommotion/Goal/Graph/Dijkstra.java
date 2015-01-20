package com.TeamHEC.LocomotionCommotion.Goal.Graph;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import com.TeamHEC.LocomotionCommotion.Map.Connection;
import com.TeamHEC.LocomotionCommotion.Map.MapObj;
import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Map.WorldMap;

public class Dijkstra {
	private WorldMap map;
	public static ArrayList<Station> stations;
	Node v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20,v21,v22; 
	public Node[] nodeList;

	public Dijkstra(){
		map = WorldMap.getInstance();
		stations = map.stationsList;  
		nodeList = new Node[] {v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20,v21,v22};
		initialiseGraph();
	}

	public void computePaths(Node source){
		source.minDistance = 0;
		PriorityQueue<Node> NodeQueue = new PriorityQueue<Node>();
		NodeQueue.add(source);

		while (!NodeQueue.isEmpty()) {
			Node currentnode = NodeQueue.poll();

			// Visit each edge exiting 
			for (Edge e : currentnode.edges)
			{
				Node nextnode = e.target;
				double weight = e.weight;
				double distanceThroughU = currentnode.minDistance + weight;
				if (distanceThroughU < nextnode.minDistance) {
					NodeQueue.remove(nextnode);
					nextnode.minDistance = distanceThroughU ;
					nextnode.previous = currentnode;
					NodeQueue.add(nextnode);
				}
			}
		}
	}

	public List<Node> getShortestPathTo(Node target)
	{
		List<Node> path = new ArrayList<Node>();
		for (Node Node = target; Node != null; Node = Node.previous)
			path.add(Node);
		Collections.reverse(path);
		return path;
	}

	public Node lookUpNode(MapObj mapObj)
	{
		for (Node n : nodeList){
			if (mapObj.getName() == n.mapobj.getName())
				return n;		
		}
		
		throw new IllegalArgumentException("The given mapObj does not exist in the nodeList");
	}

	public void initialiseGraph()
	{
		ArrayList<MapObj> fullList = new ArrayList<MapObj>();
		fullList.addAll(stations);
		fullList.add(WorldMap.getInstance().junction[0]);
		fullList.add(WorldMap.getInstance().junction[1]);
	
		for(int i = 0; i < fullList.size(); i++){         //populates empty nodes with a new station
			nodeList[i] = new Node(fullList.get(i));  //stepping through each node in array and assigning station to it.      
		}      

		for(Node n : nodeList){
			for(Connection c : n.mapobj.connections){                            //adds each connection to each node
				n.edges.add(new Edge(lookUpNode(c.getDestination()),(c.getLength()))); } }  //add check for station



	}
}

