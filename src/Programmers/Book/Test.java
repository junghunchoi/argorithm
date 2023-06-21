package Programmers.Book;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        Person person = new Person("홍길동");

        person.addPhoneNumber("01049056994");
        person.addPhoneNumber("01056906994");

        System.out.println(person.toString());

    }

    private static class Person {
        public final String name;

        @Override
        public String toString() {
            return "Person{" + "name='" + name + '\'' + ", numbers=" + numbers + '}';
        }

        private final List<String> numbers;

        public Person(String name) {
            this.name = name;
            numbers = new ArrayList<>();
        }

        public void addPhoneNumber(String number) {
            numbers.add(number);
        }

    }
}
