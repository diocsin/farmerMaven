package by.belarusian.farmer;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.enums.Type;
import by.belarusian.farmer.model.Basket;
import by.belarusian.farmer.model.Bicycle;
import by.belarusian.farmer.model.Farmer;
import by.belarusian.farmer.model.Harvest;
import by.belarusian.farmer.model.fruits.Apple;
import by.belarusian.farmer.utils.HarvestFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;


public class Main {
    public static void main(String[] args) {
/*
Сгенерировать 50000 плодов и отсортировать по весу.
Выбрать из списка только Апельсины у которых вес меньше 1000 грамм
Выбрать из списка плодов овощи, фрукты, ягоды. Т.е. сделать 3 списка. отсортировать по весу.
*/
    /*    List<Harvest> hl = HarvestFactory.getHarvest(50_000);
        List<Harvest> orangeList = HarvestUtil.takeOnlyType(hl, Orange.class);
        HarvestUtil.weightLessThen(orangeList, 1000).forEach(System.out::println);

        List<Harvest> berry1 = HarvestUtil.takeOnlyType(hl, Berry.class);
        List<Harvest> fruit1 = HarvestUtil.takeOnlyType(hl, Fruit.class);
        List<Harvest> vegetable1 = HarvestUtil.takeOnlyType(hl, Vegetable.class);
        berry1 = berry1.stream()
                .sorted((h1, h2) -> h1.getWeight() > h2.getWeight() ? 1 : h1.getWeight() < h2.getWeight() ? -1 : 0)
                .collect(Collectors.toList());
        berry1.forEach(System.out::println);*/
/*
Сгенерировать 100000 Яблок и отсортировать по весу.
Выбрать из списка только Зеленые Яблоки.
*/
       /* List<Harvest> apples = HarvestFactory.generate(Apple.class, 100_000);
        List<Harvest> applesGreen = HarvestUtil.filterByColor(apples, Color.GREEN);
        applesGreen = applesGreen.stream()
                .sorted((h1, h2) -> h1.getWeight() > h2.getWeight() ? 1 : h1.getWeight() < h2.getWeight() ? -1 : 0)
                .collect(Collectors.toList());
        applesGreen.forEach(System.out::println);*/

/*
Сгенерировать 1000000 Ягод и отсортировать по весу.
Выбрать из списка только Черные Ягоды вес которых больше 10 грамм.
*/
       /* List<Harvest> berry2 = HarvestFactory.generateHarvestType(1000_000, Type.BERRIES);
        berry2 = berry2.stream()
                .sorted((h1, h2) -> h1.getWeight() > h2.getWeight() ? 1 : h1.getWeight() < h2.getWeight() ? -1 : 0)
                .collect(Collectors.toList());
        berry2 = berry2.stream().filter(b -> b.getColor() == Color.BLACK && b.getWeight() > 10).collect(Collectors.toList());
        berry2.forEach(System.out::println);*/

//Todo Создать класс Корзина которая будет името одно поле это List<Harvest> и константу Размер корзины в граммах.
//todo Классе Фабрике плодов, сделать ещещ один метод который принимает List<Harvest> и возвращает List<Корзин> заполненных
//todo В корзинах лежат плоды одного типа.

        /*List<Harvest> berry = HarvestFactory.generateHarvestType(10000, Type.BERRIES);
        List<Harvest> vegetable = HarvestFactory.generateHarvestType(5000, Type.VEGETABLES);
        List<Harvest> fruit = HarvestFactory.generateHarvestType(300, Type.FRUITS);

        List<Harvest> harvestList = new ArrayList<>();
        berry.forEach(b -> harvestList.add(b));
        vegetable.forEach(v -> harvestList.add(v));
        fruit.forEach(f -> harvestList.add(f));*/

        // HarvestFactory.getAllBaskets(harvestList).forEach(System.out::println);


      /*  List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> result = HarvestUtil.filterByAll(integerList, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        });
        System.out.println(result);

        List<String> nameList = new ArrayList<>((Arrays.asList("Иван", "Сергей", "Дмитрий", "Леонид", "Егор", "Сергей")));
        List<String> nameResult = HarvestUtil.filterByAll(nameList, new Predicate<String>() {
            @Override
            public boolean test(String name) {
                //return name.equals("Сергей");
                return name.contains("Сергей");
            }
        });
        System.out.println(nameResult);*/

        List<Harvest> harvests = HarvestFactory.of(50);
        /*List<Harvest> color = HarvestUtil.filterByAll(harvests, (Harvest h) -> Color.RED.equals(h.getColor()));
        System.out.println(color);*/


        // Comparator<Harvest> harvestComparator = ();

      /*  harvests.sort((Harvest o1, Harvest o2) -> Integer.compare(o1.getWeight(), o2.getWeight()));
        System.out.println(harvests);

        List<String> nameArray = new ArrayList<>((Arrays.asList("Иван", "Сергей", "Дмитрий", "Леонид", "Егор", "Сергей")));
        List<Integer> integers = HarvestUtil.map(nameArray, (String name) -> name.length());
        System.out.println(integers);

        List<Integer> listInteger = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> newInteger = HarvestUtil.map(listInteger, (Integer number) -> number * 10);
        System.out.println(newInteger);

        List<String> nameArray2 = new ArrayList<>((Arrays.asList("Иван", "Сергей", "Дмитрий", "Леонид", "Егор", "Сергей")));
        List<Integer> integers2 = HarvestUtil.map(nameArray, String::length);
        System.out.println(integers);

        nameArray.sort((String s1, String s2) -> s1.compareTo(s2));

        nameArray2.sort(String::compareTo);

        System.out.println(nameArray2);


        harvests.stream().filter((Harvest h) -> Color.RED.equals(h.getColor())).forEach((Harvest h) -> System.out.println(h));
        Long count = harvests.stream().filter((Harvest h) -> Color.RED.equals(h.getColor())).count();
        System.out.println(count);

        List <Harvest> list = harvests.stream()
                .filter((Harvest h) -> Color.RED.equals(h.getColor()))
                .sorted(Comparator.comparing(harvest -> harvest.getWeight()))
                .collect(Collectors.toList());

        System.out.println(list);

       List <Integer> weightSum = list.stream()
                .filter((Harvest h) -> Color.RED.equals(h.getColor()))
                .sorted(Comparator.comparing(harvest -> harvest.getWeight()))
                .map((Harvest h)-> h.getWeight())
                .collect(Collectors.toList());
        System.out.println(weightSum);*/


        Map<Type, List<Harvest>> listMap = harvests.stream().collect(groupingBy((Harvest h) -> h.getType()));
        //  System.out.println(listMap);


        List<Integer> collect = harvests.stream().map(harvest -> harvest.getWeight()).distinct().collect(Collectors.toList());
        //  System.out.println(collect);

        /*1.Переписать метод HarvestFactory.getAllBaskets c использованием java 8. (получится 2 строки)
                ------Положить все плоды в корзины.------
            2. Найти все в корзинах все плоды которые больше 50 грамм и Черного или Белого Цвета.
            3. Вернуть строку со всеми именами плодов отсортированные в алфавитном порядке.
            4. Узнать есть ли хоть однин огурец в корзинах.
            5. Вывести сумму веса всех корзин.
            6. Каков вес самого тяжелого плода в корзинах.
            7. Найти самый легкий плод в корзинах.
            8. Вывести все имена плодов большими буквами без повторений через точку с запятой.
        */
        //doTasks();
        task2();
    }

