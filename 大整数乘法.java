public class Multiply {
    //返回a*b的结果
    public String multiply(String a, String b) {
        if(a.length() == 0 || b.length() == 0) return "";
        if(a.equals("0") || b.equals("0")) {
            return "0";
        }
        boolean isNegative = false;
        if(a.charAt(0) == '-' && b.charAt(0) == '-') {
            a = a.substring(1);
            b = b.substring(1);
        } else if(a.charAt(0) == '-') {
            a = a.substring(1);
            isNegative = true;
        } else if(b.charAt(0) == '-') {
            b = b.substring(1);
            isNegative = true;
        }
        if(a.charAt(0) == '+') {
            a = a.substring(1);
        }
        if(b.charAt(0) == '+') {
            b = b.substring(1);
        }
        if(a.length() > b.length()) {
            String t = a;
            a = b;
            b = t;
        }
        
        if(a.length() == 1) {
            StringBuilder sb = new StringBuilder();
            int carrier = 0;
            for(int i = 0; i < b.length(); i++) {
                int bd = Integer.parseInt(Character.toString(b.charAt(b.length() - 1 - i)));
                int ad = Integer.parseInt(Character.toString(a.charAt(0)));
                int d = (bd * ad + carrier) % 10;
                carrier = (bd * ad + carrier) / 10;
                sb.append(d);
            }
            if(carrier > 0) sb.append(carrier);
            if(isNegative) sb.append('-');
            sb = sb.reverse();
            return sb.toString();
        }
        String prod = "0";
        for(int i = 0; i < a.length(); i++) {
            String s = multiply(a.substring(i, i + 1), b);
            for(int j = 0; j < a.length() - 1 -i; j++) {
                s += "0";
            }
            prod = add(prod, s);
        }
        if(isNegative) {
            prod = "-" + prod;
        }
        return prod;
    }
    private static String add(String a, String b) {
        if(a.length() > b.length()) {
            String t = a;
            a = b;
            b = t;
        }
        int carrier = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a.length(); i++) {
            int ad = Integer.parseInt(Character.toString(a.charAt(a.length() - 1 - i)));
            int bd = Integer.parseInt(Character.toString(b.charAt(b.length() - 1 - i)));
            int d = (ad + bd + carrier) % 10;
            carrier = (ad + bd + carrier) / 10;
            sb.append(d);
        }
        for(int i = b.length() - a.length() - 1; i >= 0; i--) {
            int bd = Integer.parseInt(Character.toString(b.charAt(i)));
            int d = (bd + carrier) % 10;
            carrier = (bd + carrier) / 10;
            sb.append(d);
        }
        if(carrier > 0) sb.append(carrier);
        sb = sb.reverse();
        return sb.toString();
    }
}
