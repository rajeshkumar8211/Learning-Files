package DSA;

import java.util.Arrays;

public class Sorting_demo {
    public static void main(String[] args){
        int [] arr={10,5,3,15,22};
       /* Sorting.selection_sort(arr);
        System.out.println(Arrays.toString(arr));
        Sorting.selection_sort_desc(arr);
        System.out.println(Arrays.toString(arr));
        Sorting.insertion_sort(arr);
        System.out.println(Arrays.toString(arr));
        Sorting.bubble_sort(arr);
        System.out.println(Arrays.toString(arr));*/
        //arr=Sorting.merge_sort(arr);
        //System.out.println(Arrays.toString(arr));
        Sorting.quick_sort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
