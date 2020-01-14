//This classe's purpose is to check by steps, if a solution for a sudoku instance is valid.    
//By:Tomer Sivan, 312595192
//Last modified:30/11/2017, 21:25

public class TasksArrays {
	
	public static boolean isAllDiff(int[] array) {
		boolean Diff=true;
		for(int i=0;i<array.length;i=i+1)                //Comparing first syntax to second,third,etc... then, comparing the second to the third,four,etc...
			for(int j=i+1;j<array.length&Diff;j=j+1)
			if(array[i]==array[j])
				Diff=false;
		return Diff;
	}
	
	
    public static boolean isMatrixBetween(int[][] matrix, int n, int min, int max) {
    	boolean check=true;
		if(matrix==null)                  //Checking if matrix is null.
			return false;
		for(int i=0;check&i<matrix.length;i=i+1)
		{
			if(matrix[i]==null)                //Checking if inner arrays are null.
				return false;
		
			for(int j=0;check&j<matrix[i].length;j=j+1)
			{
				if((matrix[i][j]>max)|(matrix[i][j]<min))     //Checking if syntaxes are between min and max(including).
				check=false;
				if(check&(matrix.length!=matrix[i].length)|(matrix.length!=n))  // Checking if matrix is nxn.
		        	check=false;
			}
		}
	          
	          return check;
					
	}
	
	public static int[][] columns (int[][] matrix) {
		int[][]matrix2=new int[matrix.length][matrix.length];  // creating a new array for the new syntaxes.  
		for(int i=0;i<matrix.length;i=i+1)
			for(int j=0;j<matrix[i].length;j=j+1)
			{
				matrix2[i][j]=matrix[j][i];                    // Switching columns and lines on the matrixes.
			}
		return matrix2;

	}
	
	public static int[][] blocks(int[][] matrix, int sqrtN) {
                 int[][]NewMatrix=new int[matrix.length][matrix.length];
                 int i,j,x,y,ColumnPosition,LinePosition; //Creating variables for indexes.
                 for(i=0;i<sqrtN*sqrtN;i=i+sqrtN) {      //Loop that goes around all the source matrix in jumps of sqrtN(going over the blocks).
                	 LinePosition=0;   //This index represents the delta between the destination matrix's line place and the variable i, we reset it each time we finish going over two blocks.
                	 for(j=0;j<sqrtN*sqrtN;j=j+sqrtN) {  //Loop that goes over each block's contents.
                		 ColumnPosition=0;  //This index represent the destination matrix's column position, we reset it each time we finish going over a block.
                		 for(x=i;x<i+sqrtN;x=x+1) {      // A double loop that copies the syntaxes from the source matrix to the destination matrix.
                			 for(y=j;y<j+sqrtN;y=y+1) {
                				 NewMatrix[i+LinePosition][ColumnPosition]=matrix[x][y];  //By adding i to Line position we ensure that we keep the correct positions even when we reset LinePosition.
                				 ColumnPosition=ColumnPosition+1;    // Each time we go over a syntax  in the block we increase the destination matrix's column position. 
                			 }
                		 }
                		 LinePosition=LinePosition+1;   //Each time we finish going over a block we increase the destination matrix's line position.
                	 }
                 }
                 return NewMatrix;
                				 

	}
}
