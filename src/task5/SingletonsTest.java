package task5;

public class SingletonsTest {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        //Создаем "еще один" объект
        Singleton1 singleton1v2 = Singleton1.getInstance();
        System.out.println(
                singleton1.hashCode() + " == " + singleton1v2.hashCode() + " " +
                (singleton1.hashCode() == singleton1v2.hashCode())
        );
        //Видим, что они равны
        //Проведем аналогичные действия для остальных реализаций Синглтона
        Singleton2 singleton2 = Singleton2.getInstance();
        Singleton2 singleton2v2 = Singleton2.getInstance();
        System.out.println(
                singleton2.hashCode() + " == " + singleton2v2.hashCode() + " " +
                (singleton2.hashCode() == singleton2v2.hashCode())
        );
        Singleton3 singleton3 = Singleton3.getInstance();
        Singleton3 singleton3v2 = Singleton3.getInstance();
        System.out.println(
                singleton3.hashCode() + " == " + singleton3v2.hashCode() + " " +
                        (singleton3.hashCode() == singleton3v2.hashCode())
        );
        Singleton4 singleton4 = Singleton4.getInstance();
        Singleton4 singleton4v2 = Singleton4.getInstance();
        System.out.println(
                singleton4.hashCode() + " == " + singleton4v2.hashCode() + " " +
                (singleton4.hashCode() == singleton4v2.hashCode())
        );
    }
}
