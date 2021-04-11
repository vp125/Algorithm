package miu.edu.cs435.lab06;

import java.util.Arrays;

public class QuickSort {
    public void generateSample(int arr_num[], int max){
        for(int i=0;i<arr_num.length;i++){
            arr_num[i] = (int)(Math.random() * max);
        }
    }
    public void swap(int arr_num[], int i, int j){
        int tmp = arr_num[i];
        arr_num[i] = arr_num[j];
        arr_num[j] = tmp;
    }

    public void sort(int arr_num[], int start, int stop) {
        int i = start;
        int j = stop - 2;
        swap(arr_num,0, stop-1);
        while(i <= j){
            while(i < stop && arr_num[i] < arr_num[stop-1]) i++;
            while(j >= start && arr_num[j] >= arr_num[stop-1]) j--;
            if(i<j){
                swap(arr_num,i,j);
            }
        }
        swap(arr_num,i,stop-1);
    }

    public static void main(String[] args) {
        //int arr[] = {8, 7, 6, 5, 4, 3, 2, 1, 9};
        int arr[] = {5, 6};
        QuickSort qs = new QuickSort();
        qs.sort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
