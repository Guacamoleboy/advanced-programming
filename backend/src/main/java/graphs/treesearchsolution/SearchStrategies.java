package graphs.treesearchsolution;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class SearchStrategies {

    public static void main(String[] args) {

        Node root = new Node(10); // root
        Node newChild = root.addChild(5); // root first child
        Node newChildChild = newChild.addChild(115); // root first child -> child
        newChildChild.addChild(207); // root first child -> child -> child
        newChildChild.addChild(500);
        root.addChild(7); // root second child
        newChild = root.addChild(15); // root third child
        newChild.addChild(117);


        System.out.println("BFS starting..");
        Node foundNode = searchBFS(117, root); // BFS search
        if (foundNode != null) {
            System.out.println(foundNode.getValue());
        } else {
            System.out.println("Found nothing!");
        }


        System.out.println("DFS starting..");
        foundNode = searchDFS(117, root); // BFS search
        if (foundNode != null) {
            System.out.println(foundNode.getValue());
        } else {
            System.out.println("Found nothing!");
        }
    }

    public static Node searchBFS(int value, Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){

            // Print evt køen
            System.out.print("Current queue: ");
            for (Node item : queue) {
                System.out.print(item.getValue() + " ");
            }
            System.out.println();

            Node currentNode = queue.remove();
            if(value == currentNode.getValue()){
                return currentNode;
            }
            else{
                queue.addAll(currentNode.getChildren());
            }
        }
        return null;
    }

    public static Node searchDFS(int value, Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()){

            // Print evt stakken
              System.out.print("Current stack: ");
            for (Node item : stack) {
                System.out.print(item.getValue() + " ");
            }
            System.out.println();

            Node currentNode = stack.pop();
            if(value == currentNode.getValue()){
                return currentNode;
            }
            else{
                for(Node n:currentNode.getChildren()){
                    stack.push(n);
                }
            }
        }
        return null;
    }

}