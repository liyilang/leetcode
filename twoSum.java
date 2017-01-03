public class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        return solution2(nums,target);
            
    }
    
     public int[] solution1(int[] nums, int target) {
        int length = nums.length;
        int[] result = new int[2];
        boolean found=false;
        for(int i=0;i<length&&!found;i++){
            for(int j=length-1;j>i;j--){
                if((nums[i]+nums[j])==target){
                    result[0]=i;
                    result[1]=j;
                    found = true;
                    break;
                }
            }
        }
        return result;
     }
    
     public int[] solution2(int[] nums, int target) {
         int length = nums.length;
         int[] result = new int[2];
         Map<Integer, Integer> map = new HashMap<Integer,Integer>();
         for(int i=0; i<length; i++){
			 int tmp = target-nums[i];
             if(map.containsKey(tmp)){
                result[1]=i;
                result[0]=map.get(tmp);
                break;
             }
             map.put(nums[i],i);
         }
         return result;
     }
}