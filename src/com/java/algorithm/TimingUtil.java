package com.java.algorithm;

import com.java.algorithm.sort.Sort;

import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by Mihir.Desai on 4/4/2017.
 */
public class TimingUtil {

    private static Consumer<String> logger = System.out::println;



    public static <T> long timed(String description,  Consumer<T> consumer,T a) {
        long start = Instant.now().toEpochMilli();
        consumer.accept(a);
        long total = Instant.now().toEpochMilli() - start;
        /*logger.accept(description + " took " + total + " msecs");*/
        return total;
    }
}
