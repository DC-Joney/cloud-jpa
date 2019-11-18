package com.dc.rong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@RunWith(JUnit4.class)
public class StreamTest {

    @Test
    public void arrays(){
        int[] array = IntStream.range(1, 10).toArray();

        Stream<String> stringStream = Stream.of("1", "2", "3", "4");

    }
}
