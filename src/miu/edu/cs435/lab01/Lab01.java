package miu.edu.cs435.lab01;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Lab01 {
    public void generateSample(int arr_num[], int max){
        for(int i=0;i<arr_num.length;i++){
            arr_num[i] = (int)(Math.random() * max);
        }
    }

    public long algo1(int arr_num[]){
        long time_start = System.nanoTime();
        int len = 0;
        int max_dis = 0;
        int tmp_dis = 0;
        int[] newArr = new int[arr_num.length];
        for(int i = 0;i<arr_num.length;i++){
            if(arr_num[i] % 2 == 0){
                newArr[len++] = arr_num[i];
            }
        }

        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                tmp_dis = Math.abs(newArr[j] - newArr[i]);
                if(tmp_dis > max_dis){
                    max_dis = tmp_dis;
                }
            }
        }
        //System.out.println("[ALGO_01] Max Distance:" + max_dis);
        return System.nanoTime() - time_start;
    }

    public long algo2(int arr_num[]){
        long time_start = System.nanoTime();
        int max_dis = 0;
        int tmp_dis = 0;
        for(int i=0;i<arr_num.length;i++){
            if(arr_num[i] % 2 == 0){
                for(int j=i+1;j<arr_num.length;j++){
                    if(arr_num[j] % 2 == 0) {
                        tmp_dis = Math.abs(arr_num[j] - arr_num[i]);
                        if(tmp_dis > max_dis){
                            max_dis = tmp_dis;
                        }
                    }
                }
            }

        }
        //System.out.println("[ALGO_02] Max Distance:" + max_dis);
        return System.nanoTime() - time_start;
    }

    public long algo3(int arr_num[]){
        long time_start = System.nanoTime();
        int max_dis = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr_num.length;i++){
            if(arr_num[i] % 2 == 0) {
                if(arr_num[i] > max){
                    max = arr_num[i];
                }
                if(arr_num[i] < min){
                    min = arr_num[i];
                }
            }
        }
        //System.out.println("MAX: " + max + " MIN: " + min);
        max_dis = max - min;

        //System.out.println("[ALGO_03] Max Distance:" + max_dis);
        return System.nanoTime() - time_start;
    }

    public long algo4(int arr_num[]){
        long time_start = System.nanoTime();
        long max = Arrays.stream(arr_num).filter(n -> n % 2 == 0).max().orElse(0);
        long min = Arrays.stream(arr_num).filter(n -> n % 2 == 0).min().orElse(0);
        long max_dis = max - min;
        //System.out.println("MAX: " + max + " MIN: " + min);
        //System.out.println("[ALGO_04] Max Distance:" + max_dis);
        return System.nanoTime() - time_start;
    }

    public static void main(String[] args) {
        Lab01 lab01 = new Lab01();

        // 1000 SAMPLE
        int[] arr1k = new int[1000];
        lab01.generateSample(arr1k,1000);
        System.out.println("1000 sample: ALGO_01: " + lab01.algo1(arr1k));
        System.out.println("1000 sample: ALGO_02: " + lab01.algo2(arr1k));
        System.out.println("1000 sample: ALGO_03: " + lab01.algo3(arr1k));
        System.out.println("1000 sample: ALGO_04: " + lab01.algo4(arr1k));

        // 2000 SAMPLE
        int[] arr2k = new int[2000];
        lab01.generateSample(arr2k,1000);
        System.out.println("===========================");
        System.out.println("2000 sample: ALGO_01: " + lab01.algo1(arr2k));
        System.out.println("2000 sample: ALGO_02: " + lab01.algo2(arr2k));
        System.out.println("2000 sample: ALGO_03: " + lab01.algo3(arr2k));
        System.out.println("2000 sample: ALGO_04: " + lab01.algo4(arr2k));

        // 3000 SAMPLE
        int[] arr3k = new int[3000];
        lab01.generateSample(arr3k,1000);
        System.out.println("===========================");
        System.out.println("3000 sample: ALGO_01: " + lab01.algo1(arr3k));
        System.out.println("3000 sample: ALGO_02: " + lab01.algo2(arr3k));
        System.out.println("3000 sample: ALGO_03: " + lab01.algo3(arr3k));
        System.out.println("3000 sample: ALGO_04: " + lab01.algo4(arr3k));

        // 4000 SAMPLE
        int[] arr4k = new int[4000];
        lab01.generateSample(arr4k,1000);
        System.out.println("===========================");
        System.out.println("4000 sample: ALGO_01: " + lab01.algo1(arr4k));
        System.out.println("4000 sample: ALGO_02: " + lab01.algo2(arr4k));
        System.out.println("4000 sample: ALGO_03: " + lab01.algo3(arr4k));
        System.out.println("4000 sample: ALGO_04: " + lab01.algo4(arr4k));
    }
}
