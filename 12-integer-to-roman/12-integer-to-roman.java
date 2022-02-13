class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> romanMap = new LinkedHashMap<>();
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");       
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");
        
        
        if(romanMap.containsKey(num)) {
            return romanMap.get(num);
        }
        String roman = "";
        
        for(Integer value : romanMap.keySet()) {
            String numeral = romanMap.get(value);
 
            int factor = num / value;
            
            if(factor > 0) {
                // has 1000s
                int loopFactor = factor;
                while(loopFactor-- > 0) {
                    roman += numeral;
                }
            }
            // reduce number
            num -= factor * value;
        }
        return roman;
    }
}