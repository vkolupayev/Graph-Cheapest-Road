package ads4;

import java.util.ArrayList;

public class Graph {

	private Node[] nodes;
	private int noOfNodes;
	private Edge[] edges;
	private int noOfEdges;
	
	public Graph(Edge[] edges) {
		this.edges = edges;
		this.noOfNodes = calculateNoOfNodes(edges);
		this.nodes = new Node[this.noOfNodes];
		
		for(int i = 0; i < this.noOfNodes; i++) {
			this.nodes[i] = new Node();
		}
		
		this.noOfEdges = edges.length;
		
		for(int j = 0; j < this.noOfEdges; j++) {
			this.nodes[edges[j].getFromNodeIndex()].getEdges().add(edges[j]);
			this.nodes[edges[j].getToNodeIndex()].getEdges().add(edges[j]);
		}
	}
	
	private int calculateNoOfNodes(Edge[] edges) {
		int noOfNodes = 0;
		
		for(Edge e : edges) {
			if(e.getToNodeIndex() > noOfNodes) {
				noOfNodes = e.getToNodeIndex();	
			}
			if(e.getFromNodeIndex() > noOfNodes) {
				noOfNodes = e.getFromNodeIndex();
			}
		}
		
		noOfNodes++;
		
		return noOfNodes;
	}
	
	public void calculateShortestDistance(int start) {
		//source node
		this.nodes[start].setDistanceFromSource(0);
		int nextNode = start;
		
		//visit every node
		for (int i = 0; i < this.nodes.length; i++) {
			//loop around the edges
			ArrayList<Edge> currentNodeEdges = this.nodes[nextNode].getEdges();
			
			for(int j = 0; j < currentNodeEdges.size(); j++) {
				int neighbourIndex = currentNodeEdges.get(j).getNeighbourIndex(nextNode);
				
				//only if not visited
				if(!this.nodes[neighbourIndex].isVisited()) {
					double tentative = this.nodes[nextNode].getDistanceFromSource() + currentNodeEdges.get(j).getLength();
					
					if(tentative < nodes[neighbourIndex].getDistanceFromSource()) {
						nodes[neighbourIndex].setDistanceFromSource(tentative);
					}
				}
			}
			
			//all neighbours checked so node visited
			nodes[nextNode].setVisited(true);
			
			//next node must be with shortest distance
			nextNode = getNodeShortestDistance();
			
		}
	}
	
	private int getNodeShortestDistance() {
		int storedNodeIndex = 0;
		double storedDist = Double.MAX_VALUE;
		
		for(int i = 0; i < this.nodes.length; i++) {
			double currentDist = this.nodes[i].getDistanceFromSource();
			
			if(!this.nodes[i].isVisited() && currentDist < storedDist) {
				storedDist = currentDist;
				storedNodeIndex = i;
			}
		}
		
		return storedNodeIndex;
	}
	
	public void printResults(int start) {
		String output = "Number of nodes = " + this.noOfNodes;
		output += "\nNumber of edges = " + this.noOfEdges;
		
		for(int i = 0; i < this.nodes.length; i++) {
			if(nodes[i].getDistanceFromSource()!=Double.MAX_VALUE) {
				output += ("\nThe cheapest way is from " + start + " to " + i + ": " + nodes[i].getDistanceFromSource());
			}
			else {
				output += ("\nThe road from " + start + " to " + i + " does not exist");
			}
		
		}
	
		System.out.println(output);
	}

	//getters
	public int getNoOfEdges() {
		return noOfEdges;
	}
	
	public Edge[] getEdges() {
		return edges;
	}
	
	public int getNoOfNodes() {
		return noOfNodes;
	}
	
	public Node[] getNodes() {
		return nodes;
	}
	
}
