package com.javarush.task.pro.task16.task1618;

import java.time.*;

public class Solution {

    public static void main(String[] args) {
        ZoneId zone1 = ZoneId.of("Zulu");
        ZoneId zone2 = ZoneId.of("Etc/GMT+8");
        System.out.println(ZonedDateTime.now(zone1));
        System.out.println(ZonedDateTime.now(zone2));

        LocalDateTime time = changeZone(LocalDateTime.of(2020, 3, 19, 1, 40), zone1, zone2);
        System.out.println(time);
    }

    static LocalDateTime changeZone(LocalDateTime fromTime, ZoneId fromZone, ZoneId toZone) {
        //напишите тут ваш код
        int offsetFromZone = ZonedDateTime.of(fromTime, fromZone).getOffset().getTotalSeconds() / (60 * 60);   //0
        int offsetToZone = ZonedDateTime.of(fromTime, toZone).getOffset().getTotalSeconds() / (60 * 60);  //-8
        return fromTime.minusHours(offsetFromZone-offsetToZone);
    }
}
