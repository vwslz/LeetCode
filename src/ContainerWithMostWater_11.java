// O(n)
public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        if(height.length < 2)   return -1;
        int res = 0, left = 0, right = height.length - 1, temp;

        while (left < right){
            if (height[left] < height[right])    temp = (right - left)*height[left++];
            else    temp = (right - left)*height[right--];
            if (temp >  res)   res = temp;
        }
        return res;
    }
}
