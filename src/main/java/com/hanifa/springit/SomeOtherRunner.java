package com.hanifa.springit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Component
@Order(1)
public class SomeOtherRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        // Array a contains 1 and 2
        // Array b contains 1 and 2 in a pattern
        // Find the pattern occurrences
        int[] a = {1,2};
        int[] b = {1,2,3,4,1,2,3,4};
        String aStr = Arrays.toString(a).replaceAll("\\[|\\]|,|\\s", "");
        String bStr = Arrays.toString(b).replaceAll("\\[|\\]|,|\\s", "");

        int count = 0, fromIndex = 0;
        while ((fromIndex = bStr.indexOf(aStr, fromIndex)) != -1 ){
            System.out.println("Found at index: " + fromIndex);
            count++;
            fromIndex++;
        }
        System.out.println("Total occurrences: " + count);
        //System.out.println(bStr);
    }
}
