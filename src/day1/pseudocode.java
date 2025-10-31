package day1;

public class pseudocode {
    /**
     * search (Node root){
     *     if(root == null) return;
     *     visit(root) // root 노드 방문
     *     root.visited = true;
     *     for each(Node n in  root.adjacent){ // 루트에 인접한 각각 노드에 대하여
     *         if(n.visited == false){ // 방문하지 않았다면
     *              search(n); // 해당 노드를 정점으로 다시 DFS 시작
     *         }
     *     }
     * }
     */
}
