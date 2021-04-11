package miu.edu.cs435.lab09;

public class HeapSort {
    void swap(int A[], int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    int upHeap(int A[], int i){
        int j = i;
        int c = 0;
        System.out.println("Insert: " + A[i]);
        while(j>1){
            c++;
            if(A[j/2] < A[j]) {
                swap(A,j,j/2);
                j /= 2;
            }
            else{
                break;
            }
        }
        return c;
    }
    int buidMaxHeapTopDown(int A[], int n){
        int c = 0;
        for(int i=1;i<n;i++){
            c += upHeap(A,i);
            printA(A,0,i);
            System.out.println("Compare: " + c);
        }
        return c;
    }

    void printA(int A[], int start, int end) {
        System.out.print("Array: | ");
        for(int i=start+1;i<=end;i++){
            System.out.print("|" + A[i]);
        }
        System.out.println("|");
    }

    void printB(int A[], int start, int end) {
        System.out.print("Array: ");
        for(int i=start;i<=end;i++){
            System.out.print("|" + A[i]);
        }
        System.out.println("|");
    }

    void print(int A[]){
        for(int i=0;i<A.length;i++){
            System.out.print("|" + A[i]);
        }
        System.out.println("|");
    }

    int downHeap(int A[], int i){
        int j = i;
        int c = 0;
        int k = maxChildIndex(A,j,A.length);
        c++;
        System.out.println("Insert: " + A[i]);
        while(k!=0) {
            swap(A,j,k);
            j = k;
            k = maxChildIndex(A,j, A.length);
            c++;
        }
        return c;
    }

    int heapify(int A[], int i, int n){
        int j = i;
        int c = 0;
        int k = maxChildIndex(A,j,n);
        c++;
        while(k!=0) {
            swap(A,j,k);
            j = k;
            k = maxChildIndex(A,j,n);
            c++;
        }
        return c;
    }

    int maxChildIndex(int A[], int j, int n) {
        int maxIdx = 0;
        int max = A[j];
        if(2*j < n && A[2*j] > max){
            maxIdx = 2*j;
            max = A[2*j];
        }
        if(2*j+1 < n && A[2*j+1] > max){
            maxIdx = 2*j+1;
        }
        return maxIdx;
    }

    int buildMaxHeapBottomUp(int A[], int n) {
        int start = n/2;
        int c = 0;
        for(int i=start;i>0;i--){
            c += downHeap(A,i);
            printB(A,i,n-1);
            System.out.println("Compare: " + c);
        }
        return c;
    }

    int heapSortBottomUp(int A[],int n){
        int c = 0;
        for(int i=n-1;i>0;i--){
            swap(A,i,1);
            System.out.println("=====================");
            print(A);
            System.out.println("=====================");
            c += heapify(A,1,i);
        }
        return c;
    }


    public static void main(String[] args) {
        HeapSort hs = new HeapSort();

        int a2[] = {0, 2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15};
        int a3[] = {0, 4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15};
        int a4[] = {0, 5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9};
        int a5[] = {0, 5, 6, 7, 4};
        //hs.buidMaxHeapTopDown(a4,17);
        hs.buildMaxHeapBottomUp(a4,17);
        System.out.println("===== HEAP SORT =====");
        hs.heapSortBottomUp(a4,17);
        hs.print(a4);
    }
}
