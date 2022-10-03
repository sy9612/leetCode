class Solution {
    public static boolean visit[];
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> answer = new HashSet<>();
        Arrays.sort(nums);
        
        int nEnd = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] <= 0){
                nEnd = i;
            }
        }
        
        for(int i=0; i<=nEnd; i++){
            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] == 0){
                    List<Integer> numbers = new ArrayList();
                    numbers.add(nums[i]);
                    numbers.add(nums[left]);
                    numbers.add(nums[right]);
                    answer.add(numbers);
                    right--;
                    left++;
                }else if(nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }else{
                    left++;
                } 
            }
        }
                
        return new ArrayList<>(answer);
    }
}