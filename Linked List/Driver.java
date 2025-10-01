public class LinkedListOwn{
    public class Node{int data;Node next;}
    Node head;
    public void insert(int data){
        Node node = new Node();        
        node.data = data;
        node.next = null;

        if (head == null){head = node;}
        else{
            Node n =head;
            while (n.next != null){
                n =n.next;   
            }
            n.next=node;
        }
    }
    public void show(){
        Node node = head;
        while (node!= null) {
            System.out.println(node.data);
            node = node.next;
        }
    }   
}
