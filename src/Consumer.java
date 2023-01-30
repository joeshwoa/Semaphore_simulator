public class Consumer extends Thread{
    @Override
    public void run() {
        System.out.println("Consumer start");
        while (true)
        {
            try {
                Main.semaphore.Consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (Main.buffer.IsFull())
            {
                while (!Main.buffer.IsEmpty())
                {
                    Main.writer.Write(String.valueOf(Main.buffer.Front()));
                    Main.primes.Plus();
                    Main.primes.SetLargest(Main.buffer.Pop());
                }
            }
            if (Main.producer.IsFinished())
            {
                while (!Main.buffer.IsEmpty())
                {
                    Main.writer.Write(String.valueOf(Main.buffer.Front()));
                    Main.primes.Plus();
                    Main.primes.SetLargest(Main.buffer.Pop());
                }
                Main.writer.Close();
                System.out.println("Consumer close writer");
                break;
            }
        }
        System.out.println("Consumer end");
    }
    Consumer ()
    {
        start();
    }
}
