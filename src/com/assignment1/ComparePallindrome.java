package com.assignment1;

public class ComparePallindrome implements IPallindrome {

    public int numOperations = 0;

    @Override
    public boolean solvePallindrome(String input) {
        numOperations = 0;
        int inputLength = input.length()-1;// 1 op
        numOperations++;
        boolean isPallindrome = true; //1 op
        numOperations++;
        numOperations++;
        for(int i=inputLength;i>=0;i--)//1op for initialisation
        {
            char left = input.charAt((i-inputLength)*-1);//assignment, array reference, subtraction and multiplication = 4 ops
            numOperations+=4;
            char right = input.charAt(i);//2 ops, assignment and array ref
            numOperations+=2;
            numOperations++;
            if(!(left == right))//1op
            {
                isPallindrome = false;
                numOperations++;
                break;
            }
            //i is assigned to i-1 each iteration: 2 ops
            numOperations+=2;
        }
        numOperations++;
        return  isPallindrome;
    }

    @Override
    public int getNumOperations() {
        return numOperations;
    }
}
