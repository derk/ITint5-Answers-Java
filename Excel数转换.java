public class ExcelNumber {
    //将十进制数转换为excel数
    public String decToExcel(int decNum) {
        boolean negative = decNum<0;
        decNum = negative? -decNum:decNum;
        StringBuilder sb = new StringBuilder();
        while(decNum>0) {
            int r =(decNum-1)%26;
            decNum=(decNum-1)/26;
            sb.append(Character.toChars('A'+r)[0]);
        }
        sb=sb.reverse();
        return sb.toString();
    }
    //将excel数转换为十进制数
    public int excelToDec(String excelNum) {
        if(excelNum==null||excelNum.length()==0){
            return 0;
        }
        long n=0;
        for(int i=0;i<excelNum.length();i++){
            char c = excelNum.charAt(i);
            n+=c-'A'+1;
            n*=26;
        }
        n/=26;
        return (int)n;
    }
}
