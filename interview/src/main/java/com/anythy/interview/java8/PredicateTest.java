package com.anythy.interview.java8;


import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PredicateTest {
    static char a;

    static Predicate<Integer> moreThanFifty(){
        return p -> p > 50;
    }

    static Predicate<Integer> lessThanSixty(){
        return p -> p < 66;
    }

    /**
     * 用正则表达式 表示为Predicate
     * @return
     */
    static Predicate<String> patternPredicate(){
        return Pattern.compile("^.*str$").asPredicate();
    }

    public List<Integer> filter(List<Integer> list, Predicate<Integer> predicate){
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        PredicateTest test = new PredicateTest();
        System.out.println(PredicateTest.a == '\u0001');


        /*List<Integer> list = new ArrayList<>(100);
        for (int i = 0; i < 80; i++) {
            list.add(i);
        }

        List<Integer> re = test.filter(list, PredicateTest.moreThanFifty());
        System.out.println(Arrays.toString(re.toArray()));

        re = test.filter(re, PredicateTest.lessThanSixty());
        System.out.println(Arrays.toString(re.toArray()));*/

//        List<String> strList = Arrays.asList("str", "name", "testr");
//        List<String> re = strList.stream().filter(PredicateTest.patternPredicate()).collect(Collectors.toList());
//        System.out.println(Arrays.toString(re.toArray()));

    }

}
