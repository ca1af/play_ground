package com.example.play_ground.find_algorithm;

public class PrefixSum {
    public static void main(String[] args) {
        int[] arr = {3, 1, 7, 4, 2, 9};

        int[] prefixSum = new int[arr.length];

        prefixSum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        for (int i = 0; i < prefixSum.length; i++) {
            System.out.print(prefixSum[i] + " ");
        }
        System.out.println();

        int prefix = noPrefix(1, 3);
        System.out.println(prefix);
    }

    public static int noPrefix(int startIdx, int endIdx){
        int[] arr = {3, 1, 7, 4, 2, 9};

        // 1, 3

        int sum = 0;

        for (int i = startIdx; i <= endIdx; i++) {
            sum += arr[i];
        }

        return sum;
    }


}

