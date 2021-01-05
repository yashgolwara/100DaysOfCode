package day005;

import java.util.HashMap;
import java.util.Map;

public class CheckArrayFormationThroughConcatenation {
	public boolean canFormArray(int[] arr, int[][] pieces) {
		 Map<Integer, int[]> input = new HashMap<>();
	        for(int[] piece : pieces){
	            input.put(piece[0], piece);
	        }

	        int start = 0;
	        while(start<arr.length){
	            if(input.containsKey(arr[start])){
	                int[] piece = input.get(arr[start]);

	                for(int i=0;i<piece.length;i++){
	                    if(arr[start]!=piece[i]){
	                        return false;
	                    } else{
	                        start++;
	                    }
	                }
	            } else {
	                return false;
	            }
	        }
	        return true;
	}
}
