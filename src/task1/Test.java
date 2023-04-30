package task1;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
public class Test implements Consumer {
    @Override
    public void accept(Object o) {
        String maxStr = ((String[])o)[0];
        Integer maxLen = 0;

        for (int i = 0; i < ((String[])o).length; i++) {
            Set<Character> maxStrSet = new HashSet<>();
            for (char ch : ((String[])o)[i].toCharArray()) {
                maxStrSet.add(ch);
            }
            if (maxStrSet.size() > maxLen){
                maxStr = ((String[])o)[i];
                maxLen = maxStrSet.size();
            }
        }
        System.out.println(maxStr);
    }
    //14) Имплементировать интерфейс Consumer, принимающий на вход
    //массив строк и выводящий в консоль строку с наибольшим количеством
    //уникальных символов.
    public static void main(String[] args) {
        String[] array = {"1qwerty", "qqwerty", "qddd", "bfgnj", "asddddddddd"};
        Test obj = new Test();
        obj.accept(array);
    }
}
