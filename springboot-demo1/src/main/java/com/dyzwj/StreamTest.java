package com.dyzwj;

import com.apple.eawt.AppEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamTest {


    public void test1(){
        List<Integer> integers = Arrays.asList(1, 2, 6, 5, 4, 8, 7, 9);
        integers.stream()
                .filter(x -> x > 3)
                .sorted()
                .forEach(System.out::println);

    }


    public void test2(){
        List<Person> perosonList = getPerosonList();
        perosonList.stream()
                .filter(person -> person.getAge() > 21)
                .map(Person::getName)
                .limit(1)
                .forEach(System.out::println);
    }


    public void test3(){
        List<Person> perosonList = getPerosonList();
        perosonList.stream()
                .map(Person::getName)
                .forEach(System.out::println);
    }


    public Person test4(){
        List<Person> perosonList = getPerosonList();
        return perosonList.stream()
                .filter(person -> person.getAge() > 20)
                .findFirst().orElse(null);
    }



    public static void main(String[] args) {
        StreamTest test = new StreamTest();
//        test.test1();
//        test.test2();
//        test.test3();
        System.out.println(test.test4());
    }


    private List<Person> getPerosonList(){
        List<Person> personList = new ArrayList<>();
        Person zwj = new Person("zwj", 22);
        Person dyz = new Person("dyz", 21);
        Person ay = new Person("ay", 20);
        Person lj = new Person("lj",25);
        personList.add(zwj);
        personList.add(dyz);
        personList.add(ay);
        personList.add(lj);
        return personList;

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person{
    private String name;
    private int age;

}