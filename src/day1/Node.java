package day1;

import java.util.LinkedList;
import java.util.List;

public class Node {
    boolean visited;
    List<Node> adjacent;
    int number;
    public Node(int i) {
        this.number = i;
        this.visited = false;
        this.adjacent = new LinkedList<Node>();
    }

    public int nodeNumber() {
        return this.adjacent.size();
    }

    public void addAdjacent(Node node) {
        this.adjacent.add(node);
    }

    public void visited(){
        System.out.println("number = " + number);
        this.visited = true;
    }

    // getter, setter까지는 뭔가 하기 귀찮다...
}
