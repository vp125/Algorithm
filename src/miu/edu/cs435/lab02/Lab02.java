package miu.edu.cs435.lab02;


public class Lab02 {
    public void generateSample(int arr_num[], int max){
        for(int i=0;i<arr_num.length;i++){
            arr_num[i] = (int)(Math.random() * max);
        }
    }

    public int algo1(int a[]){
        int max1 = 0;
        int max2 = 0;
        int max3 = 0;

        int index1 = 0;
        int index2 = 0;

        for(int i=0;i<a.length-1;i++){
            if(a[i] > max1){
                max1 = a[i];
                index1 = i;
            }
        }

        for(int i=0;i<a.length-1;i++){
            if(a[i] > max2 && i != index1) {
                max2 = a[i];
                index2 = i;
            }
        }

        for(int i=0;i<a.length-1;i++){
            if(a[i] > max3 && i != index1 && i != index2){
                max3 = a[i];
            }
        }
        return max3;
    }

    public int algo2(int a[]){
        int max = 0;
        int preMax = 0;
        int prePreMax = 0;

        for(int i=0;i<a.length-1;i++) {
            if(a[i] > max){
                max = a[i];
            }
            else if(a[i] > preMax){
                preMax = a[i];
            }
            else if(a[i] > prePreMax){
                prePreMax = a[i];
            }
        }
        return prePreMax;
    }

    public long timeCount(AlgoFuncIF algo, int a[]){
        long start = System.nanoTime();
        algo.algoFunc(a);
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {

        Lab02 lab02 = new Lab02();

        // 1000 SAMPLE
        int[] arr1k = new int[1000];
        lab02.generateSample(arr1k,1000);
        System.out.println("1000 sample: ALGO_01: " + lab02.timeCount(lab02::algo1,arr1k));
        System.out.println("1000 sample: ALGO_02: " + lab02.timeCount(lab02::algo2,arr1k));

        // 2000 SAMPLE
        int[] arr2k = new int[2000];
        lab02.generateSample(arr2k,1000);
        System.out.println("===========================");
        System.out.println("2000 sample: ALGO_01: " + lab02.timeCount(lab02::algo1,arr2k));
        System.out.println("2000 sample: ALGO_02: " + lab02.timeCount(lab02::algo2,arr2k));

        // 3000 SAMPLE
        int[] arr3k = new int[3000];
        lab02.generateSample(arr3k,1000);
        System.out.println("===========================");
        System.out.println("3000 sample: ALGO_01: " + lab02.timeCount(lab02::algo1,arr3k));
        System.out.println("3000 sample: ALGO_02: " + lab02.timeCount(lab02::algo2,arr3k));

        // 4000 SAMPLE
        int[] arr4k = new int[4000];
        lab02.generateSample(arr4k,1000);
        System.out.println("===========================");
        System.out.println("4000 sample: ALGO_01: " + lab02.timeCount(lab02::algo1,arr4k));
        System.out.println("4000 sample: ALGO_02: " + lab02.timeCount(lab02::algo2,arr4k));
    }
}

