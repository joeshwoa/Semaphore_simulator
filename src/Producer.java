public class Producer extends Thread{
    private boolean finished;
    private final long N;

    @Override
    public void run() {
        {
            System.out.println("Producer start");
            finished = false;
            try {
                Main.semaphore.Produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Main.buffer.Push(2);
            System.out.println("Producer puch 2");
            long i = 3;
            while (i<=N)
            {
                if(PrimeChecker.Check(i))
                {
                    try {
                        Main.semaphore.Produce();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Main.buffer.Push(i);
                    System.out.println("Producer puch "+i);
                }
                i+=2;
            }
            Main.timer.Stop();
            finished = true;
            System.out.println("Producer finish");
            try {
                Main.semaphore.Unlock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    Producer (long num)
    {
        N = num;
        start();
    }
    public boolean IsFinished ()
    {
        return finished;
    }
}
