//This classe's purpose is to decode the solution of the CNF formula, to a complete solution for the sudoku instance.
//By:Tomer Sivan, 312595192
//Last modified:30/11/2017, 21:25
public class Task9Decode {
	
	public static int cellValue(int[][][] map, int i, int j, boolean[] assignment) {
		        boolean found =false;
		        int CellValue=0;
				for(int k=0;!found&k<assignment.length;k=k+1)
					if(assignment[Task7Map.varName(i, j, k, map.length)]==true)  //Going all over assignment array searching for 'true' value.
					{
						if((Task7Map.varName(i, j, k, map.length)%map.length==0)) //If the true value hides in an index that is a multiplication of map.length,we would like CellValue to get that index.
						{  
								CellValue=map.length;
						        found=true;
						}
						else
						 CellValue=Task7Map.varName(i, j, k, map.length)%map.length;//Calculating a non-multiplication of map.length index by modulo.
						 found=true;
					}
				if (found)
					return CellValue;
				else
				throw new RuntimeException("There is no satisfy assigning"); //When we find no satisfaction assigning in assignment array, we throw exception.
					
					
					
	}
	
	public static int[][] mapToBoard(int[][][] map, int n, boolean[] assignment) {
		int[][]board=new int[n][n];
		for(int i=0;i<n;i=i+1)
			for(int j=0;j<n;j=j+1)
			{
				board[i][j]=Task9Decode.cellValue(map, i, j, assignment); //Copying the correct syntaxes by satisfaction input to a board
			}
		return board;
	}
}
