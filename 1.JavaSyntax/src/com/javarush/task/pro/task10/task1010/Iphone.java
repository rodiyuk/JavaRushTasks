package com.javarush.task.pro.task10.task1010;

/* 
Два айфона
*/
public class Iphone {
    private String model;
    private String color;
    private int price;

    public Iphone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Iphone)) return false;

        Iphone iphone = (Iphone)obj;
        return this.model.equals(iphone.model) && this.color.equals(iphone.color) && this.price == iphone.price;
    }
    //напишите тут ваш код

    public static void main(String[] args) {
        var iphone1 = new Iphone("X", "Black", 999);
        var iphone2 = new Iphone("X", "Black", 999);

        System.out.println(iphone1.equals(iphone2));
    }

}
