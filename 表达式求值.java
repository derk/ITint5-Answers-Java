public class Evaluation {
    //返回表达式expr的值
    public int evaluate(String expr) {
        if(expr.length() == 0) return 0;
        int index = expr.indexOf("*");
        if(index >= 0) {
            //eval l*r, replace and recursive call eval..
            int leftIndex = index - 1;
            int rightIndex = index + 1;
            while(leftIndex >= 0 && Character.isDigit(expr.charAt(leftIndex))) {
                leftIndex--;
            }
            leftIndex++;
            while(rightIndex < expr.length() &&
                  Character.isDigit(expr.charAt(rightIndex))) {
                rightIndex++;
            }
            int prod = Integer.valueOf(expr.substring(leftIndex, index)) *
                Integer.valueOf(expr.substring(index + 1, rightIndex));
            return evaluate(expr.substring(0, leftIndex) +
                           (new Integer(prod)).toString() + 
                           expr.substring(rightIndex));
        } else {
            //find first +/-, eval l+/-r, ...
            index = 1;
            boolean isAdd = false;
            while(index < expr.length()) {
                if(expr.charAt(index) == '+') {
                    isAdd = true;
                    break;
                }
                if(expr.charAt(index) == '-') {
                    break;
                }
                index++;
            }
            if(index == expr.length()) {
                return Integer.valueOf(expr);
            }
            int rightIndex = index +1;
            while(rightIndex < expr.length() &&
                  Character.isDigit(expr.charAt(rightIndex))) {
                rightIndex++;
            }
            int l = evaluate(expr.substring(0, index));
            int r = evaluate(expr.substring(index+1, rightIndex));
            int v = 0;
            if(isAdd) {
                v = l+r;
            }else {
                v = l-r;
            }
            return evaluate((new Integer(v)).toString() + 
                            expr.substring(rightIndex));
        }
    }
}
