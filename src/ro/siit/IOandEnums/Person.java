package ro.siit.IOandEnums;

import java.util.Date;

import static java.lang.Integer.parseInt;

public class Person {
    private String name;
    private Date birthDate;

    enum Sex {
        MALE, FEMALE;

        public static Sex fromString(String sex) {
            if (sex.equalsIgnoreCase("male")) {
                return MALE;
            } else if (sex.equalsIgnoreCase("female")) {
                return FEMALE;
            } else if (parseInt(sex) == 1) {
                return FEMALE;
            } else if (parseInt(sex) == 0) {
                return MALE;
            } else throw new IllegalArgumentException();
        }
    }

    private Sex sex;

    public Person(String name, Date birthDate, Sex sex) {
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", sex=" + sex +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

}

