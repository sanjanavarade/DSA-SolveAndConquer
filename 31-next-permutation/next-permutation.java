class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int ind = -1;

        // Step 1: Find the first index from the end where nums[i] < nums[i+1]
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        if (ind == -1) {
            // If no such index is found, reverse the entire array
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2: Find the element just larger than nums[ind] from the end
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                // Swap
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                break;
            }
        }

        // Step 3: Reverse the elements after index 'ind'
        reverse(nums, ind + 1, n - 1);
    }

    // Helper function to reverse part of the array
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }
}
