package com.company;

import java.util.*;

public class Task3 {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] in = buildIntArray(10);
        long startTime = System.nanoTime();
        int result = solution(in);
        double d = (System.nanoTime() - startTime);
        System.out.println(result);
        System.out.println("End "+d/1000000);
    }

    public static int[] buildIntArray(int length){
        int[] result = new int[length];
        for(int i=0; i<length;i++){
            if(i==length-1){
                result[i]=0;
            } else {
                result[i] = i + 1;
            }
        }
        return result;
    }

    public static int[] buildRandomArray(int length){
        int[] result = new int[length];
        for(int i=0; i<length;i++){
            Random random = new Random();
            result[i] = random.nextInt(length);
        }
        return result;
    }

    public static int solution(int[] A){
        Set<Integer> set = new HashSet<>();
        list.add(0);
        set.add(0);
        int newElement = A[0];
        int result ;
        while((result=checkRepeating(set,newElement)) == -1){
            newElement = A[list.get(list.size()-1)];
        }
        return result;
    }

    public static int checkRepeating(Set<Integer> set, int newElement){
        if(set.add(newElement)){
            list.add(newElement);
            return -1;
        } else {
            return list.size() - list.indexOf(newElement);
        }
    }

}
