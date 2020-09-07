package com.javarush.task.pro.task18.task1820;

import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;

/* 
Самый дорогой автомобиль
*/

public class Solution {

    public static void main(String[] args) {
        var tesla = Stream.of(
                new Car("Model S", 94_490),
                new Car("Model 3", 50_690),
                new Car("Model X", 99_690),
                new Car("Model Y", 65_000)
        );

        var bmw = Stream.of(
                new Car("X5", 110_000),
                new Car("X3", 54_000),
                new Car("X7", 143_000),
                new Car("X6", 125_000)
        );

        Optional<Car> moreExpensiveCar = getMoreExpensiveCar(tesla);
        moreExpensiveCar.ifPresent(System.out::println);

        Optional<Car> mostExpensiveCar = moreExpensiveCar.flatMap(car -> getMostExpensiveCar(bmw, car));
        mostExpensiveCar.ifPresent(System.out::println);
    }

    public static Optional<Car> getMoreExpensiveCar(Stream<Car> cars) {
        //напишите тут ваш код
        return cars.max((p1,p2) -> p1.getPrice() - p2.getPrice());
    }

    public static Optional<Car> getMostExpensiveCar(Stream<Car> cars, Car mostExpensiveCar) {
        //напишите тут ваш код
        return cars.filter(car -> car.getPrice() > mostExpensiveCar.getPrice()).findFirst();
    }
}

class Car {
    private String name;
    private Integer price;

    public Car(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Автомобиль " + name + ", цена - " + price + " USD";
    }
}
