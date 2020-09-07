package com.javarush.task.pro.task18.task1818;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.stream.Stream;

/* 
Просрочен ли товар?
*/

public class Solution {

    public static void main(String[] args) {
        var stream = Stream.of(
                new Product("Milk", LocalDate.of(2020, Month.MARCH, 12)),
                new Product("Cheese", LocalDate.of(2020, Month.MARCH, 31)),
                new Product("Buckwheat", LocalDate.of(2021, Month.MARCH, 1))
        );

        String answer = hasExpiredProduct(stream) ? "Yes" : "No";
        System.out.println("Has stream expired products? " + answer);
    }

    public static boolean hasExpiredProduct(Stream<Product> stream) {
        //напишите тут ваш код
        return stream.anyMatch(product -> product.getExpirationDate().isBefore(LocalDate.now()));
    }
}

class Product {
    private String name;
    private LocalDate expirationDate;

    public Product(String name, LocalDate expirationDate) {
        this.name = name;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}