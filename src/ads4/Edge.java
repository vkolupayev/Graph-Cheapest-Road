package ads4;

public class Edge {

	private int fromNodeIndex;
	private int toNodeIndex;
	private double length;
	
	public Edge(int fromNodeIndex, int toNodeIndex, double length, String owner, String me) {
		this.setFromNodeIndex(fromNodeIndex);
		this.setToNodeIndex(toNodeIndex);
		if(owner.equals(me)) {
			this.length = length / 2;
		}
		else {
			this.length = length;
		}
	}

	public int getFromNodeIndex() {
		return fromNodeIndex;
	}

	public void setFromNodeIndex(int fromNodeIndex) {
		this.fromNodeIndex = fromNodeIndex;
	}

	public int getToNodeIndex() {
		return toNodeIndex;
	}

	public void setToNodeIndex(int toNodeIndex) {
		this.toNodeIndex = toNodeIndex;
	}

	public double getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	//determines the neighbour node of a supplied node, based on the two nodes connected by this edge
	public int getNeighbourIndex(int nodeIndex) {
		if(this.fromNodeIndex == nodeIndex) {
			return this.toNodeIndex;
		}
		else {
			return this.fromNodeIndex;
		}
	}
}
