import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class labE {

    static Stack res = new Stack(0,0);

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stack stack = new Stack(0,0);
        String line;
        int c_l = Integer.parseInt(in.readLine());
        for(int i =0; i < c_l; i++){
            line = in.readLine();
            switch (line.charAt(0)){
                case 'm' -> res.add(stack.tail.max);
                case '+' -> stack.add(Integer.parseInt(line.substring(1).strip()));
                case '-' -> stack.remove();
            }
        }
        Stack a = res.head;
        while(a != null){
            System.out.println(a.data);
            a = a.next;
        }
    }
}

class Stack{
    Stack next;
    Stack prev;
    Stack head;
    Stack tail;

    int max;

    int data;
    Stack (int n, int max){
        this.data = n;
        this.max = max;
    }
    void add(int n){
        Stack node = new Stack(n, reinit_max(n));
        if(tail == null) head=node;
        else{
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
    }
    void remove() {
        if (tail != null) {
            tail = tail.prev;
            tail.next = null;
            this.max = tail.max;
        }
    }

    int reinit_max(int data){
        if(data > this.max)
            this.max = data;
        return this.max;
    }
}