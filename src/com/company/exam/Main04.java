package com.company.exam;

public class Main04 {
    public static void main(String[] args) {
        int[] walls = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(walls));
    }

    public static int maxArea(int[] walls) {
        if (walls == null || walls.length == 0)
            return 0;
        int ans = 0;
        int n = walls.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int min = Math.min(walls[i], walls[j]);
                int area = min *  (j - i);
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }
}
