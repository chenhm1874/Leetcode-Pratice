package Blind75;

import java.util.HashSet;
import java.util.Set;

public class containsDuplicate {
    public boolean solution(int[] arrays){
        Set<Integer> seen=new HashSet<>();
        for (int array:arrays){
            if(!seen.contains(array)){
                seen.add(array);
            }
            else{
                return true;
            }
        }
        return false;
    }
}
