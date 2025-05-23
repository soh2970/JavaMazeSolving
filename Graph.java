import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Graph implements GraphADT {
    private List<List<GraphEdge>> adjacencyList;
    private GraphNode[] nodes;

    public Graph(int n) {
        nodes = new GraphNode[n];
        adjacencyList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nodes[i] = new GraphNode(i);
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Inserts an edge between two nodes
    public void insertEdge(GraphNode u, GraphNode v, int edgeType, String label) throws GraphException {
        if (u.getName() >= nodes.length || v.getName() >= nodes.length) {
            throw new GraphException("Node does not exist");
        }
        for (GraphEdge edge : adjacencyList.get(u.getName())) {
            if (edge.secondEndpoint().equals(v)) {
                throw new GraphException("Edge already exists");
            }
        }

        GraphEdge newEdge = new GraphEdge(u, v, edgeType, label);
        adjacencyList.get(u.getName()).add(newEdge);
        adjacencyList.get(v.getName()).add(newEdge); // For undirected graph
    }

    // Retrieves a specific node by its name
    public GraphNode getNode(int name) throws GraphException {
        if (name >= nodes.length) {
            throw new GraphException("Node does not exist");
        }
        return nodes[name];
    }

    // Returns all edges incident to a node
    public Iterator<GraphEdge> incidentEdges(GraphNode u) throws GraphException {
        if (u.getName() >= nodes.length) {
            throw new GraphException("Node does not exist");
        }
        return adjacencyList.get(u.getName()).iterator();
    }

    // Retrieves an edge between two nodes
    public GraphEdge getEdge(GraphNode u, GraphNode v) throws GraphException {
        if (u.getName() >= nodes.length || v.getName() >= nodes.length) {
            throw new GraphException("Node does not exist");
        }
        for (GraphEdge edge : adjacencyList.get(u.getName())) {
            if (edge.secondEndpoint().equals(v)) {
                return edge;
            }
        }
        throw new GraphException("Edge does not exist");
    }

    // Checks if two nodes are adjacent
    public boolean areAdjacent(GraphNode u, GraphNode v) throws GraphException {
        if (u.getName() >= nodes.length || v.getName() >= nodes.length) {
            throw new GraphException("Node does not exist");
        }
        return isEdgePresent(u, v) || isEdgePresent(v, u);
    }

    // Helper method to check for edge presence between two nodes
    private boolean isEdgePresent(GraphNode u, GraphNode v) {
        for (GraphEdge edge : adjacencyList.get(u.getName())) {
            if (edge.secondEndpoint().equals(v) || edge.firstEndpoint().equals(v)) {
                return true;
            }
        }
        return false;
    }
}
