package day1;

import java.util.ArrayList;
import java.util.List;

public class Dfs_Code_1 {
    // 의사 코드를 기반으로 작동하는 코드를 작성하기

    public static void main(String[] args) {
        // 대애충 노드 기반 그래프 만들기
        Node root = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        root.addAdjacent(n1);
        root.addAdjacent(n2);
        n1.addAdjacent(n8);
        n2.addAdjacent(n3);
        n3.addAdjacent(n4);
        n4.addAdjacent(n5);
        n5.addAdjacent(n6);
        n2.addAdjacent(n7);

        search(root);
    }

    private static void search(Node root){
        if(root == null) return;
        root.visited();
        for(Node node : root.adjacent){
            if(!node.visited){
                search(node);
            }
        }
    }



}
