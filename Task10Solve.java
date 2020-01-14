//This classe's purpose is to solve a sudoku instance with given dimensions and hints.
//By:Tomer Sivan, 312595192
//Last modified:30/11/2017, 21:25
public class Task10Solve {
	
	public static int[][] solve(int sqrtN, int[][] hints) {
		int[][][]map=new int[sqrtN*sqrtN][sqrtN*sqrtN][sqrtN*sqrtN];
		boolean[] Solution=new boolean[sqrtN*sqrtN*sqrtN*sqrtN*sqrtN*sqrtN+1];//Creating a boolean array for the CNF solution.
		int[][]board=new int[sqrtN*sqrtN][sqrtN*sqrtN];
		map=Task7Map.varsMap(sqrtN*sqrtN);    //Creating the variable map based on variables quantity.
		SATSolver.init(sqrtN*sqrtN*sqrtN*sqrtN*sqrtN*sqrtN);  //Initiating SAT solver.
		Task8Encode.encode(sqrtN, hints, map);  //Encoding solution into CNF based on hints and dimensions.
		Solution=SATSolver.getSolution();       //Getting the solution for the sudoku instance.
		board=Task9Decode.mapToBoard(map, sqrtN*sqrtN, Solution);//Decoding the solution and assigning it to the instance.
		if(Solution.length==0)   //Checking if there is a satisfying assigning.
			board=null;
		else if (Solution==null)   //Checking if there is a timeout in calculation.
			throw new RuntimeException("Solver didn't find a suitable solution");
		if(!Task5Verify.isSolution(sqrtN, hints, board))  //In case we found a satisfying assigning,checking if board is a legal board.
			throw new RuntimeException("Board is an illegal board");
		return board;
		
	}
}
