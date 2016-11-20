package com.test;

/**
 * Created by zhoutc on 2016-10-09.
 */
public class TestCenter {
    public static void main(String[] args) {
     //printToMaxOfNDigits(2);
        sortEven();
    }
    public static void printToMaxOfNDigits(int n){
        int[] array=new int[n];
        if(n<=0)
            return;
        printArray(array,0);
    }
    private static void printArray(int[] array,int n){
        for(int i=0;i<10;i++){
            if(n!=array.length){
                array[n]=i;
                printArray(array, n+1);
            }else{
                boolean isFirstNo0=false;
                for(int j=0;j<array.length;j++){
                    if(array[j]!=0){ System.out.print(array[j]);
                        if(!isFirstNo0)
                            isFirstNo0=true;
                    }else{
                        if(isFirstNo0) System.out.print(array[j]);
                    }
                } System.out.println();
                return;
            }
        }
    }

   public static void sortEven(){
        int[] array={1,2,3,4,5,6,7};
       order(array);
        for(int item:array)
            System.out.println(item);
    }
    private static boolean isEven(int n)
    {
        return n%2==0;
    }

    public static void order(int[] array)
    {
        if(array==null||array.length==0)
            return ;
        int start=0;
        int end=array.length-1;
        while(start<end){
            while(start<end&&!isEven(array[start])){
                start++;
            }
            while(start<end&&isEven(array[end])){
                end--;
            }
            if(start<end){
                int temp=array[start];
                array[start]=array[end];
                array[end]=temp;
            }
        }
    }
}
