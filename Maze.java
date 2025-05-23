import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Maze implements GraphADT {
    private List<List<GraphEdge>> adjacencyList;
    private GraphNode[] nodes;

    // Initializes a maze with a specified number of nodes
    public Maze(int n) {
        nodes = new GraphNode[n];
        adjacencyList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nodes[i] = new GraphNode(i);
            adjacencyList.add(new ArrayList<>());
        }
    }
    
    // Solves the maze using a depth-first search approach
    public Iterator<GraphNode> solve() throws GraphException {
        Stack<GraphNode> stack = new Stack<>();
        Set<GraphNode> visited = new HashSet<>();
        List<GraphNode> path = new ArrayList<>();

        // Assuming nodes[0] is the start of the maze
        stack.push(nodes[0]);

        while (!stack.isEmpty()) {
            GraphNode current = stack.pop();

            if (!visited.contains(current)) {
                visited.add(current);
                path.add(current);

                // Assuming some condition to check if current is the end of the maze
                if (isEnd(current)) {
                    return path.iterator();
                }

                // Iterate over neighbors and push them onto the stack
                Iterator<GraphEdge> edges = incidentEdges(current);
                while (edges.hasNext()) {
                    GraphEdge edge = edges.next();
                    GraphNode neighbor = edge.secondEndpoint();
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        // Return null or an empty iterator if no solution is found
        return null;
    }
    
    // Checks if a given node is the end of the maze
    private boolean isEnd(GraphNode node) {
        return node.getName() == (nodes.length - 1);
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
        if (!u.equals(v)) { // Avoid adding twice for a self-loop
            adjacencyList.get(v.getName()).add(newEdge); 
        }
    }

    // Retrieves a node by its name
    public GraphNode getNode(int name) throws GraphException {
        if (name >= nodes.length) {
            throw new GraphException("Node does not exist");
        }
        return nodes[name];
    }

    // Returns an iterator to all edges incident to a node
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

    // Checks if two nodes are adjacent in the graph
    public boolean areAdjacent(GraphNode u, GraphNode v) throws GraphException {
        if (u.getName() >= nodes.length || v.getName() >= nodes.length) {
            throw new GraphException("Node does not exist");
        }
        return isEdgePresent(u, v) || isEdgePresent(v, u);
    }

    // Helper method to check for the presence of an edge between two nodes
    private boolean isEdgePresent(GraphNode u, GraphNode v) {
        for (GraphEdge edge : adjacencyList.get(u.getName())) {
            if (edge.secondEndpoint().equals(v) || edge.firstEndpoint().equals(v)) {
                return true;
            }
        }
        return false;
    }
}
