package task6.prototype;

public class Application {
    public static void main(String[] args) {
        Person personOriginal = new Person("Ivan", "Ivanov", 25);
        System.out.println(personOriginal);

        Person personCopy = (Person) personOriginal.copy();
        System.out.println(personCopy);

        System.out.println("Let's check id of these objs: " + (personCopy==personOriginal));
    }
}
