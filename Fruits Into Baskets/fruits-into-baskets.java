class Solution {
    public int totalFruit(int[] fruits) {
        
        int lastFruit = -1;
        int secondLastFruit = -1;
        int last_fruit_count = 0;
        int current_max = 0;
        int max = 0;
        
        for(Integer fruit : fruits) {
            
            
            if(fruit == lastFruit || fruit == secondLastFruit){
                current_max += 1;
            } else {
                current_max = last_fruit_count +1;
            }
            
            if(fruit == lastFruit){
                last_fruit_count += 1;
            } else {
                last_fruit_count = 1;
            }
            
            if (fruit != lastFruit) {
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }
            
            max = Math.max(current_max, max);
            
            
        }
            
            
        return max;        
                
    }
}

/*
Time Submitted     Status    Runtime    Memory  Language 
06/29/2021 16:29	Accepted	9 ms	47.4 MB	java
 */