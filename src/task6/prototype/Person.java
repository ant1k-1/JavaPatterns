package task6.prototype;

public class Person implements Prototype{
    String name;
    String surname;
    Integer age;

    public Person(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public Prototype copy() {
        return new Person(name, surname, age);
    }
}
