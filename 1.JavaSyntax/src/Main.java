import java.io.IOException;
import java.nio.file.*;
import java.time.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Set<String> allZones = ZoneId.getAvailableZoneIds();
        LocalDateTime dt = LocalDateTime.now();

// Создаём список с зонами и сортируем его.
        List<String> zoneList = new ArrayList<String>(allZones);
        Collections.sort(zoneList);

        for (String s : zoneList) {
            ZoneId zone = ZoneId.of(s);
            ZonedDateTime zdt = dt.atZone(zone);
            ZoneOffset offset = zdt.getOffset();
            int secondsOfHour = offset.getTotalSeconds() / (60 * 60);
            String out = String.format("%35s %10s%n", zone, offset);

            // Пишем только часовые пояса, которые используют смещение
            // в неполных часах.
            if (secondsOfHour != 0) {
                System.out.print(secondsOfHour);
                System.out.printf(out);
            }

        }
    }
}