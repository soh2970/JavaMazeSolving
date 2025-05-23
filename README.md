# Assignment 5: Maze Solver with Graphs

## Overview

This Java project implements a **maze-solving algorithm** using an **undirected graph representation**. Each room in the maze is modeled as a node, and the paths (corridors and doors) are edges. The program uses a modified **depth-first search (DFS)** strategy to traverse from the **entrance** to the **exit**, while managing limited coin resources for unlocking doors.

## Key Concepts

- The maze is represented as an **undirected graph**.
- Nodes represent **rooms**, edges represent **corridors** or **doors**.
- Doors require **0–9 coins** to open, and coins can only be used once.
- The algorithm finds a valid **path from entrance to exit** within the coin limit.

## Java Classes Implemented

### `GraphNode.java`
Represents a room in the maze.

- `GraphNode(int name)` — Constructs a node with the given ID.
- `mark(boolean value)` — Marks/unmarks a node (for DFS traversal).
- `boolean isMarked()` — Checks if the node is marked.
- `int getName()` — Returns the node's unique ID.

### `GraphEdge.java`
Represents a connection (corridor/door) between two nodes.

- `GraphEdge(GraphNode u, GraphNode v, int type, String label)`
- `firstEndpoint()` / `secondEndpoint()` — Access endpoints.
- `getType()` / `setType()` — Coin cost (0–9) for door edges.
- `getLabel()` / `setLabel()` — "door" or "corridor".

### `Graph.java`
Stores the entire maze graph using adjacency structure.

Implements `GraphADT` with:

- `Graph(int n)` — Creates a graph with `n` nodes.
- `insertEdge(u, v, type, label)` — Adds edge to the graph.
- `getNode(int name)` — Gets node by name.
- `incidentEdges(u)` — Gets iterator of edges incident on `u`.
- `getEdge(u, v)` — Gets edge between nodes.
- `areAdjacent(u, v)` — Checks if two nodes are adjacent.

### `Maze.java`
Core class that reads the input file and solves the maze.

- `Maze(String inputFile)` — Parses input file and builds graph.
- `getGraph()` — Returns graph object (throws `MazeException` if null).
- `solve()` — Returns `Iterator<GraphNode>` with path from entrance to exit if exists, or `null`.

## Input File Format

A sample input:

```
30
4
3
4
s1owo1o
cwcwcwc
o2o3oco
ww4wcwc
ococx3o
```

- Line 1: Scale (ignored)
- Line 2: Width (A)
- Line 3: Length (L)
- Line 4: Available coins (k)
- Remaining: Maze grid layout (rooms, walls, corridors, and doors)

### Symbols

| Symbol | Meaning                          |
|--------|----------------------------------|
| `s`    | Start (entrance)                 |
| `x`    | Exit                             |
| `o`    | Room                             |
| `c`    | Corridor                         |
| `w`    | Wall                             |
| `0-9`  | Door requiring N coins to open   |

## How It Works

- Maze is converted into a graph where each room is a node.
- DFS explores paths from entrance to exit.
- Each door edge consumes the required number of coins.
- If coins are exhausted or no path exists, it backtracks.
- If a valid path is found, the method returns the node path.

## How to Run

Use the `Solve.java` class provided by the course to run:

```bash
java Solve input.txt
```

Replace `input.txt` with your input file.

## Testing

- Use `TestGraph.java` to verify the Graph implementation.
- Use provided input files to validate `Maze.solve()`.

## Evaluation

- Program compiles and runs: 2 marks
- Graph tests: 4 marks
- Maze solving logic: 4 marks
- Graph structure correctness: 4 marks
- Code quality & documentation: 2 marks
- Correctness of implementation: 4 marks

## Notes

- You must handle file errors and invalid formats via `MazeException`.
- All nodes and edges must be correctly modeled using OOP principles.
- Use `ArrayList`, `Stack`, or `Iterator` to build path logic.
- Proper marking/unmarking is critical for DFS correctness.

## License

This project is part of the University of Western Ontario’s CS 2210a course on Data Structures and Algorithms. For educational use only.
