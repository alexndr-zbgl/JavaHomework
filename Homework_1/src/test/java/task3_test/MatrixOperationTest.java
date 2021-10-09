package task3_test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import task3.MatrixOperation;

import static org.testng.Assert.assertEquals;

public class MatrixOperationTest {

    @Test(dataProvider = "matrixProvider")
    public void checkAreaResult(int[][] matrix, int expected) {
        assertEquals(MatrixOperation.matrixChallenge(matrix), expected);
    }


    @DataProvider
    public Object[][] matrixProvider() {
        return new Object[][]{
                {new int[][]
                       {{1, 1, 1},
                        {0, 1, 1},
                        {1, 1, 1}},
                        6},
                {new int[][]{
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1}},
                        9},
                {new int[][]{
                        {1, 1, 1},
                        {0, 1, 1},
                        {1, 1, 1}},
                        6},
                {new int[][]{
                        {1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1}},
                        15},
                {new int[][]{
                        {1, 0, 1, 1, 1},
                        {1, 1, 0, 1, 1},
                        {1, 1, 1, 0, 1}},
                        4},
                {new int[][]{
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0}},
                        0},
                {new int[][]{
                        {0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 1, 1, 1, 0},
                        {0, 1, 1, 1, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0}},
                        6},
                {new int[][]{
                        {0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 1, 1, 1, 0},
                        {0, 1, 1, 1, 0},
                        {0, 1, 1, 0, 0},
                        {0, 1, 1, 0, 0}},
                        8},
                {new int[][]{
                        {1},
                        {1},
                        {1},
                        {1},
                        {1},
                        {1}},
                        6},
                {new int[][]{
                        {0, 0, 1, 1, 1}},
                        3},
        };
    }
}
