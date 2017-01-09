public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        return solution3(nums,k);
    }
    
    //not good, time exceed
    public boolean solution1(int[] nums, int k){
        boolean result = false;
        int length = nums.length;
        for(int i=0; i<length-1; i++){
            int range = i + k;
            for (int j = i+1; j <= range&& j<length; j++){
                if(nums[i]==nums[j])
                result = true;
            }
        }
        return result;
    }
    
	//not good. perfermance not good even using queue with silding window
    public boolean solution2(int[] nums, int k){
        boolean result = false;
        int length = nums.length;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i< length; i++){
            if(map.containsKey(nums[i])){
                int index = map.get(nums[i]);
                if((i-index)<=k){
                    result = true;
                    break;
                }
            }else{
                map.put(nums[i],i);
            }
        }
        return result;

    }
    
    public boolean solution3(int[] nums, int k){
         Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}