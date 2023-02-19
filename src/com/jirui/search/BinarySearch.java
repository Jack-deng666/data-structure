package com.jirui.search;

public class BinarySearch {
    /**
     * 二分查找法
     * @param a
     * @param target
     * @return
     */
    public int binarySearch(int[] a, int target){
        int size = a.length;
        int left = 0;
        int right = size-1;
        // [left,right]
        while(left<=right){
            int middle = left+ (right-left)/2;
            if(a[middle] < target){
                left = middle+1;
            }else if(a[middle] > target){
                right = middle-1;
            }else{
                return middle;
            }
        }
        return -1;
    }

    /**
     * 二分查找第一个相等的数的索引
     * @param a
     * @param target
     * @return
     */
    public int binarySearchFirstEq(int[] a, int target){
        int size = a.length;
        int left = 0;
        int right = size-1;
        while(left<=right){
            int middle = left+ (right-left)/2;
            if(a[middle] < target){
                left = middle+1;
            }else if(a[middle] > target){
                right = middle-1;
            }else {
               if(middle ==0 || a[middle-1] !=target)
               {
                   return middle;
               }else{ right = middle-1;}
            }
        }
        return -1;
    }


    public static int lastEqual(int[] a, int value){
        int length = a.length;
        if(length==0) return -1;
        int low = 0;
        int high = length-1;
        while(low<=high){
            int mid = low+((high-low)>>1);
            if(a[mid] < value){
                low = mid+1;
            }else if (a[mid]>value){
                high = mid-1;
            }else {
                if(mid==length-1 || a[mid+1]!=value){
                    return mid;
                }
                else low=mid-1;
            }
        }
        return -1;

    }

    /**
     * 二分查找：第一个大于指定数值的位置。
     * @param a 目标数组
     * @param value 指定数值
     * @return 目标索引
     */
    public  static int firstLarge(int[]a , int value){
        int length = a.length;
        int low = 0;
        int high = length-1;
        while(low<=high){
            int mid = low+((high-low)>>1);
            if(a[mid] <= value){
                low = mid+1;
            }else{
                if(mid == 0 || a[mid-1]<=value){
                    return mid;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
