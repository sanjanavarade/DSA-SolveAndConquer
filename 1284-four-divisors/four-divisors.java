class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalsum=0;
        for(int num:nums){
            int sum=1+num;
            int count=2;
            for(int i=2;i*i<=num && count<=4;i++){
                if(num%i==0){
                    int d1=i;
                    int d2=num/i;

                    if(d1==d2){
                        count++;
                        sum=sum+d1;
                    }else{
                        count=count+2;
                        sum=sum+d1+d2;
                    }
                }
                
            }
            if(count==4){
                totalsum+=sum;
            }
        }
        return totalsum;
    }
}