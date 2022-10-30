import java.util.Scanner;
import java.util.Stack;

public class labC {
    static Stack<Boolean> res = new Stack<>();
    static void isBalanced(char [] line){
        Stack<Character> stack = new Stack<>();
        boolean check = false;
        for(char a: line){
            if(line[0] == ']' || line[0] == ')' || line[line.length-1]=='(' || line[line.length-1] == '['){
                res.add(false);
                return;
            }
            switch (a){
                case '(', '[' -> stack.add(a);
                case ')', ']' -> {
                    if(stack.size() < 1) {
                        res.add(false);
                        return;
                    }
                    char t = stack.get(stack.size()-1);
                    if(t == ('(') && a == ')' ){
                        stack.pop();
                        check = true;
                    } else if (t == '[' && a == ']') {
                        stack.pop();
                        check = true;
                    }else{
                        res.add(false);
                        return;
                    }
                }
            }
        }
        if(check && stack.size() == 0) res.add(true);
        else res.add(false);
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String line = stdin.nextLine();
        while (!line.equals("")){
            isBalanced(line.toCharArray());
            line = stdin.nextLine();
        }
        if(res.size() == 0) System.out.println("NO");
        for(Boolean a: res){
            if(a) System.out.println("YES");
            else System.out.println("NO");
        }

    }
}