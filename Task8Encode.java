//This classe's purpose is to make a CNF formula that will create a valid solution for a sudoku instance.
//By:Tomer Sivan, 312595192
//Last modified:30/11/2017, 21:25

public class Task8Encode {
	
	public static void Cells(int[][][] map) {
		for(int i=0;i<map.length;i=i+1)
			for(int j=0;j<map.length;j=j+1)
			SATSolver.addClauses(Task6Cnf.exactlyOne(map[i][j]));   //Adding compulsions to CNF for board cells to contain exactly one value from the variables map.
		}
	
	public static void Lines(int[][][]map)
	{
		int[][][]LinesCheck=new int[map.length][map.length][map.length];
		for(int i=0;i<map.length;i=i+1)
			{
				LinesCheck[i]=TasksArrays.columns(map[i]);
				
			}
		for(int i=0;i<map.length;i=i+1)
			for(int j=0;j<map.length;j=j+1)
		SATSolver.addClauses(Task6Cnf.exactlyOne(LinesCheck[i][j]));    //Adding compulsions to CNF for board lines to contain exactly one value from the variables map.
		
	}
	public static void Blocks(int[][][]map,int sqrtN){
		int[][]BlocksCheck1=new int[map.length][map.length];
		int[][]BlocksCheck2=new int[map.length][map.length];
		for(int k=0;k<map.length;k=k+1)
		{
		for(int i=0;i<map.length;i=i+1)
		{
			for(int j=0;j<map.length;j=j+1)
			{
				BlocksCheck1[i][j]=map[i][j][k];
			}
		}
		BlocksCheck2=TasksArrays.blocks(BlocksCheck1, sqrtN);
		for(int i=0;i<BlocksCheck2.length;i=i+1)
			SATSolver.addClauses(Task6Cnf.exactlyOne(BlocksCheck2[i]));    //Adding compulsions to CNF for board blocks to contain exactly one value from the variables map.
		}
		     
		}
	public static void columns(int[][][]map)
	{
		
		int[][][]ColumnsCheck=new int[map.length][map.length][map.length];
		for(int i=0;i<map.length;i=i+1)
			for(int j=0;j<map.length;j=j+1)
			{
				ColumnsCheck[i][j]=map[j][i];
			}
		for(int i=0;i<map.length;i=i+1)
		{
			ColumnsCheck[i]=TasksArrays.columns(ColumnsCheck[i]);
		}
			for(int i=0;i<map.length;i=i+1)
				for(int j=0;j<map.length;j=j+1)
			SATSolver.addClauses(Task6Cnf.exactlyOne(ColumnsCheck[i][j]));     //Adding compulsions to CNF for board columns to contain exactly one value from the variables map.
	}
			
				
	
	
	
	
	
	public static void encode(int sqrtN, int[][] hints, int[][][] map) {
		int i;
		int[]HintsCnf=new int[1];
		for(i=0;i<hints.length;i=i+1)
		{
			HintsCnf[0]=Task7Map.varName(hints[i][0],hints[i][1],hints[i][2]-1,sqrtN*sqrtN);  
			SATSolver.addClause(HintsCnf);             ////Adding compulsions to CNF that ensures hints values to be on the board.
		}
		Lines(map);
		columns(map);
		Cells(map);
		Blocks(map,sqrtN);
		
		
		
	               
					
		
	}
}
