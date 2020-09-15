package com.javarush.games.minigames.mini08;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Key;

public class KeyboardGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(3, 3);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                setCellColor(x, y, Color.WHITE);
            }
        }

    }

    @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case LEFT : {
                for (int y = 0; y < 3; y++) {
                    setCellColor(0, y, Color.GREEN);
                }
            }
            break;
            case RIGHT : {
                for (int y = 0; y < 3; y++) {
                    setCellColor(2, y, Color.GREEN);
                }
            }
            break;
            case UP : {
                for (int x = 0; x < 3; x++) {
                    setCellColor(x, 0, Color.GREEN);
                }
            }
            break;
            case DOWN : {
                for (int x = 0; x < 3; x++) {
                    setCellColor(x, 2, Color.GREEN);
                }
            }
        }
    }
    @Override
    public void onKeyReleased(Key key) {
        switch (key) {
            case LEFT : {
                for (int y = 0; y < 3; y++) {
                    setCellColor(0, y, Color.WHITE);
                }
            }
            break;
            case RIGHT : {
                for (int y = 0; y < 3; y++) {
                    setCellColor(2, y, Color.WHITE);
                }
            }
            break;
            case UP : {
                for (int x = 0; x < 3; x++) {
                    setCellColor(x, 0, Color.WHITE);
                }
            }
            break;
            case DOWN : {
                for (int x = 0; x < 3; x++) {
                    setCellColor(x, 2, Color.WHITE);
                }
            }
        }
    }
}
