package com.assignment1;

public class Main {

    public static void main(String[] args) {
        //using an interface makes testing a lot easier and cleaner
	    IPallindrome pallindrome = new ReversePallindrome();
        System.out.println("ReverseRunning");
        runDecTest(pallindrome);
        runBinaryTest(pallindrome);
        runBothPallindromes(pallindrome);
        pallindrome = new ComparePallindrome();
        System.out.println("CompareRunning");
        runDecTest(pallindrome);
        runBinaryTest(pallindrome);
        runBothPallindromes(pallindrome);
        pallindrome = new StackQueuePallindrome();
        System.out.println("StackQueueRunning");
        runDecTest(pallindrome);
        runBinaryTest(pallindrome);
        runBothPallindromes(pallindrome);
    }

    public static String dec2Binary(String input)
    {
        int decimal = Integer.parseInt(input);
        int remainder = 0;
        int quotient = decimal;
        String output = "";
        StringBuilder builder = new StringBuilder(output);

        while(quotient!=0)
        {
            remainder = quotient%2;
            quotient = quotient/2;
            builder.append(remainder);
        }
        return builder.reverse().toString();
    }
    //runs test for different methods based on interface passed to it
    public  static  void runDecTest(IPallindrome pallindrome)
    {
        System.out.println("NumOperations,TimeTaken");
        int totalOps = 0;

        long startTime = System.currentTimeMillis();
        long endTime = 0;

        for(int i =0;i<= 1000000;i++){
            boolean isPallindrome =  pallindrome.solvePallindrome(String.valueOf(i));
            totalOps+=pallindrome.getNumOperations();
            //print every 50,000 times, this makes testing for different ranges etc very easy
            if(i%50000 == 0)
            {
                endTime=System.currentTimeMillis();
                System.out.println(totalOps+","+(endTime-startTime));
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println(totalOps+","+(endTime-startTime));
    }

    public static  void runBinaryTest(IPallindrome pallindrome)
    {
        System.out.println("NumOperations,TimeTaken");
        int totalOps = 0;

        long startTime = System.currentTimeMillis();
        long endTime = 0;

        for(int i =0;i<= 1000000;i++){
            String binary = dec2Binary(String.valueOf(i));
            boolean isPallindrome =  pallindrome.solvePallindrome(binary);
            totalOps+=pallindrome.getNumOperations();
            //print every 50,000 times, this makes testing for different ranges etc very easy
            if(i%50000 == 0)
            {
                endTime=System.currentTimeMillis();
                System.out.println(totalOps+","+(endTime-startTime));
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println(totalOps+","+(endTime-startTime));
    }

    public static void runBothPallindromes(IPallindrome pallindrome)
    {
        System.out.println("NumOperations,TimeTaken,NumMatches");
        int totalOps = 0;
        int numBothPallindrom = 0;

        long startTime = System.currentTimeMillis();
        long endTime = 0;

        for(int i =0;i<= 1000000;i++){
            String binary = dec2Binary(String.valueOf(i));
            boolean isBinaryPallindrome =  pallindrome.solvePallindrome(binary);
            totalOps+=pallindrome.getNumOperations();
            boolean isDecPallindrome = pallindrome.solvePallindrome(String.valueOf(i));
            totalOps+=pallindrome.getNumOperations();

            if(isBinaryPallindrome && isDecPallindrome)
                numBothPallindrom++;
            //print every 50,000 times, this makes testing for different ranges etc very easy
            if(i%50000 == 0)
            {
                endTime=System.currentTimeMillis();
                System.out.println(totalOps+","+(endTime-startTime)+","+numBothPallindrom);
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println(totalOps+","+(endTime-startTime)+","+numBothPallindrom);
    }
}
