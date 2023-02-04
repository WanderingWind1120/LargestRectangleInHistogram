package org.example;

public class LargestRectangleInHistogram {
    public int Solution (int [] height){
        if (height == null || height.length == 0){
            return 0;
        }
        int ans = 0;
        int [] lessthanleft = new int[];
        int [] lessthanright = new int[];
        lessthanright [height.length -1] = height.length;
        lessthanleft [0] = -1;

        for (int i = 1; i <= height.length -1; i++) {
            int p = i-1;
            while (p >= 0 && height[p] >= height[i]){
                p = lessthanleft[p];
            }
            lessthanleft[i] = p;
        }
        for (int i = height.length -2; i >= 0; i--){
            int p = i+1;

            while ( p <= height.length -1 && height[p] >= height[i]){
                p = lessthanright[p];
            }
            lessthanright [i] = p;
        }

        for (int i = 0; i <= height.length -1; i++){
            ans = Math.max(ans, height[i] * (lessthanright[i] - lessthanleft[i] -1));
        }
        return ans;
    }

}
