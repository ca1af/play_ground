package com.example.play_ground.sort_algorithm.mergesort;


// 설명은 블로그로!

// https://velog.io/@calaf/%EB%B3%91%ED%95%A9-%EC%A0%95%EB%A0%AC
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 29, 10, 14, 37, 13 };
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int index = left; index < k; index++) {
            arr[index] = temp[index];
        }
    }
}

