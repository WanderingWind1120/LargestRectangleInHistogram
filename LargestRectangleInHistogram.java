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
                p = lessthanright[p];// Cụ thể bản chất thuật toán này nếu viết tường minh ra không cần tối ưu về thời gian chạy và bộ nhớ
                // thì cái lessthanright ở vị trí cột hiện tại chính là tìm xem thứ tự cột bên phải xa nhất liên tiếp mà vẫn có độ cao lớn hơn 
                // cột hiện tại 
                // trong thuật toán tường minh thì cái while loop này mới thực sự có ý nghĩa 
                // Còn đây là dạng tối ưu cho thời gian chạy khi mà nó sẽ lấy kết quá của array lessthanright của cột ngay sau nó 
                // vì khi viết kiểu này nó sẽ giống với cái kiểu dùng một kết quả tính toán trước đó nên thực ra nó không sự tính toán 
                // nên chỗ này thậm trí còn dùng if statement được 
                // còn việc tại sao phải sử dụng p làm biến trung gian mà không sử dụng biến khác được 
                // vì khi cái while statement này không xảy ra thì mặc định cái giá trị của array lessthanright ở vị trí hiện tại sẽ có giá trị bằng chính nó là 
                // i và p (vì cái array này nó tìm số thực tự cột trong array height chứ không tìm giá trị 
            }
            lessthanright [i] = p;
        }

        for (int i = 0; i <= height.length -1; i++){
            ans = Math.max(ans, height[i] * (lessthanright[i] - lessthanleft[i] -1));
        }
        return ans;
    }

}
