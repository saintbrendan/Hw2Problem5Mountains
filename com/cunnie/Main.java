package com.cunnie;

public class Main {

    public static void main(String[] args) {
        for (int m = 1; m <= 5; m++) {
            for (int n = 1; n <= 5; n++) {
                int[] heights = new int[n];
                int c = getPeakCountRecursive(heights, 0, m);
                System.out.printf("  %d %d: %4d / %4.0f   ", m, n, c, Math.pow(m, n));
            }
            System.out.println();
        }
    }

    private static int getPeakCountRecursive(int[] peaks, int ni, int m) {
        int count = 0;
        for (int height = 1; height <= m; height++) {
            peaks[ni] = height;
            if (ni == peaks.length - 1) {
                count += getPeakCount(peaks);
            } else {
                count += getPeakCountRecursive(peaks, ni + 1, m);
            }
        }
        return count;
    }

    private static int getPeakCount(int[] heights) {
        int count = 0;
        for (int i = 1; i < heights.length - 1; i++) {
            if (heights[i] > heights[i - 1] && heights[i] > heights[i + 1]) {
                count++;
            }
        }
        return count;
    }

    private static void printArray(int[] peaks) {
        for (int height : peaks
        ) {
            System.out.printf("%d ", height);
        }
        System.out.println();
    }
}
