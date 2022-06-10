package com.stan.webfluxdemo1;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author：zengxp
 * @date：2022/4/10 上午12:02
 */
public class FluxTest {
    public static void main(String[] args) {

//        makeFlux();

//        emptyTest();
//        subscribeTest();
        cartesianTest();
    }

    public static void makeFlux() {
        Flux<String> seq1 = Flux.just("foo", "bar", "foobar");
        List<String> iterable = Arrays.asList("foo", "bar", "foobar");
        Flux<String> seq2 = Flux.fromIterable(iterable);
        Flux<Integer> numbersFromFiveToSeven = Flux.range(5, 3);

        numbersFromFiveToSeven.subscribe(System.out::println);
    }

    public static void emptyTest() {
        System.out.println("Before");
        Flux.empty()
                .subscribe(System.out::println, System.out::println, () -> System.out.println("complete"));
        System.out.println("After");
    }

    public static void subscribeTest() {
        System.out.println("Before");
        Flux<String> flux = Flux.just("test");
        System.out.println("After");

        flux.subscribe(System.out::println, System.out::println, () -> System.out.println("complete"));
    }

    public static void cartesianTest() {
        Flux<Integer> oneToEight = Flux.range(1, 8);
        Flux<String> ranks = oneToEight.map(Objects::toString);
        Flux<String> files = oneToEight.map(x -> 'a' + x - 1)
                .map(ascii -> (char) ascii.intValue())
                .map(ch -> Character.toString(ch));

        Flux<String> squares = files
                .flatMap(file -> ranks.map(rank -> file + rank));

        squares.subscribe(System.out::println);
    }


}
