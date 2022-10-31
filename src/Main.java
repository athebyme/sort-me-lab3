import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static void queue_task() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        queue q = new queue();

        String in;
        int N = Integer.parseInt(input.readLine()), num;

        for (int i = 0; i < N; i++) {
            in = input.readLine();
            if (in.charAt(0) == '+') {
                num = Integer.parseInt(in.substring(1).strip());
                q.add(num);
            } else{
                System.out.println(q.head.data);
                q.removeHead();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        queue_task();
    }

}
class queue{
    Node head;
    Node tail;
    queue(){
        this.head = null;
        this.tail = null;
    }
    void add(int n) {
        Node node = new Node(n);
        if (tail == null) head = node;
        else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
    }
    void removeHead(){
        if(head != null){
            if(head.next != null){head = head.next;}
            head.prev = null;
        }
    }
}
class Node {
    Node next;
    Node prev;
    int data;
    Node (int n) {
        this.data = n;
    }
}