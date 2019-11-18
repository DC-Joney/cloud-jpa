package com.dc.rong.tes;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@Slf4j
public class StreamExample {

    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        integerStream.forEach(s-> {
            log.info(String.valueOf(s));
        });
        integerStream.forEach(s-> {
            log.info(String.valueOf(s));
        });

    }

}
