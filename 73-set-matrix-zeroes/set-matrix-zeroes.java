class Solution {
     public void setZeroes(int[][] matrix) {
        int m=matrix[0].length,n=matrix.length;
        boolean firstCol=false;
        boolean firstRow=false;

        for(int i=0;i<n;i++){
            if(matrix[i][0]==0){
                firstCol=true;
                break;
            }
        }
        for(int i=0;i<m;i++){
            if(matrix[0][i]==0){
                firstRow=true;
                break;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        int i=1,j=1;
        while(i<n){
            if(matrix[i][0]==0){
                for(int k=1;k<m;k++){
                    matrix[i][k]=0;
                }
            }
            i++;
        }
        while(j<m){
            if(matrix[0][j]==0){
                for(int k=1;k<n;k++){
                    matrix[k][j]=0;
                }
            }
            j++;
        }
        if(firstCol==true){
            for(int k=0;k<n;k++){
                matrix[k][0]=0;
            }
        }
        if(firstRow==true){
            for(int k=0;k<m;k++){
                matrix[0][k]=0;
            }
        }

    }
}