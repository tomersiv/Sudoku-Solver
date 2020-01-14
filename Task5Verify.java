//This classe's purpose is to check if a complete solution of a Sudoku instance is valid.
//By:Tomer Sivan, 312595192
//Last modified:30/11/2017, 21:25

public class Task5Verify {
	
	public static boolean isSolution(int sqrtN, int[][] hints, int[][] board) {
		boolean check=true;
		int x, y;
		if(TasksArrays.isMatrixBetween(board,sqrtN*sqrtN,1,sqrtN*sqrtN)==false)     //Checking if board is correct.
			throw new IllegalArgumentException("Matrix doesn't contain numbers in boundations and isn't NxN");
		int[][] NewMatrix1=new int[sqrtN*sqrtN][sqrtN*sqrtN];
		int[][] NewMatrix2=new int[sqrtN*sqrtN][sqrtN*sqrtN];
		for(int i=0;check&i<hints.length;i=i+1) {                //Checking if hints is inside board.
			x=board[hints[i][0]][hints[i][1]];
			y=hints[i][2];
			if(x!=y)
			check=false;
		}
		for(int i=0;check&i<sqrtN*sqrtN;i=i+1) {                 //Checking if values are different in lines.
				if(TasksArrays.isAllDiff(board[i])==false)
				check=false;
		}
		NewMatrix1=TasksArrays.columns(board);                   //Checking if values are different in columns.
		for(int i=0;check&i<sqrtN*sqrtN;i=i+1) {
			if(TasksArrays.isAllDiff(NewMatrix1[i])==false)
			check=false;
		}
		NewMatrix2=TasksArrays.blocks(board, sqrtN);             ////Checking if values are different in blocks.
		for(int i=0;check&i<sqrtN*sqrtN;i=i+1) {
			if(TasksArrays.isAllDiff(NewMatrix2[i])==false)
			check=false;
			}
		return check;
		
		
					
				
				
	}

}
