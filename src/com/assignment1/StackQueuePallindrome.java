package com.assignment1;

public class StackQueuePallindrome implements IPallindrome {

    public int numOperations = 0;

    @Override
    public boolean solvePallindrome(String input) {
        numOperations = 0;

        ArrayStack stack = new ArrayStack();//1 op
        ArrayQueue queue = new ArrayQueue();//1 op
        numOperations+=2;

        boolean isPalindrome = true;// 1op
        numOperations++;

        numOperations++;
        for(int i = 0; i<input.length();i++)//loop initialisation
        {
            stack.push(input.charAt(i));//calling method and array ref, 2 ops
            queue.enqueue(input.charAt(i));//"..."
            numOperations+=4;
            //incrementing i and assigning
            numOperations+=2;
        }
        numOperations++;
        for(int i=0;i<input.length();i++)
        {
            char c = (char)stack.pop();
            char d = (char)queue.dequeue();
            numOperations+=4;

            numOperations++;
            if(!(c==d))//comparison
            {
                isPalindrome =false;
                numOperations++;
                break;
            }
        }
        numOperations++;
        return isPalindrome;
    }

    @Override
    public int getNumOperations() {
        return numOperations;
    }

}
