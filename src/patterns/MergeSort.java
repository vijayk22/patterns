package patterns;

import java.util.Arrays;

public class MergeSort {
    //sort array arr[low..high] using aux array.
    static void mergeSort(int[] arr, int[] aux, int low, int high) {
        if(high==low)
            return;
        int mid = low + (high-low)/2;

        //recursively split runs into two halves until run size == 1,
        mergeSort(arr, aux, low, mid);
        mergeSort(arr, aux, mid+1, high);

        //merge the two half runs
        merge(arr, aux, low, mid, high);
    }

    //merge two sorted arrays arr[low..mid] and arr[mid+1..high]
    static void merge(int[] arr, int[] aux, int low, int mid, int high) {
       int k=low, i=low, j=mid+1;

       while(i<=mid && j<=high) {
        if(arr[i] <= arr[j])
            aux[k++]=arr[i++];
        else
            aux[k++]=arr[j++];
       }
       //copy the remaining ele
       while(i <= mid)
        aux[k++]=arr[i++];
       //no need to copy 2nd half as thos are already
       //in correct pos in aux array.

       //copy back to the original array to reflect sorted order.
       for(i=low; i<=high; i++)
            arr[i]=aux[i];
    }

    public static void main(String args[]) {
        int[] arr = { 12, 3, 18, 24, 0, 5, -2 };
        int[] aux= Arrays.copyOf(arr, arr.length);

        mergeSort(arr, aux, 0, arr.length-1);

        for(int i : arr)
            System.out.print(i +" ");
    }

}
