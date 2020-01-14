public class Task11Unique {
	
	public static int[][] solveUnique(int sqrtN, int[][] hints) {
		int[]clause=new int[sqrtN*sqrtN];
		int k=0;
		SATSolver.init(sqrtN*sqrtN*sqrtN*sqrtN*sqrtN*sqrtN);
		boolean[] Solution=new boolean[sqrtN*sqrtN*sqrtN*sqrtN*sqrtN*sqrtN+1];      //Same for Task10
		int[][][]map=new int[sqrtN*sqrtN][sqrtN*sqrtN][sqrtN*sqrtN]; 
		map=Task7Map.varsMap(sqrtN*sqrtN);
		int[][]board=new int[sqrtN*sqrtN][sqrtN*sqrtN];
		board=Task10Solve.solve(sqrtN, hints);
		while(k<sqrtN*sqrtN)
		for(int i=0;i<board.length;i=i+1)
			for(int j=0;j<board.length;j=j+1)
			{
				
				clause[k]=(Task7Map.varName(i, j, board[i][j], sqrtN*sqrtN))*-1;          //This time we add clauses with '-' to cancel the solution.        
				k=k+1;
			}
	        	SATSolver.addClause(clause);
	        	Task8Encode.encode(sqrtN, hints, map);
	        	Solution=SATSolver.getSolution();
	        	if(Solution!=null)
	        		board=null;
	        	 return board;
	        		
	        	
				
		
	}

}
