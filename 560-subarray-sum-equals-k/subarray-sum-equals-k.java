class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        
        // Initialize with sum 0 occurring once (empty prefix)
        prefixCount.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            
            // Check if (prefixSum - k) exists in map
            if (prefixCount.containsKey(prefixSum - k)) {
                count += prefixCount.get(prefixSum - k);
            }
            
            // Update frequency of current prefix sum
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
}
}