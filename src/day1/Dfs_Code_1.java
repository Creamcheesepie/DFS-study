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
        n1.addAdjacent(n4);
        n4.addAdjacent(n5);

        root.addAdjacent(n2);
        n2.addAdjacent(n6);
        n6.addAdjacent(n7);

        root.addAdjacent(n3);
        n3.addAdjacent(n8);

        search(root);
    }

    private static void search(Node root){
        if(root == null) return;// 넘겨받은 것이 없을 경우 돌아가기
        root.visited(); // 현재 노드를 방문했다고 표시
        for(Node node : root.adjacent){ // 노드에 인접한 노드들을 순차적으로 처리
            if(!node.visited){ // 방문하지 않았다면
                search(node); // 해당 노드를 정점으로 다시 DFS 진행
            }
        }
    }
    // DFS 라서 해당 노드의 가장 깊은 곳까지 전개했다 돌아오는 것을 확인할 수 있음
    // BFS였다면 해당 노드 주변을 전부 탐색하고 다음을 찾아보았을 것.
}
