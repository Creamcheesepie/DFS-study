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

    /**
     * 그런데 위처럼하면 좀 직관적으로 이해가 안된다.
     * '어디를 방문'하는가에 대해 구체적으로 이해하려 들지 말고
     * '방문 여부를 체크' 하고 다음 노드에 넘어가는 것에 집중하기!
     */
}
