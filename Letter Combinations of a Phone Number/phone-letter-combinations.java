class Solution {
    
    private List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private String phoneDigits;
    
    public List<String> letterCombinations(String digits) {
        
        //Base case
        if (digits.length() == 0) {
            return combinations;
        }
        
        phoneDigits = digits;
        backtrack(0, new StringBuilder());
        return combinations;
    }
    
    private void backtrack( int index, StringBuilder path){
        
        //end case - reached end of digits
        if(path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return; 
        }
        
        String possibleLetters = letters.get(phoneDigits.charAt(index));
        
        for (char letter: possibleLetters.toCharArray()) {
            path.append(letter);
            
            backtrack(index + 1, path);
            
            //delete letter after backtrack to try next letter
            path.deleteCharAt(path.length()-1);
        }
    }
}

/* 
Time Submitted      Status    Runtime   Memory  Language
07/07/2021 16:27	Accepted	0 ms	37.7 MB	java
*/