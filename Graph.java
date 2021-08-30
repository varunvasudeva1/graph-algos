import java.util.*;

public interface Graph {

    /**
     * Adds a vertex to this graph, associating object with vertex. returns true
     * if the vertex was added, and false if it was not. That is, it returns
     * false if the vertex already existed.
     */
    public boolean addVertex(Character vertex);

    /**
     * Removes a single vertex with the given value from this graph. returns
     * true if the vertex was removed, and false otherwise
     */
    public boolean removeVertex(Character vertex);

    /**
     * Inserts an edge between two pre-existing different vertices of this
     * graph. returns true if the edge was added, and false otherwise
     */
    public boolean addEdge(Character vertex1, Character vertex2);

    /**
     * Removes an edge between two pre-existing vertices of this graph. returns
     * true if the edge was removed, and false otherwise.
     */
    public boolean removeEdge(Character vertex1, Character vertex2);

    /**
     * Returns true if the specified vertex exists, and false otherwise
     */
    public boolean hasVertex(Character vertex);

    /**
     * Returns true if an edge exists between the specified vertices, and false
     * otherwise
     */
    public boolean hasEdge(Character vertex1, Character vertex2);

    /** Returns true if this graph is empty (no vertices), false otherwise. */
    public boolean isEmpty();

    /**
     * Returns the number of vertices in this graph.
     * 
     * @returns the number of vertices
     */
    public int vertexCount();

    /**
     * Returns the number of vertices in this graph.
     * 
     * @returns the number of vertices
     */
    public int edgeCount();

    /**
     * Returns the breadth-first traversal of the graph beginning at the
     * specified vertex. Even though there could be more than one correct
     * traversal, we will (as done in class) always choose vertices in
     * alphabetical order when given a choice.
     * 
     * @throws IllegalArgumentException if the vertex does not exist
     */
    public List<Character> breadthFirstTraversal(Character vertex);

    /**
     * Returns the depth-first traversal of the graph beginning at the specified
     * vertex. Even though there could be more than one correct traversal, we
     * will (as done in class) always choose vertices in alphabetical order when
     * given a choice.
     * 
     * @throws IllegalArgumentException if the vertex does not exist
     */
    public List<Character> depthFirstTraversal(Character vertex);

    /**
     * Returns the shortest path of the graph beginning at vertex1 and ending at
     * vertex2. If there is no path between the vertices, return an empty list.
     * Even though there could be more than one correct answer, we will (as done
     * in class) always choose vertices in alphabetical order when given a
     * choice.
     * 
     * @throws IllegalArgumentException if the vertices do not exist
     */
    public List<Character> shortestPath(Character start, Character end);

    /**
     * Makes the graph complete by connecting each vertex to all other vertices
     * in the graph.
     */
    public void makeComplete();

}