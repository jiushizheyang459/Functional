package com.ori;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        List<Author> authors = getAuthors();
//        test1(authors);
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
//        test8();
//        test9();
//        test10();
//        test11();
//        test12();
//        test13();
//        test14();
//        test15();
//        test16();
//        test17();
//        test18();
//        test19();
//        test20();
//        test21();
//        test22();
//        test23();
//        test24();
//        test25();
        test26();
    }

    private static void test26() {
        //求所有作家中年龄的最小值
        List<Author> authors = getAuthors();
        Optional<Integer> minOptional = authors.stream()
                .map(Author::getAge)
                .reduce((a, b) -> a > b ? b : a);
        minOptional.ifPresent(System.out::println);
    }

    private static void test25() {
        //求所有作家中年龄的最小值
        List<Author> authors = getAuthors();
        Integer min = authors.stream()
                .map(Author::getAge)
                .reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);
        System.out.println(min);
    }

    private static void test24() {
        //求所有作家中年龄的最大值
        List<Author> authors = getAuthors();
        Integer max = authors.stream()
                .map(Author::getAge)
                .reduce(Integer.MIN_VALUE, (a, b) -> a < b ? b : a);
        System.out.println(max);
    }

    private static void test23() {
        //求所有作家年龄的和
        List<Author> authors = getAuthors();
        Integer sum = authors.stream()
                .distinct()
                .map(Author::getAge)
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }

    private static void test22() {
        //找到一个年龄最小的作家并输出他的名字
        List<Author> authors = getAuthors();
        Optional<Author> optional = authors.stream()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .findFirst();
        optional.ifPresent(author -> System.out.println(author.getName()));
    }

    private static void test21() {
        //找到任意一个年龄大于18的作家并输出他的名字
        List<Author> authors = getAuthors();
        Optional<Author> optional = authors.stream()
                .filter(author -> author.getAge() > 18)
                .findAny();
        optional.ifPresent(author -> System.out.println(author.getName()));
    }

    private static void test20() {
        //判断是否作家都没超过100岁
        List<Author> authors = getAuthors();
        System.out.println(authors.stream()
                .noneMatch(author -> author.getAge() >= 100));
    }

    private static void test19() {
        //判断是否作家都是成年人
        List<Author> authors = getAuthors();
        System.out.println(authors.stream()
                .allMatch(author -> author.getAge() > 18));
    }

    private static void test18() {
        //判断是否有年龄在29岁以上的作家
        List<Author> authors = getAuthors();
        boolean b = authors.stream()
                .anyMatch(author -> author.getAge() > 29);
        System.out.println(b);
    }

    private static void test17() {
        List<Author> authors = getAuthors();
        Map<String, List<Book>> map = authors.stream()
                .distinct()
                .collect(Collectors.toMap(Author::getName, Author::getBooks));
        System.out.println(map);
    }

    private static void test16() {
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }

    private static void test15() {
        List<Author> authors = getAuthors();
        List<String> nameList = authors.stream()
                .map(Author::getName)
                .collect(Collectors.toList());
        System.out.println(nameList);

    }

    private static void test14() {
        List<Author> authors = getAuthors();
        Optional<Integer> max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getScore)
                .max((o1, o2) -> o2 - o1);
        System.out.println(max.get());

    }

    private static void test13() {
        List<Author> authors = getAuthors();
        long count = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(count);
    }

    private static void test12() {
        List<Author> authors = getAuthors();
        authors.stream()
                .map(Author::getName)
                .distinct()
                .forEach(System.out::println);
    }

    private static void test11() {
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(System.out::println);
    }

    private static void test10() {
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book.getName()));
    }

    private static void test9() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted()
                .skip(1)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test8() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted()
                .limit(2)
                .forEach(author -> System.out.println(author.getName()));

    }

    private static void test7() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .forEach(author -> System.out.println(author.getAge()));
    }

    private static void test6() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test5() {
        List<Author> authors = getAuthors();
        /*//打印所有作家的姓名
        authors.stream()
                .map(author -> author.getName())
                .forEach(s ->System.out.println(s));*/
        authors.stream()
                .map(author -> author.getAge())
                .map(age -> age + 10)
                .forEach(age -> System.out.println(age));
    }

    private static void test4() {
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(author -> author.getName().length() > 1)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test3() {
        Map<String, Integer> map = new HashMap<>();
        map.put("蜡笔小新", 19);
        map.put("黑子", 17);
        map.put("日向翔阳", 16);

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Stream<Map.Entry<String, Integer>> stream = entrySet.stream();
        stream.filter(e -> e.getValue() > 16)
                .forEach(e -> System.out.println(e.getKey() + "===" + e.getValue()));
    }

    private static void test2() {
        Integer[] arr = {1, 2, 3, 4, 5};
//        Stream<Integer> stream = Arrays.stream(arr);
        Stream<Integer> stream = Stream.of(arr);
        stream.distinct()
                .filter(integer -> integer > 2)
                .forEach(integer -> System.out.println(integer));
    }

    private static void test1(List<Author> authors) {
        authors.stream()    //把集合转换成流
                .distinct() //过滤掉重复的
                .filter(author -> author.getAge() < 18) //过滤年龄小于18的
                .forEach(author -> System.out.println(author.getName()));
    }

    private static List<Author> getAuthors() {
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚索", 15, "狂风也追逐不上他的思考速度", null);
        Author author3 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        Author author4 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);

        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败中明悟真理"));

        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(4L, "吹或不吹", "爱情,个人传记", 56, "一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books3.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢?"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢?"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
        return authorList;
    }
}
