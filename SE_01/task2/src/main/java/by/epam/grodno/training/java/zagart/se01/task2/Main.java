package by.epam.grodno.training.java.zagart.se01.task2;

public class Main 
{
	static int[] array;
	
    public static void main(String[] args) {
    	
    	Loops action = new Loops();
    	arrayRefresh();
    	for (int i = 1; i <= 4; i++) {
            switch (i) {
            case 1 : printArray(action.forLoop(array)); break;
            case 2 : printArray(action.forEachLoop(array)); break;
            case 3 : printArray(action.whileLoop(array)); break;
            case 4 : printArray(action.doWhileLoop(array)); break;
            }
    	}
 	}	
    
    private static void printArray(int[] array) {
    	arrayRefresh();
    	for (int i : array) System.out.print(i + " ");
    	System.out.println();
    	System.out.println();
    }
    
    private static void arrayRefresh() {
    	int[] new_array = {0,2,6,6,8,10};
    	Main.array = new_array;
    }
    
    
}