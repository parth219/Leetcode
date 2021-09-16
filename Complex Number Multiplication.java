public String complexNumberMultiply(String num1, String num2) {
        int a = Integer.parseInt(num1.substring(0,num1.indexOf('+')));
        int b = Integer.parseInt(num1.substring(num1.indexOf('+')+1,num1.length()-1));
        
        int c = Integer.parseInt(num2.substring(0,num2.indexOf('+')));
        int d = Integer.parseInt(num2.substring(num2.indexOf('+')+1,num2.length()-1));
        
        int ans = a*c - (b*d);
        int iota = a*d + b*c;
        return ans + "+" + iota +'i';
    }
