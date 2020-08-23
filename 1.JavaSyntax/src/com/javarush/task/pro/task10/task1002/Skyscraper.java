package com.javarush.task.pro.task10.task1002;

/* 
Построим новый жилой комплекс JavaRush Towers
*/
public class Skyscraper {
    public static final String SKYSCRAPER_WAS_BUILD = "Небоскреб построен";
    public static final String SKYSCRAPER_WAS_BUILD_COUNT = "Небоскреб построен. Количество этажей - ";
    public static final String SKYSCRAPER_WAS_BUILD_DEVELOPER = "Небоскреб построен. Застройщик - ";

    //напишите тут ваш код


    public Skyscraper() {
        System.out.println(SKYSCRAPER_WAS_BUILD);
    }
    public Skyscraper(int count){
        System.out.println(SKYSCRAPER_WAS_BUILD_COUNT + count);
    }
    public Skyscraper(String builder){
        System.out.println(SKYSCRAPER_WAS_BUILD_DEVELOPER + builder);
    }

    public static void main(String[] args) {
        var skyscraper = new Skyscraper();
        var skyscraperTower = new Skyscraper(50);
        var skyscraperSkyline = new Skyscraper("JavaRushDevelopment");
    }
}

