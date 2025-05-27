class MyThread extends Thread {
    private String message;

    public MyThread(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(message + " - Count: " + (i + 1));
            try {
                Thread.sleep(500); // Sleep for 0.5 seconds for better visibility
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        
        MyThread thread1 = new MyThread("Thread 1 message");
        MyThread thread2 = new MyThread("Thread 2 message");
        thread1.start();
        thread2.start();
    }
}
