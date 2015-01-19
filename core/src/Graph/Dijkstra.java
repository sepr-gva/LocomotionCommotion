
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
 
 public static void computePaths(Node source){
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
    Node v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20;                //node lists badly done
    Node[] nodeList = {v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20}; //but reliable
    
    for (int i= 0; i < stations.size(); i++){ // creates new empty nodes in nodeList
      Node newnode = new Node();          // up to same size as stationList
      nodeList[i] = newnode; 
      
      for(Node n : nodeList){         //populates empy nodes with a new station
      n = new Node(stations.get(i));  //stepping through each node in array and assigning station to it.      
     }      

// station.connections.get(i).getLength()
     
      for(Node n : nodeList){
        for(connections c : n.connections){                         //adds each connection to each node
          n.edges.add(new Edge((c.getDestination),(c.getLength))); } }//add check for station
  
 v1.adjacencies.edges.add( new Edge(v9, stations.get(0).connection.get(0).getLength()));
v1.adjacencies.edges.add( new Edge(v2, stations.get(0).connection.get(1).getLength()));
v2.adjacencies.edges.add( new Edge(v1, stations.get(1).connection.get(0).getLength()));
v2.adjacencies.edges.add( new Edge(v7, stations.get(1).connection.get(1).getLength()));
v2.adjacencies.edges.add( new Edge(v3, stations.get(1).connection.get(2).getLength()));
v3.adjacencies.edges.add( new Edge(v2, stations.get(2).connection.get(0).getLength()));  
v3.adjacencies.edges.add( new Edge(v4, stations.get(2).connection.get(1).getLength()));
v4.adjacencies.edges.add( new Edge(v3, stations.get(3).connection.get(0).getLength()));
v4.adjacencies.edges.add( new Edge(v17, stations.get(3).connection.get(1).getLength()));
v4.adjacencies.edges.add( new Edge(v5, stations.get(3).connection.get(2).getLength()));
v5.adjacencies.edges.add( new Edge(v4, stations.get(4).connection.get(0).getLength()));
v5.adjacencies.edges.add( new Edge(v17, stations.get(4).connection.get(1).getLength()));
v5.adjacencies.edges.add( new Edge(v6, stations.get(4).connection.get(2).getLength()));
v6.adjacencies.edges.add( new Edge(v5, stations.get(5).connection.get(0).getLength()));
v6.adjacencies.edges.add( new Edge(v16, stations.get(5).connection.get(1).getLength()));
v7.adjacencies.edges.add( new Edge(v2, stations.get(6).connection.get(0).getLength()));
v7.adjacencies.edges.add( new Edge(v8, stations.get(6).connection.get(1).getLength()));
v8.adjacencies.edges.add( new Edge(v7, stations.get(7).connection.get(0).getLength()));
v8.adjacencies.edges.add( new Edge(v9, stations.get(7).connection.get(1).getLength()));
v9.adjacencies.edges.add( new Edge(v11, stations.get(8).connection.get(0).getLength()));
//  createConnections(REYKJAVIK, new MapObj[]{OSLO, DUBLIN});
//  createConnections(DUBLIN, new MapObj[]{REYKJAVIK, AMSTERDAM, LONDON});
//  createConnections(LONDON, new MapObj[]{DUBLIN, PARIS});
//  createConnections(PARIS, new MapObj[]{LONDON, MONACO, MADRID, junction[0]});
//  createConnections(MADRID, new MapObj[]{PARIS, MONACO, LISBON});
//  createConnections(LISBON, new MapObj[]{MADRID, ROME});
//  createConnections(AMSTERDAM, new MapObj[]{DUBLIN, BERLIN});
//  createConnections(BERLIN, new MapObj[]{AMSTERDAM, OSLO, WARSAW, junction[0]});
  createConnections(OSLO, new MapObj[]{STOCKHOLM, REYKJAVIK, BERLIN});
  createConnections(WARSAW, new MapObj[]{BERLIN, STOCKHOLM, junction[1], PRAGUE});
  createConnections(STOCKHOLM, new MapObj[]{OSLO, WARSAW, HELSINKI});
  createConnections(HELSINKI, new MapObj[]{STOCKHOLM, VILNIUS, MOSCOW});
  createConnections(MOSCOW, new MapObj[]{HELSINKI, junction[1]});
  createConnections(PRAGUE, new MapObj[]{WARSAW, junction[0], junction[1], BERN, VIENNA});
  createConnections(VIENNA, new MapObj[]{PRAGUE, ATHENS});
  createConnections(ROME, new MapObj[]{LISBON, BERN, ATHENS});
  createConnections(MONACO, new MapObj[]{MADRID, PARIS, BERN});
  createConnections(BERN, new MapObj[]{MONACO, junction[0], PRAGUE});
        

    }
}
}
