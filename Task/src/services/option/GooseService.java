package services.option;

import board.Cell;
import board.Direction;
import data.GameData;
import fiture.Figure;
import player.Player;

import java.util.*;

public class GooseService implements MoveService {

    @Override
    public Map<Direction, Cell> getOptions(GameData data, Player p, Figure f, Cell c) {
        if (f == null)
            return new HashMap<>();
        List<Direction> directions = data.getDirectionsFigure().get(f.getTypeFigure());

        List<Cell> enemyCells = getEnemyCells(data, p);
        Map<Direction, Cell> options = new TreeMap<>();
        for (Direction d:directions) {
            Cell c1 = c.getCell(d);
            if(c1 != null && !enemyCells.contains(c1) && !data.getPlayerCells().get(p).contains(c1))
                options.put(d, c1);
        }
        return options;
    }

}
