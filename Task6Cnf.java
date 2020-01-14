//This classe's purpose is to define three compulsions for developing a CNF formula.
//By:Tomer Sivan, 312595192
//Last modified:30/11/2017, 21:25


public class Task6Cnf {
	
	public static int[][] atLeastOne(int[] vars) {
		int [][]atLeastOne=new int[1][vars.length];
		for(int i=0;i<vars.length;i=i+1)
		{
			atLeastOne[0][i]=vars[i];         //Just copying all numbers as it is.
		}
		return atLeastOne;
		
	}
	
	public static int[][] atMostOne(int[] vars) {
		int length=0,i=0,j=0,k=0;
		for(i=vars.length-1;i>0;i=i-1)
		{
			length=length+i;             //Calculating matrix length based on number of syntaxes.
		}
         int AtMostOne[][]=new int[length][2];
         for(i=0;i<vars.length-1;i=i+1)
        	 for(j=i+1;j<vars.length;j=j+1)
        	 {
        		 AtMostOne[k][0]=vars[i]*-1;
                 AtMostOne[k][1]=vars[j]*-1;
                 k=k+1;
        	 }
         return AtMostOne;
         
        		 
        		 
        		 
        		        
                 		
                         
                         
         
         
	}
	
	public static int[][] exactlyOne(int[] vars) {
		int length=0;
		for(int i=vars.length-1;i>0;i=i-1)
		{
			length=length+i;                    //Calculating matrix length based on number of syntaxes.
		}
		                                                   
		int[][]exactlyOne=new int[length+1][vars.length];  //Setting matrixes length based on conditions.    
		int [][]atMostOne=new int[length][2];
		int[][]atLeastOne=new int[1][vars.length];
		atMostOne=atMostOne(vars);                // Getting "at most one" and "at least one" matrixes.
		atLeastOne=atLeastOne(vars);
		for(int i=0;i<length;i=i+1)     //Matching syntaxes between "at most one" condition and "at least one" condition.
				exactlyOne[i]=atMostOne[i];
			exactlyOne[length]=atLeastOne[0];
		
		return exactlyOne;

		        
				
			
			
		
	}
}
