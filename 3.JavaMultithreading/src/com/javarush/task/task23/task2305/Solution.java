package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution solution = new Solution();
        solution.innerClasses[0] = new Solution().new InnerClass();
        solution.innerClasses[1] = new Solution().new InnerClass();
        Solution solution1 = new Solution();
        solution1.innerClasses[0] = new Solution().new InnerClass();
        solution1.innerClasses[1] = new Solution().new InnerClass();
        Solution[] solutions = {solution,solution1};
        return solutions;
    }

    public static void main(String[] args) {

    }
}
