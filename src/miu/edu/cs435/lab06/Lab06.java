package miu.edu.cs435.lab06;

import java.util.Arrays;
import java.util.WeakHashMap;

public class Lab06 {
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

    public void WoodenBlockToy1(int arr_num[]){
        int i = 0;
        int j = arr_num.length - 1;

        while(i <= j) {
            while(i < arr_num.length - 1 && arr_num[i] == 0) i++;
            while(j > 0 && arr_num[j] == 1) j--;

            if(i < j){
                swap(arr_num,i,j);
                i++;
                j--;
            }
        }
    }

    public void WoodenBlockToyGeneral(int arr_num[], int start, int stop, int color, int max){
        int i = start;
        int j = stop - 1;

        while(i <= j) {
            while(i < stop && arr_num[i] == color) i++;
            while(j > start && arr_num[j] != color) j--;

            if(i < j){
                swap(arr_num,i,j);
                i++;
                j--;
            }
        }
        if(color < max){
            WoodenBlockToyGeneral(arr_num,i,stop,color+1,max);
        }

    }

    public static void main(String[] args) {
        Lab06 lab06 = new Lab06();

        int arr1[] = new int[20];
        lab06.generateSample(arr1,2);
        System.out.println(Arrays.toString(arr1));
        lab06.WoodenBlockToy1(arr1);
        System.out.println(Arrays.toString(arr1));

        int arr2[] = new int[30];
        lab06.generateSample(arr2,3);
        System.out.println(Arrays.toString(arr2));
        lab06.WoodenBlockToyGeneral(arr2,0,arr2.length,0,2);
        System.out.println(Arrays.toString(arr2));

        int arr3[] = new int[40];
        lab06.generateSample(arr3,4);
        System.out.println(Arrays.toString(arr3));
        lab06.WoodenBlockToyGeneral(arr3,0,arr3.length,0,3);
        System.out.println(Arrays.toString(arr3));
    }
}
