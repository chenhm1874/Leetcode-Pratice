public class IntegerToEnglishWords {
    public static String[] BelowTwenty= new String[]{
            "",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen"
    };
    public static String[] InHundred = new String[]{
            "",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety"
    };
    public static String toEnglishWords(int num){
        if (num==0){
            return "Zero";
        }
        return Convert(num);
    }
    public static String Convert(int num){
        String res="";
        if(num==0){
            return "";
        }
        else if(num>0 && num<20){
            res= BelowTwenty[num];
        }
        else if(num>=20 && num<100){
            res= InHundred[num/10-1]+" "+ BelowTwenty[num%10];
        }
        else if(num>=100 && num<1000){
            res= BelowTwenty[num/100-1]+"Hundred"+Convert(num%100);
        }
        else if(num>=1000 && num<1000000){
            res= Convert(num/1000)+"Thousand"+Convert(num%1000);
        }
        else if(num>=1000000 && num<1000000000){
            res= Convert(num/1000000)+"Million"+Convert(num%1000000);
        }
        else{
            res= Convert(num/1000000000)+"Billion"+Convert(num%1000000000);
        }
        return res.trim();
    }
}
