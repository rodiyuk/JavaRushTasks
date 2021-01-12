package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Collections;
import java.util.Comparator;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }
        Collections.sort(storage.list(), new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = (int) (o2.getInitialAmount() - o1.getInitialAmount());
                return result != 0 ? result : (int) (o1.getAmountPerOneDisplaying() - o2.getAmountPerOneDisplaying());
            }
        });
        ConsoleHelper.writeMessage(String.valueOf(storage.list()));
    }
}
