package com.javarush.games.minigames.mini03;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

public class SymbolGame extends Game {
    public void initialize(){
        setScreenSize(8, 3);
        String[] s = {"J","A","V","A","R","U","S","H"};
        for (int i = 0; i < s.length; i++) {
            setCellValueEx(i, 1, Color.ORANGE,s[i]);
        }
    }
}
