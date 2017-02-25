import java.text.DecimalFormat;

public class HelloWorld {
    
    String[] num1To20 = { "", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen" };
    
    String[] decNums = { "", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
    
    String lessThan1000(Integer number){
        String retStr = "";
        if ((number%100) < 20){
            retStr = num1To20[number%100];
            number = number / 100;
        } else {
            retStr = num1To20[number%10];
            number = number / 10;
            
            retStr = decNums[number%10] + retStr;
            number = number / 10;
        }
        if (number == 0){
            return retStr;
        } else {
            return num1To20[number] + " Hundred" + retStr;
        }
        
    }
    
    String numbersToWords(Integer number){
        DecimalFormat df = new DecimalFormat("000000000");
        String numStr = df.format(number);
        
        Integer thousandNum = new Integer(numStr.substring(6));
        String thousandStr = lessThan1000(thousandNum);
        
        Integer moreThan1000Num = new Integer(numStr.substring(4,6));
        String moreThan1000NumStr = "";
        if (moreThan1000Num.equals(0)){
            moreThan1000NumStr = "";
        } else if (moreThan1000Num.equals(1)) {
            moreThan1000NumStr = " One Thousand";
        } else {
            moreThan1000NumStr = lessThan1000(moreThan1000Num) + " Thousand";
        }
        
        
        Integer lakhNum = new Integer(numStr.substring(2,4));
        String lakhStr = "";
        if (lakhNum.equals(0)){
            lakhStr = "";
        } else if (lakhNum.equals(1)) {
            lakhStr = " One Lakh";
        } else {
            lakhStr = lessThan1000(lakhNum) + " Lakh";
        }
        return lakhStr + moreThan1000NumStr + thousandStr;
        
    }
    
    public static void main(String[] args){
        
            System.out.println(new HelloWorld().numbersToWords(201567));
        
    }
}