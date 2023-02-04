package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) { // loop i từ trái sang phải từ phần tử thứ 2 trở đi
            int p = i - 1; // p kém i một đơn vị

            while (p >= 0 && height[p] >= height[i]) { // Nếu độ cao ở vị trí thứ p lớn hơn hoặc bằng  vị trị thứ i
                // Nếu độ cao cột bên trái lớn hơn
                p = lessFromLeft[p];
                // giả sử vị trị height 0 = 8 height[0] = 1
                // p lấy gias trị của  lessfromleft ở vị trí p (tức hiện tại là vị trí 0) = -1
            }
            lessFromLeft[i] = p; // nếu tình huống trên xảy ra nó sẽ dừng vòng loop while
            // và gán less from left ở vị trí số 1 = -1
            // nếu while statement không xảy ra thì giá trị của left fromfromleft ở vị trí thứ i sẽ là i -1

            // tức là cái while statement khi nó xảy ra mà cái đằng trước nó không xảy ra thì nó nhận giá trị là
            // p = p -1 luôn và dừng luôn vòng lặp while vì nếu trong vòng lặp trước
        }

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }
}