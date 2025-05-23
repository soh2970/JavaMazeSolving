public class GraphNode {
    // The unique identifier for the node
    private int name;

    // A flag indicating whether the node has been visited or marked
    private boolean marked;

    /**
     * Constructor for creating a new GraphNode.
     * @param name The unique identifier for the node.
     */
    public GraphNode(int name) {
        this.name = name;
        this.marked = false; // Nodes are initially unmarked
    }

    /**
     * Marks or unmarks the node.
     * @param mark A boolean value indicating whether to mark (true) or unmark (false) the node.
     */
    public void mark(boolean mark) {
        this.marked = mark;
    }

    /**
     * Checks if the node is marked.
     * @return A boolean value indicating whether the node is marked.
     */
    public boolean isMarked() {
        return this.marked;
    }

    /**
     * Retrieves the name (identifier) of the node.
     * @return The integer identifier of the node.
     */
    public int getName() {
        return this.name;
    }
    
}
