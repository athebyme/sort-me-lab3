import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;


public class labD {
    private static Integer calc(int a, int b, char op){
        int res = 0;
        switch (op){
            case '*': return a * b;
            case '+': return a + b;
            case '-': return a - b;
            case '/': return a / b;
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        int r = 0, t = 0, r_s = 0;
        Stack<Integer> res = new Stack<>();
        Scanner s = new Scanner(System.in);
        for(char a: s.nextLine().toCharArray()){
            if(a ==' ') continue;
            t = (int) a;
            if((t > 41 && t < 44) || ((t > 44 && t < 47)&&(t != 46))){
                r = calc(res.get(res.size()-2), res.get(res.size()-1), a);
                res.pop();
                res.pop();
                res.add(r);
            }
            else res.add(t - 48);
        }
        System.out.println(res.get(0));
    }
}
