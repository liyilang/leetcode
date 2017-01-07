public class Solution {
    public List<Integer> getRow(int rowIndex) {
        return solution2(rowIndex);
    }
    
    //not good, function will be out of boundary when rows gets higher than 21
    public List<Integer> solution1(int rowIndex){
        List<Integer> list = new ArrayList<Integer>();
        int index = rowIndex/2 + 1;
        for(int i= 0; i<index; i++){
            int ele = (int)(choose(rowIndex,i));
            list.add(ele);
        }
        if(rowIndex%2!=0){
            list.add(list.get(index-1));
        }
        
        //using the symmetrical character
        for(int i=index-2; i>=0; i--){
            list.add(list.get(i));
        }
        
        return list;
    }
    
    
    public List<Integer> solution2(int rowIndex){
        Integer[] array = new Integer[rowIndex+1];
        Arrays.fill(array,0);// initailly assign every ele with 0; for using List instead, try to use List.add(index, value)
        array[0] = 1;
        
        for(int i=1; i<=rowIndex; i++){
            for(int j=i; j>0; j--){
                array[j] = array[j] + array[j-1];
            }
        }
        
        return Arrays.asList(array);
    }
	
	
	
	//o(k) solution: C[k,i] = C[k,i-1]*(k-i+1)/i


    
    
    //not good, using the choose and factorial functions which easily lead to out of boundary 
    public static int choose(int n,int j){
	         int result;
	         int m = n-j;
	         if(m<j){
	        	 result = (int) (factorial(n, j)/factorial(m, 1));
	         }else {
				result = (int) (factorial(n, m)/factorial(j, 1));
			}
	         return result;
	     }
	     
	
    public static long factorial(int n, int m){
	    	 long result=1;
	         for(int i=m+1;i<=n;i++){
	             result = result * i;
	         }
	         return result;
	     }

}