package by.belarusian.farmer.functionInterface;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.model.Harvest;

public class HarvestGreenColorPredicate implements HarvestPredicate {
    @Override
    public boolean test(Harvest harvest) {
        return Color.GREEN.equals(harvest.getColor());
    }
}
