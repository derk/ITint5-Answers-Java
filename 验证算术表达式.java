import java.util.*;

public class Validation {
    public boolean validate(String expr) {
        LinkedList<Character> list = new LinkedList<Character>();
        if(expr==null || expr.length()==0) {
            return false;
        }
        if(expr.equals("0")) return true;
        if(expr.charAt(0)=='0' && Character.isDigit(expr.charAt(1))) {
            return false;
        }
        for(int i = 1; i <expr.length()-1;i++) {
            if(!Character.isDigit(expr.charAt(i-1)) && expr.charAt(i)=='0'
              && Character.isDigit(expr.charAt(i+1))) return false;
        }
        boolean afterSquare = false;
        for(int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if(list.isEmpty()) {
                list.push(c);
                continue;
            }
            if(Character.isDigit(c)) {
                if(afterSquare) return false;
                if(!Character.isDigit(list.peek())) {
                    list.push(c);
                }
            } else if (c == ')') {
                int last = list.lastIndexOf('(');
                if(last < 0) return false;
                list.remove(last);
                afterSquare = true;
            } else {
                list.push(c);
                afterSquare = false;
            }
        }
        if(list.size() % 2 == 0) return false;
        for(int i = 0; i<list.size(); i++) {
            char c = list.get(i);
            if(i%2 != 0) {
                if(c!='+' && c!='-') return false;
            } else {
                if(!Character.isDigit(c)) {
                    return false;
                }
            }
        }
        return true;
    }
}
