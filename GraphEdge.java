public class GraphEdge {
    // The first endpoint of the edge
    private GraphNode u;

    // The second endpoint of the edge
    private GraphNode v;

    // An integer representing the type of the edge, which can be used to distinguish different kinds of edges
    private int type;

    // A label for the edge, which can store additional information about the edge
    private String label;

    /**
     * Constructor for creating a new GraphEdge.
     * @param u The first endpoint of the edge.
     * @param v The second endpoint of the edge.
     * @param type An integer representing the type of the edge.
     * @param label A string label for the edge.
     */
    public GraphEdge(GraphNode u, GraphNode v, int type, String label) {
        this.u = u;
        this.v = v;
        this.type = type;
        this.label = label;
    }

    /**
     * Retrieves the first endpoint of the edge.
     * @return The first GraphNode endpoint of the edge.
     */
    public GraphNode firstEndpoint() {
        return this.u;
    }

    /**
     * Retrieves the second endpoint of the edge.
     * @return The second GraphNode endpoint of the edge.
     */
    public GraphNode secondEndpoint() {
        return this.v;
    }

    /**
     * Retrieves the type of the edge.
     * @return An integer representing the type of the edge.
     */
    public int getType() {
        return this.type;
    }

    /**
     * Sets a new type for the edge.
     * @param newType The new type to set for the edge.
     */
    public void setType(int newType) {
        this.type = newType;
    }

    /**
     * Retrieves the label of the edge.
     * @return A string representing the label of the edge.
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * Sets a new label for the edge.
     * @param newLabel The new label to set for the edge.
     */
    public void setLabel(String newLabel) {
        this.label = newLabel;
    }

}
