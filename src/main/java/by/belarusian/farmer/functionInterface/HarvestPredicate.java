package by.belarusian.farmer.functionInterface;

import by.belarusian.farmer.model.Harvest;

@FunctionalInterface
public interface HarvestPredicate {
    boolean test(Harvest harvest);
}
