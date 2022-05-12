package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Anything that will update symptom source data
 * 
 */
public class SymptomCountImpl implements ISymptomCount {

    /**
     * 
     * {@inheritDoc}
     * 
     */
    @Override
    public List<String> countSortSymptomList(List<String> symptoms) {

        Map<String, Long> count = symptoms.stream()
                .collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<String> sort = count.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByKey())
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.toList());

        return sort;
    }

}
