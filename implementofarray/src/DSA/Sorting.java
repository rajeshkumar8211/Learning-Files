package DSA;

import java.util.Arrays;

public class Sorting {
    public static void selection_sort(int [] arr){
        int min;
        for (int i=0;i<arr.length;i++){
            min=arr[i];
            int Min_index=i;
            for (int j=i+1;j< arr.length;j++) {
                if (min > arr[j]) {
                    min=arr[j];
                    Min_index=j;
                }
            }
            int temp=arr[i];
            arr[i]=min;
            arr[Min_index]=temp;
        }
    }
    public static void selection_sort_desc(int [] arr){
        int min;
        for (int i=0;i<arr.length;i++){
            min=arr[i];
            int Min_index=i;
            for (int j=i+1;j< arr.length;j++) {
                if (min < arr[j]) {
                    min=arr[j];
                    Min_index=j;
                }
            }
            int temp=arr[i];
            arr[i]=min;
            arr[Min_index]=temp;
        }
    }
    public static void insertion_sort(int[] arr){
        for (int i=1;i<arr.length;i++){
            for (int j=i;j>0;j--){
                if(arr[j]<arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                else {
                    break;
                }
            }
        }
    }
    public static void bubble_sort(int[] arr){
        for (int i=1;i<arr.length;i++){
            for (int j=0;j< arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
                else {
                    break;
                }
            }
        }
    }
    public static int[] merge_sort(int[] arr){
        if (arr.length==1){
            return arr;
        }

        int mid= arr.length/2;

        int[] left=merge_sort(Arrays.copyOfRange(arr,0,mid));
        int[] right=merge_sort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);
    }
    public static int[] merge(int[] left,int[] right){
        int[] joined =new int[left.length+right.length];
        int i=0,j=0,k=0;
        while (i< left.length && j< right.length){
            if(left[i]<right[j]){
                joined[k++]=left[i++];
            }
            else {
                joined[k++]=right[j++];
            }
        }
        while (i< left.length){
            joined[k++]=left[i++];
        }
        while (j< right.length){
            joined[k++]=right[j++];
        }
        return joined;
    }
    public static void quick_sort(int[] arr,int low,int high){
        if(low>=high){
            return;
        }
        int s=low;
        int e=high;
        int mid=(s+e)/2;
        int pivot=arr[mid];
        while (s<=e){
            while (arr[s]<pivot){
                s++;
            }
            while (arr[e]>pivot){
                e--;
            }
            if (s<=e){
                int temp =arr[s];
                arr[s]=arr[e];
                arr[e]=temp;
                s++;
                e--;
            }
        }
        quick_sort(arr,low,e);
        quick_sort(arr,s,high);
    }
}