    public static void doTasks() {
        List<Harvest> harvest = HarvestFactory.of(100);
        List<Basket> allBaskets = Basket.of(harvest);
        allBaskets.stream().flatMap(b -> b.getHarvests().stream())
                .filter(h -> h.getWeight() > 50)
                .filter(h -> h.getColor() == Color.BLACK || h.getColor() == Color.WHITE).forEach(System.out::println);
        System.out.println();
        allBaskets.stream().flatMap(b -> b.getHarvests().stream()).map(Harvest::getRusName).sorted().forEach(System.out::println);
        System.out.println();
        boolean isCucumber = allBaskets.stream().flatMap(b -> b.getHarvests().stream()).anyMatch(h -> h.getRusName().equals("Огурец"));
        System.out.println("Огурец " + isCucumber);
        int sum = allBaskets.stream().mapToInt(Basket::getTotalWeight).sum();
        System.out.printf("Вес всех коризн %d\n", sum);
        OptionalInt max = allBaskets.stream().flatMap(b -> b.getHarvests().stream()).mapToInt(Harvest::getWeight).max();
        System.out.printf("Максимальный вес %d\n", max.getAsInt());
        Optional<Harvest> minHarvest = allBaskets.stream().flatMap(b -> b.getHarvests().stream()).reduce((h1, h2) -> h1.getWeight() < h2.getWeight() ? h1 : h2);
        System.out.println("Самый легкий плод " + minHarvest.get());
        allBaskets.stream().flatMap(b -> b.getHarvests().stream()).map(Harvest::getRusName)
                .map(String::toUpperCase).distinct().forEach(s -> System.out.printf("%s; ", s));

    }

