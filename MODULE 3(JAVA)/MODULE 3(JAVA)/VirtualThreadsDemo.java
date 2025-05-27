public class VirtualThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting virtual threads...");
        long vtStart = System.currentTimeMillis();
        Thread[] virtualThreads = new Thread[100_000];
        for (int i = 0; i < virtualThreads.length; i++) {
            int finalI = i;
            virtualThreads[i] = Thread.startVirtualThread(() -> {
                if (finalI % 20_000 == 0) // reduce output noise
                    System.out.println("Virtual thread " + finalI + " running");
            });
        }
        for (Thread t : virtualThreads) t.join();
        long vtEnd = System.currentTimeMillis();
        System.out.println("Virtual threads completed in " + (vtEnd - vtStart) + " ms\n");
        System.out.println("Starting platform threads...");
        long ptStart = System.currentTimeMillis();
       Thread[] platformThreads = new Thread[100_000];
        for (int i = 0; i < platformThreads.length; i++) {
            int finalI = i;
            platformThreads[i] = new Thread(() -> {
                if (finalI % 20_000 == 0)
                    System.out.println("Platform thread " + finalI + " running");
            });
            platformThreads[i].start();
        }
        for (Thread t : platformThreads) t.join();
        long ptEnd = System.currentTimeMillis();
        System.out.println("Platform threads completed in " + (ptEnd - ptStart) + " ms");
    }
}
