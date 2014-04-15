public class Add {
    //返回a+b的结果
    public String add(String a, String b) {
        if(a == null || b == null) return null;
        StringBuilder sb = new StringBuilder();
        int carrier = 0;
        if(a.length() > b.length()) {
            String t = a;
            a = b;
            b = t;
        }
        for(int i = 0; i < a.length(); i++) {
            int ad = Integer.parseInt(Character.toString(a.charAt(a.length() - 1 -i)));
            int bd = Integer.parseInt(Character.toString(b.charAt(b.length() - 1 -i)));
            int d = (ad + bd + carrier ) % 10;
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
