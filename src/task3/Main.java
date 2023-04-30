package task3;

//14. List с использованием Semaphore, Set с использованием ключевого
//    слова synchronized.
public class Main {
    public static void main(String[] args) {
        SemList<Integer> semList = new SemList<>();
        SyncSet<Integer> syncSet = new SyncSet<>();
        Thread thread1 = new Thread(()->{
            for (int i = 1; i < 6; i++) {
                semList.add(i);
            }
        });

        Thread thread2 = new Thread(()->{
            for (int i = 6; i < 11; i++) {
                semList.add(i);
            }
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Semaphore List-----------------------------------");
        System.out.println(semList);

        Thread thread3 = new Thread(()->{
            for (int i = 1; i < 6; i++) {
                syncSet.add(i);
            }
        });

        Thread thread4 = new Thread(()->{
            for (int i = 6; i < 11; i++) {
                syncSet.add(i);
            }
        });

        thread3.start();
        thread4.start();
        try {
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sync Set-----------------------------------");
        System.out.println(syncSet);


    }
}

