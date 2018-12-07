package chapter_four.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FirstG {

    public static void main(String[] args) {
        FirstG g = new FirstG();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n19 = new Node(19);


        n1.setChildren(new Node[]{n2,n4,n5,n6});
        n6.setChildren(new Node[]{n9});
        n2.setChildren(new Node[]{n7,n8,n3});

        Graph graph = new Graph(new Node[]{n1,n2,n3,n4,n5,n6,n7,n8,n9,n19});
        boolean result = g.searchPath(graph, n1,n19);

        System.out.println(result);
    }

    public boolean searchPath(Graph g, Node start, Node end){
        if(start == end) return true;

        LinkedList<Node> queue = new LinkedList<>();
        for(Node u : g.getNodes())
            u.state = State.UNVISITED;

        start.state = State.VISITING;
        queue.add(start);

        while (!queue.isEmpty()){
            Node n = queue.poll();
            for(Node v : n.getChildren()){
                if(v.state == State.UNVISITED)
                    if(v.key == end.key) {
                        return true;
                    }else {
                        queue.add(v);
                    }
            }
            n.state = State.VISITED;
        }
        return false;
    }
}

class Graph{
    Node[] nodes;

    public Graph(Node[] nodes) {
        this.nodes = nodes;
    }

    public Node[] getNodes(){return nodes;}
}

class Node{
    int key;
    State state;
    Node[] children;

    public Node(int key) {
        this.key = key;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }
}

enum State{
    UNVISITED,
    VISITED,
    VISITING;
}