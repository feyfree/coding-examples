package com.feyfree.basic.complement;

// Java program to print 1's and 2's complement of
// a binary number

class GFG
{

    // Returns '0' for '1' and '1' for '0'
    static char flip(char c)
    {
        return (c == '0') ? '1' : '0';
    }

    // Print 1's and 2's complement of binary number
    // represented by "bin"
    static void printOneAndTwosComplement(String bin)
    {
        int n = bin.length();
        int i;

        new StringBuilder();
        StringBuilder ones;
        String twos;
        ones = new StringBuilder();

        // for ones complement flip every bit
        for (i = 0; i < n; i++)
        {
            ones.append(flip(bin.charAt(i)));
        }

        // for two's complement go from right to left in
        // ones complement and if we get 1 make, we make
        // them 0 and keep going left when we get first
        // 0, make that 1 and go out of loop
        twos = ones.toString();
        for (i = n - 1; i >= 0; i--)
        {
            if (ones.charAt(i) == '1')
            {
                twos = twos.substring(0, i) + '0' + twos.substring(i + 1);
            }
            else
            {
                twos = twos.substring(0, i) + '1' + twos.substring(i + 1);
                break;
            }
        }

        // If No break : all are 1 as in 111 or 11111;
        // in such case, add extra 1 at beginning
        if (i == -1)
        {
            twos = '1' + twos;
        }

        System.out.println("1's complement: " + ones);;
        System.out.println("2's complement: " + twos);
    }

    // Driver code
    public static void main(String[] args)
    {
        String bin = "1100";
        printOneAndTwosComplement(bin);
    }
}

// This code contributed by Rajput-Ji
