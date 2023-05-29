package com.example.play_ground.sort_algorithm.countingsort;

import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] arr) {
        // 입력값의 최대값을 찾기 (일반적으로 최대값이 주어져 있을 경우에 계수 정렬 사용 가능)
        int max = Arrays.stream(arr).max().getAsInt();

        // 빈도수 배열을 생성, 각 값의 빈도수를 계산
        int[] countArray = new int[max + 1];
        for (int num : arr) {
            countArray[num]++;
            // countArray 에, arr 에 존재하는 수의 인덱스를 ++
        }

        // 빈도수 배열을 순회하면서 정렬
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                arr[index++] = i;
                // 인덱스마다 적은 수 기준으로 계속 정렬
                countArray[i]--;
                // 중복이 있을 경우 1, 1, 1 이런식으로 계속 정렬됨
            }
        }


    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 9, 1, 7, 5, 5, 7};

        // 계수 정렬 수행
        countingSort(arr);

        // 정렬된 배열 출력
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

