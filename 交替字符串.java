public class InterleavingString {
    public boolean isInterleaving(String str1, String str2, String str3) {
        if(str1 == null || str2 == null) {
            return false;
        }
        if(str1.length() + str2.length() != str3.length()) {
            return false;
        }
        int curr1 = 0;
        int curr2 = 0;
        for(int i = 0; i < str3.length();) {
            if(curr1 < str1.length() &&
               curr2 < str2.length() &&
               str1.charAt(curr1) == str2.charAt(curr2) &&
               str1.charAt(curr1) == str3.charAt(i)) {
                return isInterleaving(str1, str2.substring(1), str3.substring(1))
                    || isInterleaving(str1.substring(1), str2, str3.substring(1));
            } else if(curr1 < str1.length() && 
               str1.charAt(curr1) == str3.charAt(i)) {
                i++;
                curr1++;
            } else if(curr2 < str2.length() &&
                      str2.charAt(curr2) == str3.charAt(i)) {
                i++;
                curr2++;
            } else {
                return false;
            }
        }
        return true;
    }
}
