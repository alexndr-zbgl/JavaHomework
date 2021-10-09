package task3;

import java.util.Stack;

public class MatrixOperation {

    public static int matrixChallenge(int[][] matrix) {
        int maxArea = 0;
        int[] result = new int[matrix[0].length]; // used for saving sum of rows of the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) result[j] += 1; // increase the result if the element = 1 otherwise the result will be 0
                else result[j] = 0;
            }
            maxArea = maxRectangleArea(result, maxArea); // change the maxArea every iteration
        }
        return maxArea; // returns the largest area (built only with 1s) of the matrix
    }


    private static int maxRectangleArea(int[] result, int maxArea) {
        Stack<Integer> stack = new Stack<Integer>(); // collects indexes of 'result' array
        int i = 0;
        // run through the given array
        while (i < result.length) {
            // if the 'i' element of the given array is bigger than top element of stack
            // we push the index in there
            if (stack.isEmpty() || result[stack.peek()] <= result[i]) {
                stack.push(i);
                i++;
            }
            // otherwise we calculate an area of the rectangle
            // we know that left and right side of current bar (top of stack) is smaller than this bar
            // so we find the area (width = positionOfLeftSide  - positionOfRightSide - 1, height = value of topOfStack position)
            else {
                int index = stack.pop();
                int left;
                int right = i;
                if (stack.empty()) {
                    left = -1;
                }
                else {
                    left = stack.peek();
                }
                int currentArea = (right - left - 1) * result[index];
                if (currentArea > maxArea) maxArea = currentArea;
            }
        }
        // we do the same operations for the rest of bars
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int left;
            int right = i;
            if (stack.empty()) {
                left = -1;
            }
            else {
                left = stack.peek();
            }
            int currentArea = (right - left - 1) * result[index];
            if (currentArea > maxArea) {
                maxArea = currentArea;
            }
        }
        return maxArea;
    }
}
