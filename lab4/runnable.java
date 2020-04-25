package lab4;

public class runnable implements Runnable{
	double[][] Matrix1;
	double[][] Matrix2;
	double[][] Matrix;
	int Start;
	int Number;
	public runnable(double[][] matrix1,double[][] matrix2,int start,int number) {
		Matrix1 = matrix1;
		Matrix2 = matrix2;
		Start = start;
		Matrix = new double[matrix1.length][matrix2[0].length];
		Number = number;
	}
	public void run() {
	      try {
	         for(int i=Start;i<Matrix1.length;i+=Number) {
	        	 for(int j=0;j<Matrix2[0].length;j++) {
	        		 for(int k=0;k<Matrix1[0].length;k++) {
	        			 Matrix[i][j] += Matrix1[i][k] * Matrix2[k][j];
	        		 }
	        	 }
	            
	         }
	      }catch (Exception e) {
	           e.printStackTrace();  
	      }
	      
	   }
}
