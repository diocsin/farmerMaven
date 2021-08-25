package by.belarusian.farmer.functionInterface;

import by.belarusian.farmer.model.Harvest;

public class HarvestHeavyWeightPredicate implements HarvestPredicate {
    @Override
    public boolean test(Harvest harvest) {
        return harvest.getWeight() > 500;
    }
}
