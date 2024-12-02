package com.ori;

import java.util.function.Function;
import java.util.function.IntConsumer;

public class LambdaDemo02 {
    public static void main(String[] args) {
        foreachArr(value -> System.out.print(value));
    }

    public static void foreachArr(IntConsumer consumer){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            consumer.accept(i);
        }
    }
}
