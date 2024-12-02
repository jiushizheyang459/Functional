package com.ori;

import java.util.function.Function;

public class LambdaDemo01 {
    public static void main(String[] args) {
        /*Integer i = typeConver(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        });
        System.out.println(i);*/

        Integer i = typeConver((String s) -> {
            return Integer.valueOf(s);
        });
        System.out.println(i);

        String s = typeConver(c -> c + "乐为");
        System.out.println(s);

    }

    public static <R> R typeConver(Function<String, R> function){
        String str = "1235";
        R result = function.apply(str);
        return result;
    }
}
