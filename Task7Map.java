//This classe's purpose is to match between the CNF formula variables to the sudoku map variables.
//By:Tomer Sivan, 312595192
//Last modified:30/11/2017, 21:25


public class Task7Map {
	
	public static int varName(int i, int j, int k, int n) {
		return(n*n*i+n*j+k+1);
	}
	
	public static int[] nameToIndex(int x, int n) {
	    int[]triplet=new int[3];
        int i,j,k;
        i=(x-1)/(n*n);      //Calculating i,j,k according to 7.1 formula using divide and modulo.
        j=((x-1)%(n*n))/n;
        k=((x-1)%(n*n))%n;
	   	triplet[0]=i;
	    triplet[1]=j;  
	    triplet[2]=k;
	    return triplet;
	}
	
	public static int[][][] varsMap(int n) {
		int[][][]VarsTable=new int[n][n][n];
		for(int i=0;i<n;i=i+1)
	    	for(int j=0;j<n;j=j+1)
	    		for(int k=0;k<n;k=k+1)
	    		{
	    			VarsTable[i][j][k]=varName(i,j,k,n);   //Matching the correct CNF name to the correct position.
	    		}
		return VarsTable;
	    			
		
	}
}
