import java.util.Arrays;

//Logic - minimum of (tallest building from that index to all the way to right-tallest building from that index to all the way to left) - height of the that index gives units of water stored at that index
public class RainwaterTrapping {
    public static void main(String[] args) {
        int[] heights = {5, 2, 7, 3, 6, 1, 2, 4};
        int unitsOfWaterStored = calculateUnitsStored(heights);
        System.out.println(unitsOfWaterStored);
    }

    private static int calculateUnitsStored(int[] heights) {
        int waterUnitsSum = 0;
        int[] rightTallestUptoThatIndex = new int[heights.length];
        int[] leftTallestUptoThatIndex = new int[heights.length];
        rightTallestUptoThatIndex[rightTallestUptoThatIndex.length - 1] = heights[heights.length - 1]; //since there is no other building to its right, so its itself tallest up to that index
        for (int i = heights.length - 2; i >= 0; i--) {
            rightTallestUptoThatIndex[i] = Math.max(heights[i], rightTallestUptoThatIndex[i + 1]);
        }
        leftTallestUptoThatIndex[0] = heights[0]; //since there is no other building to its left, so its itself tallest up to that index
        for (int i = 1; i < heights.length; i++) {
            leftTallestUptoThatIndex[i] = Math.max(heights[i], leftTallestUptoThatIndex[i - 1]);
        }
        for (int i = 0; i < heights.length; i++) {
            waterUnitsSum += Math.min(leftTallestUptoThatIndex[i], rightTallestUptoThatIndex[i]) - heights[i];
        }
        return waterUnitsSum;
    }
}
