package com.javarush.games.minigames.mini12;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class FillGame extends Game {
    private List<Cell> cells = new ArrayList<>();

    @Override
    public void initialize() {
        setScreenSize(10, 10);
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
        setTurnTimer(3000);
    }

    @Override
    public void onTurn(int step) {
        cells.forEach(System.out::println);
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        setCellColor(x, y, Color.ORANGE);
        Cell cell = new Cell(x,y);
        if (cells.size() == 0) cells.add(cell);
        else {
            if (!cells.contains(cell)) cells.add(cell);
            /*for (Cell cell : cells) {
                if (cell.getX() != x && cell.getY() != y) cells.add(new Cell(x, y));
            }*/
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        setCellColor(x, y, Color.WHITE);
        cells.removeIf(cell -> cell.getX() == x && cell.getY() == y);
    }
}
