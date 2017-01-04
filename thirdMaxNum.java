public class Solution {
    public int thirdMax(int[] nums) {
        return solution1(nums);
    }
    
    public int solution1(int[] nums){
        java.util.Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        int length=nums.length;
        for(int i=length-1;(i>=0)&&(list.size()<3); i--){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }else{
                continue;
            }
        }
        
        int size=list.size();
        if(size<3)
            return list.get(0);
        else
            return list.get(2);
        
    }
}