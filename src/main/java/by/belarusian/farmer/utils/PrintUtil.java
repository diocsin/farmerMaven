package by.belarusian.farmer.utils;

import by.belarusian.farmer.model.Harvest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.joining;

public class PrintUtil {
    public static final String PATH = "log.txt";

    public static void print(List<Harvest> list) {
        final Optional<List<Harvest>> list1 = Optional.ofNullable(list);
        String harvestsPrint = list1.stream()
                .flatMap(Collection::stream).map(Harvest::toString).collect(joining("\n"));
        System.out.println(harvestsPrint);
        StringBuilder harvestFormating = new StringBuilder();
        harvestFormating
                .append(new Date().toString())
                .append(System.lineSeparator())
                .append(harvestsPrint);
        Path path = Paths.get(PATH);
        try {
            Files.writeString(path, harvestFormating.toString(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл " + e);
        }
    }
}

