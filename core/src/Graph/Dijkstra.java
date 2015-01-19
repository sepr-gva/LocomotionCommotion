package Graph;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import com.TeamHEC.LocomotionCommotion.Map.Station;
import com.TeamHEC.LocomotionCommotion.Map.WorldMap;
public class Dijkstra {
	private WorldMap map;
	private static ArrayList<Station> stations;
	public Dijkstra(){
		map = WorldMap.getInstance();
		stations = map.stationsList;		
	}
	public static void computePaths(Node source)
    {
        source.minDistance = 0;
        PriorityQueue<Node> NodeQueue = new PriorityQueue<Node>();
      	NodeQueue.add(source);

	while (!NodeQueue.isEmpty()) {
	    Node u = NodeQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.edges)
            {
                Node v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
		if (distanceThroughU < v.minDistance) {
		    NodeQueue.remove(v);
		    v.minDistance = distanceThroughU ;
		    v.previous = u;
		    NodeQueue.add(v);
		}
            }
        }
    }

    public static List<Node> getShortestPathTo(Node target)
    {
        List<Node> path = new ArrayList<Node>();
        for (Node Node = target; Node != null; Node = Node.previous)
            path.add(Node);
        Collections.reverse(path);
        return path;
    }
    
    public static void main(String[] args)
    {
    Node v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20;
    
    Node[] nodeList = {v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20};
    
    
    for(int i=0; i < nodeList.length; i++){
    	 Node temp = nodeList[i];    	 
    	 temp = new Node(stations.get(i));	      	   	 
    	 
     }


	v0.adjacencies = new Edge[]{ new Edge(v1, 5),
	                             new Edge(v2, 10),
                               new Edge(v3, 8) };
	v1.adjacencies = new Edge[]{ new Edge(v0, 5), new Edge(v2, 3),new Edge(v4, 7) };	
	
//	Node[] vertices = { v0, v1, v2, v3, v4 };
        computePaths(v0);
        

    }
}
