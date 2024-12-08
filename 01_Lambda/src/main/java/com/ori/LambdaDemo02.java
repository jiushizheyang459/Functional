package com.ori;

import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

public class LambdaDemo02 {
    public static void main(String[] args) {
//        foreachArr(value -> System.out.print(value));
//        printNum(value -> value % 2 == 0);
        printNum2(value -> value % 2 == 0, value -> value > 4);
    }

    public static void foreachArr(IntConsumer consumer){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            consumer.accept(i);
        }
    }

    private static void printNum (IntPredicate predicate){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            if (predicate.test(i)) {
                System.out.println(i);
            }
        }
    }

    private static void printNum2 (IntPredicate predicate1,IntPredicate predicate2){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            if (predicate1.and(predicate2).test(i)) {
                System.out.println(i);
            }
        }
    }
}
