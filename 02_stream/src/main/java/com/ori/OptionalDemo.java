package com.ori;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class OptionalDemo {
    public static void main(String[] args) {
        /*Author author = getAuthor();
        //空指针
//        System.out.println(author.getName());

        //防止空指针，没值的时候返回空值
        Optional<Author> authorOptional = Optional.ofNullable(author);
        authorOptional.ifPresent(i -> System.out.println(i.getName()));*/

        //安全消费值
        /*Optional<Author> authorOptional = getAuthorOptional();
        authorOptional.ifPresent(author -> System.out.println(author.getName()));*/

        /*//安全获取值
        Optional<Author> authorOptional = getAuthorOptional();
        *//*Author author = authorOptional.orElseGet(() -> new Author(2L, "德玛", 33, "一个从菜刀中明悟哲理的祖安人", null));
        System.out.println(author.getName());*//*
        try {
            Author author = authorOptional.orElseThrow((Supplier<Throwable>) () -> new RuntimeException("值为null"));
            System.out.println(author.getName());
        } catch (Throwable e) {
            e.printStackTrace();
        }*/

//        testFilter();
//        testIsPresent();
        testMap();
    }

    private static void testMap() {
        Optional<Author> authorOptional = getAuthorOptional();
        authorOptional.map(Author::getBooks)
                .ifPresent(books -> books.forEach(System.out::println));
    }

    /**
     * isPresent
     * 判读是否存在数据
     */
    private static void testIsPresent() {
        Optional<Author> authorOptional = getAuthorOptional();
        //如果存在再做操作
        if (authorOptional.isPresent()){
            System.out.println(authorOptional.get().getName());
        }
    }

    /**
     * 过滤
     * filter
     */
    private static void testFilter() {
        Optional<Author> authorOptional = getAuthorOptional();
        Optional<Author> optional = authorOptional.filter(author -> author.getAge() > 98);
        optional.ifPresent(author -> System.out.println(author.getName()));
    }

    public static Author getAuthor() {
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        return null;
    }

    /**
     * 拿Optional对象的方法
     * ofNullable
     */
    public static Optional<Author> getAuthorOptional() {
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        List<Book> books1 = new ArrayList<>();
        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败中明悟真理"));
        author.setBooks(books1);

        return Optional.ofNullable(author);
    }

}
