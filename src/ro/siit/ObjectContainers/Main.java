package ro.siit.ObjectContainers;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Ion", 10);
        Person p2 = new Person("Andrei", 12);
        Person p3 = new Person("Alexandra", 20);
        Person p4 = new Person("Toma", 25);

        //By using name comparator (String comparison)
        TreeSet<Person> personComp = new TreeSet<Person>(new MyNameComp());
        personComp.add(p1);
        personComp.add(p2);
        personComp.add(p3);
        personComp.add(p4);
        for (Person p : personComp) {
            System.out.println(p);
        }
        System.out.println("===========================");
        //By using age comparator (int comparison)
        TreeSet<Person> ageComp = new TreeSet<Person>(new MyAgeComp());
        ageComp.add(p1);
        ageComp.add(p2);
        ageComp.add(p3);
        ageComp.add(p4);
        for (Person p : ageComp) {
            System.out.println(p);
        }
        HashMap<Person, List<Hobby>> hobbyPerson = new HashMap<Person, List<Hobby>>();

        //Defining 2 lists with addresses
        ArrayList<String> addressList = new ArrayList<>();
        addressList.add("Constanta");
        addressList.add("Galati");

        ArrayList<String> addressList2 = new ArrayList<>();
        addressList2.add("Brasov");
        addressList2.add("Timisoara");

        //Defining a list of hobbies
        List<Hobby> hobbiesList = new ArrayList<>();
        Hobby h1 = new Hobby("swimming", 60, addressList);
        Hobby h2 = new Hobby ("cycling", 3, addressList2);
        hobbiesList.add(h1);
        hobbiesList.add(h2);

        hobbyPerson.put(p1, hobbiesList);
        System.out.println(hobbyPerson);

    }

        static class MyNameComp implements Comparator<Person>{

        @Override
        public int compare(Person p1, Person p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }

    static class MyAgeComp implements Comparator<Person>{

        @Override
        public int compare(Person p1, Person p2) {
            if(p1.getAge() > p2.getAge()){
                return 1;
            } else {
                return -1;
            }
        }

    }

}
