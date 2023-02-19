package com.jirui.likou.tanxin;

public class Jump {
    public static void main(String[] args) {
        int [] a = {1,1,1,1};
        System.out.println(Jump.jump(a));
    }

    /**
     * 使用正向查找可到达的最大位置方式进行贪心算法，该实现方法有两个巧妙的地方
     * 1：数组元素+下标 表示从该点可以到达的最远点，默认先走到最远点。
     * 2：通过遍历数组中的每一个元素，确定可以到达的最远点（这里忽略了需要走哪些节点），
     * 当遍历到该点（最大可达，通过end这个变量，近似代替关键点，表示确定了关键点。但是没有明确指出哪些是关键步骤）
     * 的时候，通过计算最远路径和之前的进行大小比较来判断该点是否应该作为关键步骤。是则加1，不是则忽略
     * @param nums 数组
     * @return 最小步骤数
     */
    public static int jump(int[] nums) {
        int size = nums.length;
        int step = 0;
        int maxPosition = 0;
        int end= 0;
        for(int i=0;i<size-1;i++){
            maxPosition = Math.max(maxPosition, i+nums[i]);
            if(i==end){
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
    /**
     * 通过反向查找出发位置，既从前往后遍历数组，查找第一个可以直接到达结尾节点的点，然后以该点为结尾节点继续查找。
     * @param nums
     * @return
     */
    public static int jump1(int[] nums){
        int position = nums.length;
        int step = 0;
        while(position>0){
            for(int i=0;i<position;i++){
                if(nums[i]+i>=position){
                    position = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }
}
