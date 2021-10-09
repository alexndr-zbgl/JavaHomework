package task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int rowSize = 0;
    private static int columnSize = 0;
    private static List<String> matrixInput = new ArrayList<>();

    public Main(){
        scanner = new Scanner(System.in);
        matrixInput = new ArrayList<>();
    }


    private static List<String> input(){
        boolean onlySpecificCharacters = false;
        for (int i = 0; i < rowSize; i++) {
            String tempString = scanner.next();
            if (i==0) columnSize = tempString.length();
            for (Character c: tempString.toCharArray()) {
                if (c.equals('0') || c.equals('1')) onlySpecificCharacters = true;
                else {
                    onlySpecificCharacters = false;
                    break;
                }
            }
            if (tempString.length()>0 && tempString.length()==columnSize && onlySpecificCharacters) {
                matrixInput.add(tempString);
            }
            else {
                i--;
                System.out.println("False");
            }
        }
        return matrixInput;
    }
    

    private static int[][] parsingString(){
        int[][] matrix = new int[rowSize][columnSize];
        for (int i = 0; i < matrixInput.size(); i++) {
            for (int j = 0; j < matrixInput.get(i).toCharArray().length; j++) {
                matrix[i][j] = Character.getNumericValue(matrixInput.get(i).toCharArray()[j]);
            }
        }
        return matrix;
    }


    public static void main(String[] args) {
        System.out.println("Input amount of rows: ");
        rowSize = scanner.nextInt();
        Main.input();
        MatrixOperation.matrixChallenge(Main.parsingString());
        System.out.println(MatrixOperation.matrixChallenge(Main.parsingString()));
    }
}
