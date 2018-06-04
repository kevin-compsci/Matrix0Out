/*
Kevin Nguyen
Basic Java program to 0 out any rows and columns where there is atleast 1 0 element in the matrix or grid.

How to run (linux):
	1.) open command line and cd into directory folder of where this code is
	2.) type in "javac *.java" to compile java files
	3.) type in "java javaMatrix0"
*/

//imports
import java.io.*;
import java.util.*;

//class
class JavaMatrix0 {
	//Global Declarations

	//main driver
	public static void main(String[] args) {
		//local Declarations
		int sizeRow = 10, sizeCol = 10; //array sizes

		//get initial grid
		int[][] myGrid = initializeGrid(sizeRow, sizeCol);

		//print intial
		System.out.println("INITIAL");
		printGrid(myGrid);

		//check grid and 0 out any rows/colums
		myGrid = zeroOutGrid(myGrid);

		//print results
		System.out.println("RESULT");
		printGrid(myGrid);
	}

	//initialize grid with random ints
	public static int[][] initializeGrid(int sizeRow, int sizeCol) {
		//local declarations
		int i = 0, j = 0;
		int[][] myGrid = new int[sizeRow][sizeCol];
		Random rand = new Random();

		//loop through all elements in grid
		while(i < sizeRow) {
			while (j < sizeCol) {
				myGrid[i][j] = rand.nextInt(10);
				j++;
			}
			i++; j=0;
		}
		return myGrid; //return grid;
	}

	//check grid and 0 out any rows/columns as needed (exception if already zero out)
	public static int[][] zeroOutGrid(int[][] myGrid) {
		//local declaratoins
		int i = 0, j = 0;
		HashMap<Integer, Integer> refMap = new HashMap<Integer, Integer>();

		//interate over all elements in grid to check for 0s
		while(i < myGrid.length) {
			while(j < myGrid[i].length) {
				//conditional to check if element is 0 or row/col has already been 0'd
				if(myGrid[i][j] == 0 && (!refMap.containsKey(i) && !refMap.containsValue(j))) {
					//call helper function to 0 out
					myGrid = setZeros(myGrid, i, j);

					//add row & col to refList as ref
					refMap.put(i,j);
				}
				j++;
			}
			i++; j=0;
		}
		return myGrid;
	}

	//set values 0 and return new grid
	public static int[][] setZeros(int[][] myGrid, int refRow, int refCol) {
		//local declarations
		int i = 0, j = 0;

		//zero out the col where refCol starts
		while(i < myGrid.length) {
			myGrid[i][refCol] = 0;
			i++;
		}

		//zero out the row where refRow starts
		while(j < myGrid[refRow].length) {
			myGrid[refRow][j] = 0;
			j++;
		}

		return myGrid;
	}

	//print out elements
	public static void printGrid(int[][] myGrid) {
		//local declarations
		int i = 0, j = 0;

		//print out elements 
		while(i < myGrid.length) {
			while(j < myGrid[i].length) {
				System.out.print(myGrid[i][j]); //print element
				j++;
			}
			System.out.println(""); //new line
			i++;j=0;
		}
	}
}