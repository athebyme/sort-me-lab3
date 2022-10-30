import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static void queue_task() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        queue q = new queue();
        queue deleted = new queue();

        String in;
        int N = Integer.parseInt(input.readLine()), num;

        for (int i = 0; i < N; i++) {
            in = input.readLine();;
            if (in.charAt(0) == '+') {
                num = Integer.parseInt(in.substring(1).strip());
                q.add(num);
            } else{
                deleted.add(q.head.data);
                q.removeHead();
            }
        }

        Stack_ head = deleted.head;
        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static void main(String[] args) throws IOException {
        queue_task();
    }

}
class queue{
    Stack_ head;
    Stack_ tail;
    queue(){
        this.head = null;
        this.tail = null;
    }
    void add(int n) {
        Stack_ node = new Stack_(n);
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
    void removeTail() {
        if (tail != null) {
            tail = tail.prev;
            tail.next = null;
        }
    }
}
class Stack_ {
    Stack_ next;
    Stack_ prev;
    int data;
    Stack_ (int n) {
        this.data = n;
    }
}