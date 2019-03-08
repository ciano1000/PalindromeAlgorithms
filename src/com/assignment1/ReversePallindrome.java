package com.assignment1;

public class ReversePallindrome implements IPallindrome{

    private int numOperations;

    @Override
    public boolean solvePallindrome(String input) {
        numOperations = 0;
        int inputSize = input.length();//assignment is one Operation, retrieving length is 1
        numOperations++;
        String reversed = "";//assignment is 1 op
        numOperations++;

        numOperations++;
        for(int i = inputSize-1;i>=0;i--)//loop initialising is one Operation
        {
            reversed += input.charAt(i);//assignment, array reference and addition is three ops per loop
            numOperations+=3;
            //decrementing i is two ops per loop(assignment and subtraction)
            numOperations+=2;
        }

        numOperations+=2;
        if(reversed.equals(input))//two operations
        {
            //return is one Operation
            numOperations++;
            return  true;
        }
        else{
            numOperations++;
            return  false;
        }
    }

    @Override
    public int getNumOperations() {
        return numOperations;
    }
}
