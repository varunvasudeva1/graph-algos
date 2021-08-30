public class UndirectedGraph extends DirectedGraph {

    public boolean addEdge(Character vertex1, Character vertex2) {
		return super.addEdge(vertex1, vertex2) && super.addEdge(vertex2, vertex1);
	}

    public boolean removeEdge(Character vertex1, Character vertex2) {
    	return removeEdge(vertex1, vertex2) && removeEdge(vertex2, vertex1);
	}

    public int edgeCount() {
		return super.edgeCount()/2;
	}
}
