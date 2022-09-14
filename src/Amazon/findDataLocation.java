package Amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class findDataLocation {
    public int[] findDataLocations(int[] locations,int[] from,int[] movedTo){
        Set<Integer> seen=new HashSet<>();
        for(int loc:locations){
            seen.add(loc);
        }
        for(int i=0;i<from.length;i++){
            seen.remove(from[i]);
            seen.add(movedTo[i]);
        }
        int[] newLocs=new int[seen.size()];
        int i=0;
        for(int loc:seen){
            newLocs[i]=loc;
            i++;
        }
        Arrays.sort(newLocs);
        return newLocs;
    }

    public static void main(String[] args) {
        findDataLocation obj=new findDataLocation();
        int[] res=obj.findDataLocations(new int[]{1,7,6,8}, new int[]{1,7,2},new int[]{2,9,5});
        for(int loc:res){
            System.out.println(loc);
        }
    }
}
