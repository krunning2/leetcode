Idea :Topology sort.
1. To build a graph, key is the prerequisite course, value is the course. Just like a topology.
2. Run BFS to decrease the in-degree if the prerequisite was taken.
3. If in-degree is 0, push into the queue.
4. check all courses have been enqueue once, or check all in-degrees are 0;