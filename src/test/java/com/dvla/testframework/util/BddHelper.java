package com.dvla.testframework.util;

import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.cucumber.datatable.DataTable.create;

public class BddHelper {
    public static <T> DataTable createTable(List<T> values, List<String> headers, Function<T, Object>... extractors) {
        List<List<String>> rawTable = new ArrayList<>();
        rawTable.add(headers);
        values.stream()
                .map(vehicleDetails -> Stream.of(extractors)
                        .map(f -> f.apply(vehicleDetails))
                        .map(String::valueOf)
                        .collect(Collectors.toList()))
                .forEach(rawTable::add);
        return create(rawTable);
    }
}
