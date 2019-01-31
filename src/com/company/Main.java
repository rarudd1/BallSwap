package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static String ballswap(long[][] container) {
        int size = container.length;
        String result = "Impossible";
        long[] ballType = new long[size];
        long[] capacity = new long[size];

        //Add up the capacity of each container and amount of each ball type
        for(int i =0; i<size;i++)
        {
            for(int j =0; j<container[i].length;j++)
            {
                capacity[i] += container[i][j];
            }
            for(int j =0; j<container.length; j++)
            {
                ballType[i] +=container[j][i];
            }
        }
        //Set a flag for if a match is found
        boolean found = false;
        boolean[] used = new boolean[size];
        for(int i =0; i<size; i++)
        {
            used[i] = false;
        }
        for(int i =0; i<size; i++)
        {
            for(int j =0; j<size; j++)
            {
                if(capacity[i] == ballType[j]&& !used[j])
                {//If a match is found flag that that ballType was already used and break
                    found = true;
                    used[j] = true;
                    break;
                }
            }
            if(found && i== size -1)
            {//If a match has been found for all possible balls change result
                result = "Possible";
                break;
            }
            if(!found)
                break;
            else
                found = false;
        }
        return(result);

    }
    public static void main(String[] args) throws IOException {


        try (Scanner scanner = new Scanner(new FileReader("tests.txt"))) {


            int testCases = scanner.nextInt();

            for(int i=0; i<testCases; i++)
            {
                int testSize = scanner.nextInt();
                long[][] containers = new long[testSize][testSize];
                for (int j = 0; j < testSize; j++) {
                        for(int k =0; k< testSize; k++) {
                        containers[j][k] = scanner.nextInt();
                        }
                    }
                    System.out.println(ballswap(containers));
            }

        }
    }
}
