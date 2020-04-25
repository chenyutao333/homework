package lab4;

import java.util.*;
public class Matrix {
	public static double[][] MatrixGenerator (int size1,int size2){
		double[][] matrix = new double[size1][size2];
		for(int i=0;i<size1;i++) {
			for(int j=0;j<size2;j++) {
				matrix[i][j] = new Random().nextDouble();
			}
		}
		return matrix;
	}
	public static double[][] serial(double[][] Matrix1,double[][] Matrix2){
		double[][] matrix = new double[Matrix1.length][Matrix2[0].length];
		
		for (int i = 0; i < Matrix1.length; i++) {
			for (int j = 0; j < Matrix2[0].length; j++) {
				for (int k = 0; k < Matrix1[0].length; k++)
					matrix[i][j] += Matrix1[i][k] * Matrix2[k][j];
			}
		}
		return matrix;
	}
	public static double[][] multiThread1(double[][] Matrix1,double[][] Matrix2){
		double[][] matrix = new double[Matrix1.length][Matrix2[0].length];
		runnable r1 = new runnable(Matrix1,Matrix2,0,2);
		runnable r2 = new runnable(Matrix1,Matrix2,1,2);
		r1.run();
		r2.run();
		for(int i=0;i<Matrix1.length;i++) {
			for(int j=0;j<Matrix2[0].length;j++) {
				if(i%2==0) {
					matrix[i][j] = r1.Matrix[i][j];
				}else {
					matrix[i][j] = r2.Matrix[i][j];
				}
				
			}
		}
		return matrix;
	}
	public static double[][] multiThread2(double[][] Matrix1,double[][] Matrix2){
		double[][] matrix = new double[Matrix1.length][Matrix2[0].length];
		runnable r1 = new runnable(Matrix1,Matrix2,0,3);
		runnable r2 = new runnable(Matrix1,Matrix2,1,3);
		runnable r3 = new runnable(Matrix1,Matrix2,2,3);
		r1.run();
		r2.run();
		r3.run();
		for(int i=0;i<Matrix1.length;i++) {
			for(int j=0;j<Matrix2[0].length;j++) {
				if(i%3==0) {
					matrix[i][j] = r1.Matrix[i][j];
				}else if(i%3==1){
					matrix[i][j] = r2.Matrix[i][j];
				}else {
					matrix[i][j] = r3.Matrix[i][j];
				}
				
			}
		}
		return matrix;
	}
	public static double[][] multiThread3(double[][] Matrix1,double[][] Matrix2){
		double[][] matrix = new double[Matrix1.length][Matrix2[0].length];
		runnable r1 = new runnable(Matrix1,Matrix2,0,4);
		runnable r2 = new runnable(Matrix1,Matrix2,1,4);
		runnable r3 = new runnable(Matrix1,Matrix2,2,4);
		runnable r4 = new runnable(Matrix1,Matrix2,3,4);
		r1.run();
		r2.run();
		r3.run();
		r4.run();
		for(int i=0;i<Matrix1.length;i++) {
			for(int j=0;j<Matrix2[0].length;j++) {
				if(i%4==0) {
					matrix[i][j] = r1.Matrix[i][j];
				}else if(i%4==1){
					matrix[i][j] = r2.Matrix[i][j];
				}else if(i%4==2){
					matrix[i][j] = r3.Matrix[i][j];
				}else {
					matrix[i][j] = r4.Matrix[i][j];
				}
				
			}
		}
		return matrix;
	}
	public static void check(double[][] Matrix1,double[][] Matrix2) {
		for(int i=0;i<Matrix1.length;i++) {
			for(int j=0;j<Matrix2[0].length;j++) {
				assert Matrix1[i][j] == Matrix2[i][j] : "The anwser is false";
				
			}
		}
		
		System.out.println("The anwser is true");
	}
	public static void main(String args[]) {
		for(int i=0;i<=9;i++) {
			int randInt1 = new Random().nextInt(100) + i*100;
			int randInt2 = new Random().nextInt(100) + i*100;
			int randInt3 = new Random().nextInt(100) + i*100;
			System.out.println(randInt1+" "+randInt2+" "+randInt3);
			double[][] matrix1 = new double[randInt1][randInt2];
			double[][] matrix2 = new double[randInt2][randInt3];
			double[][] matrix3 = new double[randInt1][randInt3];
			double[][] matrix4 = new double[randInt1][randInt3];
			double[][] matrix5 = new double[randInt1][randInt3];
			double[][] matrix6 = new double[randInt1][randInt3];
			matrix1 = MatrixGenerator (randInt1,randInt2);
			matrix2 = MatrixGenerator (randInt2,randInt3);
			double startTime1 = System.currentTimeMillis();
			matrix3 = serial(matrix1,matrix2);
			double endTime1 = System.currentTimeMillis();
			System.out.println("串行计算时间:" + (endTime1 - startTime1));
			double startTime2 = System.currentTimeMillis();
			matrix4 = multiThread1(matrix1,matrix2);
			double endTime2 = System.currentTimeMillis();
			System.out.println("2线程并行计算时间:" + (endTime2 - startTime2));
			check(matrix3,matrix4);
			double startTime3 = System.currentTimeMillis();
			matrix5 = multiThread1(matrix1,matrix2);
			double endTime3 = System.currentTimeMillis();
			System.out.println("3线程并行计算时间:" + (endTime3 - startTime3));
			check(matrix3,matrix5);
			double startTime4 = System.currentTimeMillis();
			matrix6 = multiThread1(matrix1,matrix2);
			double endTime4 = System.currentTimeMillis();
			System.out.println("4线程并行计算时间:" + (endTime4 - startTime4));
			check(matrix3,matrix6);
		}
	}
}
