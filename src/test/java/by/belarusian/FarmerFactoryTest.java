package by.belarusian;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.enums.Type;
import by.belarusian.farmer.exceptions.BasketTotalWeightException;
import by.belarusian.farmer.model.Basket;
import by.belarusian.farmer.model.Harvest;
import by.belarusian.farmer.model.berries.Blueberry;
import by.belarusian.farmer.model.berries.Cherry;
import by.belarusian.farmer.model.fruits.Apple;
import by.belarusian.farmer.model.fruits.Banana;
import by.belarusian.farmer.model.fruits.Orange;
import by.belarusian.farmer.model.vegetables.Cucumber;
import by.belarusian.farmer.model.vegetables.Tomato;
import by.belarusian.farmer.utils.HarvestFactory;
import by.belarusian.farmer.utils.HarvestUtil;
import by.belarusian.farmer.utils.PrintUtil;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FarmerFactoryTest {

    private static final List<Harvest> harvests = new ArrayList<>();

    @BeforeAll
    static void setup() {
        harvests.add(new Apple(450, Color.RED));
        harvests.add(new Orange(550, Color.ORANGE));
        harvests.add(new Cherry(500, Color.YELLOW));
        harvests.add(new Blueberry(200, Color.BLACK));
        harvests.add(new Cucumber(300, Color.GREEN));
        harvests.add(new Tomato(900, Color.RED));
    }

    @Test
    void testBasket() {
        List<Basket> baskets = Basket.of(harvests);
        assertEquals(4, baskets.size());
        List<Harvest> harvests = HarvestFactory.of(500);
        List<Basket> baskets500 = Basket.of(harvests);
        baskets500.forEach(basket -> {
            assertAll(() -> assertTrue(basket.getTotalWeight() <= 1000),
                    () -> assertTrue(basket.getTotalWeight() > 0),
                    () -> assertTrue(basket.getHarvests().size() != 0));
        });

        final boolean oneType = baskets.stream().allMatch(b -> b.getHarvests()
                .stream()
                .map(Harvest::getType)
                .distinct().count() == 1);
        assertTrue(oneType, "No one type in basket");
        final boolean basketFruits = baskets.stream()
                .anyMatch(basket -> basket.getHarvests().size() == 2 && basket.getTotalWeight() == 1000);
        assertTrue(basketFruits);
    }

    @DisplayName("Test size of factory")
    @Test
    void testAmountHarvests() {
        final List<Harvest> harvests = HarvestFactory.of(10);
        assertEquals(10, harvests.size(), "Size must be 10");
        final List<Harvest> harvests1 = HarvestFactory.of(0);
        assertTrue(harvests1.isEmpty());
        final List<Harvest> harvests2 = HarvestFactory.of(-10);
        assertTrue(harvests1.isEmpty());
    }

    @DisplayName("Test type and size of factory")
    @Test
    void testAmountAndTypeHarvest() {
        final List<Harvest> harvests = HarvestFactory.of(Type.BERRIES, 4);
        assertEquals(4, harvests.size());
        final List<Harvest> harvests1 = HarvestFactory.of(Type.BERRIES, 0);
        assertEquals(0, harvests1.size());
        final List<Harvest> harvests2 = HarvestFactory.of(Type.BERRIES, -5);
        assertEquals(0, harvests2.size());
        harvests.forEach(h -> {
            assertEquals(h.getType(), Type.BERRIES);
        });
        final List<Harvest> vegetables = HarvestFactory.of(Type.VEGETABLES, 4);
        vegetables.forEach(h -> {
            assertEquals(h.getType(), Type.VEGETABLES);
        });

        final List<Harvest> testNullHarvests = testNullFactory(null);
        assertEquals(0, testNullHarvests.size());
    }

    private List<Harvest> testNullFactory(Type type) {
        return HarvestFactory.of(type, 5);
    }

    @Test
    void testStringFactory() {
        assertThrows(IllegalArgumentException.class, () -> {
            HarvestFactory.of("ааа", 10);
        });
    }

    @Test
    void testLogFile() throws IOException {
        PrintUtil.print(harvests);
        Path path = Paths.get(PrintUtil.PATH);
        List<String> harvest = Files.readAllLines(path);
        assertEquals(7, harvest.size());
        Banana banana = new Banana(120, Color.YELLOW);
        harvests.add(banana);
        PrintUtil.print(harvests);
        List<String> harvestWithBanana = Files.readAllLines(path);
        assertEquals(8, harvestWithBanana.size());
        assertEquals(banana.toString(), harvestWithBanana.get(harvestWithBanana.size() - 1));

    }

    @Test
    void testFilter() {
        List<Harvest> list = HarvestUtil.filterHarvest(harvests, h -> h.getColor().equals(Color.RED));
        assertTrue(list.contains(FarmerFactoryTest.harvests.get(0)));
        assertEquals(2, list.size());
    }

    @Test
    void testAddHarvestToBasket() {
        final Basket basket = new Basket(List.of(new Apple(450, Color.RED),
                new Orange(550, Color.ORANGE)));
        assertThrows(BasketTotalWeightException.class, () -> basket.addHarvests(List.of(new Banana(100, Color.YELLOW))));
        final Basket basket2 = new Basket(List.of(new Apple(150, Color.RED),
                new Orange(250, Color.ORANGE)));
        assertTrue(basket2.addHarvests(List.of(new Orange(200, Color.BLACK))), "");
        assertEquals(600, basket2.getTotalWeight());
    }

    @Test
    void testNullableLogFile() throws IOException {
        PrintUtil.print(null);
        Path path = Paths.get(PrintUtil.PATH);
        List<String> harvest = Files.readAllLines(path);
        assertEquals(1, harvest.size());
    }


}
