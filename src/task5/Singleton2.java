package task5;
//Синглтон с держателем инициализации, ленивая инициализация
//Static factory
//Lazy initialization
//Thread safe
public class Singleton2 {
    private Singleton2(){}

    private static class SingletonHolder{
        private static final Singleton2 HOLDER_INSTANCE = new Singleton2();
    }

    public static Singleton2 getInstance(){
        return SingletonHolder.HOLDER_INSTANCE;
    }
}