    private static void task2() {
        Stream<String> streamTest = Stream.of("Java", "Spring", "PrimeFaces", "javaScript");

        streamTest.map(String::toUpperCase).forEach(System.out::println);

        Stream<Object> empty = Stream.empty();

        String param = null;

        Stream<String> stream = param == null ? Stream.empty() : Stream.of(param);

        Stream<String> param1 = Stream.ofNullable(param);
        param1.forEach(System.out::println);

       // readFile();
    }

    private static void readFile() {
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Path.of("test.txt"), Charset.defaultCharset())) {

            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
        } catch (IOException e) {

            e.printStackTrace();
        }
        System.out.println(uniqueWords);
        //generateStream();
        // fibonschi();
        //colectorsTest();
        //group();
        // fabrics();
    }

    private static void generateStream() {
        Stream.iterate(0, n -> n < 100, n -> n + 2).forEach(System.out::println);

        final List<Apple> collect = Stream.generate(() -> new Apple(ThreadLocalRandom.current().nextInt(1, 1000), Color.RED))
                .limit(10).collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void fibonschi() {
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(20)
                .map(t -> t[0])
                .forEach(System.out::println);
    }

    private static void colectorsTest() {
        List<Harvest> harvest = HarvestFactory.of(100);
        List<Basket> allBaskets = Basket.of(harvest);
        final Comparator<Harvest> harvestComparator = Comparator.comparingInt(Harvest::getWeight);
        final Optional<Harvest> maxHarvest = allBaskets.stream()
                .flatMap(b -> b.getHarvests().stream())
                .collect(maxBy(harvestComparator));
        System.out.println(maxHarvest.get());
        final Integer totalWeight = allBaskets.stream()
                .flatMap(b -> b.getHarvests().stream())
                .peek(x -> System.out.println("from flatMap " + x))
                .collect(summingInt(Harvest::getWeight));

        final IntSummaryStatistics statistics = allBaskets.stream()
                .flatMap(b -> b.getHarvests().stream()).collect(summarizingInt(Harvest::getWeight));
        System.out.println(statistics);


        final String allHarvestUpperCase = allBaskets.stream().flatMap(b -> b.getHarvests().stream()).map(Harvest::getRusName)
                .map(String::toUpperCase).distinct().collect(joining(", "));
        System.out.println(allHarvestUpperCase);


    }

    public enum SizeLevel {SMALL, AVERAGE, LARGE, HUGE}

    private static void group() {
        List<Harvest> harvests = HarvestFactory.of(40);
        Map<Type, List<Harvest>> listMap = harvests.stream()
                .collect(groupingBy(Harvest::getType, filtering(harvest -> harvest.getWeight() > 500, toList())));
        System.out.println(listMap);

        final Map<Type, Map<SizeLevel, List<Harvest>>> sizeMap = harvests.stream().collect(
                groupingBy(Harvest::getType,
                        groupingBy(harvest -> {
                            if (harvest.getWeight() <= 100) return SizeLevel.SMALL;
                            else if (harvest.getWeight() <= 300) return SizeLevel.AVERAGE;
                            else if (harvest.getWeight() <= 500) return SizeLevel.LARGE;
                            else return SizeLevel.HUGE;

                        })));
        System.out.println(sizeMap);
    }

    private static void fabrics() {
        final List<String> java = List.of("Java", "javaScript");

        final Map<String, Integer> java1 = Map.of("Java", 1, "JavaScript", 2);

        final Map<String, String> stringStringMap = Map.ofEntries(Map.entry("Java", "Хорошо"),
                Map.entry("JavaScript", "Еще лучше"));

        List<Harvest> harvests = HarvestFactory.of(40);
        System.out.println(harvests.size());
        harvests.removeIf(el -> el.getWeight() > 30);
        System.out.println(harvests.size());

        harvests.forEach(System.out::println);
    }

    public static void optionalTest() {
        final Farmer farmer = new Farmer();
        final Farmer farmer2 = new Farmer();
        final Bicycle bicycle = new Bicycle();
        final Bicycle bicycle2 = new Bicycle();
        final List<Harvest> harvests = HarvestFactory.of(200);
        final List<Harvest> harvests2 = HarvestFactory.of(200);
        final List<Basket> baskets = Basket.of(harvests);
        final List<Basket> baskets2 = Basket.of(harvests2);
        bicycle.setBasket(Optional.ofNullable(baskets.get(0)));
        bicycle2.setBasket(Optional.ofNullable(baskets2.get(0)));
        farmer.setBicycle(Optional.ofNullable(bicycle));
        farmer2.setBicycle(Optional.ofNullable(bicycle2));
        final Optional<Farmer> farmerOptional = Optional.of(farmer);
        System.out.printf("Вес %s", getWeightBasketsOnBicycle(farmerOptional));
        System.out.println();
        System.out.println(getBasketsWeight(List.of(farmer, farmer2)));
        System.out.println(getWeight(farmerOptional, 100));
    }

    public static int getWeightBasketsOnBicycle(final Optional<Farmer> farmer) {
        return farmer.flatMap(Farmer::getBicycle)
                .flatMap(Bicycle::getBasket)
                .map(Basket::getTotalWeight).orElse(-1);
    }

    public static Set<Integer> getBasketsWeight(final List<Farmer> farmers) {
        final Set<Optional<Integer>> collect = farmers.stream()
                .map(Farmer::getBicycle)
                .map(b -> b.flatMap(Bicycle::getBasket))
                .map(bas -> bas.map(Basket::getTotalWeight))
                .collect(toSet());

        return collect.stream().filter(Optional::isPresent).map(Optional::get).collect(Collectors.toSet());

    }

    public static Optional<Basket> nullSafeFindSmallerBasket(Optional<Farmer> farmer, Optional<Bicycle> bicycle) {
        return farmer.flatMap(f -> bicycle.flatMap(b -> findSmaller(f, b)));
    }

    private static Optional<Basket> findSmaller(Farmer farmer, Bicycle bicycle) {
        return bicycle.getBasket();
    }

    private static Integer getWeight(Optional<Farmer> farmer, int weight) {
        teste();
        return farmer.flatMap(Farmer::getBicycle)
                .flatMap(Bicycle::getBasket)
                .map(Basket::getTotalWeight).filter(w -> w > weight)
                .orElseThrow(NullPointerException::new);

    }

    private static void teste(){
        LocalTime l = LocalTime.of(21,17,5);
        LocalDate.parse("2017-09-21");
        System.out.println(l);
        System.out.println(l);
        final Period between = Period.between(LocalDate.of(2021, 8, 18), LocalDate.of(2021, 8, 20));
        System.out.println(between.getDays());
        LocalDateTime.now();
    }
}
