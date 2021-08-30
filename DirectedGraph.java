import java.util.*;

/**
 * Implements the Graph interface using a Map
 * The map will act somewhat like using adjacency lists.
 * @author Varun Vasudeva
 *
 */
public class DirectedGraph implements Graph {
	
	// The character is a vertex
	// The set of characters is all the neighbors of that vertex.
	// addVertex should put a new key-value pair in the map
	// addEdge('a', 'b') would find key 'a' and put 'b' in its set.
	private Map<Character, Set<Character>> map;
	
	/*
	 * Constructs a new graph by creating an empty map
	 * 
	 */
	public DirectedGraph() {
		map = new TreeMap<Character, Set<Character>>();
	}

	/*
	 * addVertex('a') should put a key-value pair
	 * in the map with no neighbors for 'a' yet.
	 */
	@Override
	public boolean addVertex(Character vertex) {
		// if vertex is already in graph, return false
		if (vertex == null || map.containsKey(vertex)) {
			return false;
		}
		
		map.put(vertex, new TreeSet<Character>());
		return true;
	}

	@Override
	public boolean removeVertex(Character vertex) {
		if (!hasVertex(vertex)) {
			return false;
		}
		
		// vertex exists:
		// loop to remove the vertex as a neighbor from 
		// all the other vertices:
		for (Character v : map.keySet()) {
			//map.get(v).remove(vertex);
			removeEdge(v, vertex);
		}
		
		// now remove the key vertex itself
		map.remove(vertex);
		return true;
	}

	/*
	 * addEdge('a', 'b') would find key 'a' and put 'b' in its set.
	 */
	@Override
	public boolean addEdge(Character vertex1, Character vertex2) {
		// Things that could go wrong that should result in 
		// returning false:
		if (vertex1 == null || vertex2 == null) {
			return false;
		}
		
		if (vertex1 == vertex2) {
			return false;
		}
		
		if (!map.containsKey(vertex1) || !map.containsKey(vertex2)) {
			return false;
		}		
		
		return map.get(vertex1).add(vertex2);
	
	}

	@Override
	public boolean removeEdge(Character vertex1, Character vertex2) {
		if (!hasEdge(vertex1, vertex2)) {
			return false;
		}
		
		// We know the edge exists, so remove it
		map.get(vertex1).remove(vertex2);
		return true;
	}

	@Override
	public boolean hasVertex(Character vertex) {
		return map.containsKey(vertex);
	}

	@Override
	public boolean hasEdge(Character vertex1, Character vertex2) {
		return hasVertex(vertex1)
				&& map.get(vertex1).contains(vertex2);
	}

	@Override
	public boolean isEmpty() {		
		return map.isEmpty();
	}

	@Override
	public int vertexCount() {		
		return map.size();
	}

	@Override
	public int edgeCount() {		
		int edges = 0;
		for (Set<Character> edgeset : map.values()) {
			edges += edgeset.size();
		}
		return edges;
	}

	/**
	 * Use a Queue to manage the traversal
	 */
	@Override
	public List<Character> breadthFirstTraversal(Character vertex) {	
		List<Character> result = new ArrayList<>();
		Queue<Character> q = new LinkedList<>();
		Set<Character> visited = new HashSet<>();
		
		q.add(vertex);
		visited.add(vertex);
		
		while (!q.isEmpty()) {
			// Removes front item and puts unvisited neighbors in the end
			char front = q.poll();

			result.add(front);
			
			for (Character neighbor : map.get(front)) {
				if (!visited.contains(neighbor)) {
					visited.add(neighbor);
					q.add(neighbor);
				}
			}
		}
		
		return result;
	}

	@Override
	public List<Character> depthFirstTraversal(Character vertex) {		
		List<Character> result = new LinkedList<>();
		Stack<Character> stk = new Stack<>();
		Set<Character> visited = new HashSet<>();
		
		stk.add(vertex);
		visited.add(vertex);
		result.add(vertex);
		
		while (!stk.isEmpty()) {
			Character top = stk.peek();
			
			// Does top have an unvisited neighbor?
			// If so, push neighbor on stack. if not, pop
			
			boolean foundUnvisitedNeighbor = false;
			
			for (Character neighbor : map.get(top)) {
				if (!visited.contains(neighbor)) {
					foundUnvisitedNeighbor = true;
					visited.add(neighbor);
					stk.push(neighbor);
					result.add(neighbor);
					break;
				}
			}
			
			if (!foundUnvisitedNeighbor)
				stk.pop();
			
		}
		
		return result;
	}

	@Override
	public List<Character> shortestPath(Character start, Character end) {
		throw new UnsupportedOperationException("Can't implement this method!");
	}

	@Override
	public void makeComplete() {		
		for (Character vertex : map.keySet()) {
			for (Character other : map.keySet()) {
				if (vertex != other) {
					addEdge(vertex, other);
				}
			}
		}
	}
	
	
	// Returns a string representation of the graph
	// Each line is a vertex followed by its neighbors
	public String toString() {
		String result = "";
		
		// loop through the map
		for (Character v : map.keySet()) {
			result += v + " --> ";
			result += map.get(v); // grabs the set of neighbors
			result += "\n";
		}		
		
		return result;
	}
}
