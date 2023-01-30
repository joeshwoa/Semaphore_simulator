
public class Semaphore{
     private int value;
     private final int size;
     private int mutex;

    Semaphore (int v)
    {
        mutex = 1;
        value = v;
        size = v;
    }
    public synchronized void Produce() throws InterruptedException {
        if(mutex > 0)
            mutex -= 1;
        this.value-=1;
        System.out.println("producer make value = " + value);
        if(this.value < 0)
        {
            mutex += 1;
            notify();
            System.out.println("consumer notify and producer wait");
            wait();
            System.out.println("producer make value = " + value);
        }
    }
    public synchronized void Consume () throws InterruptedException {
        if(mutex == 0)
        {
            System.out.println("consumer wait");
            wait();
        }
        this.value+=1;
        System.out.println("consume make value = " + value);
        if(this.value == size)
        {
            this.value-=1;
            notify();
            System.out.println("consumer wait and producer notify");
            wait();
        }
    }
    public synchronized void Unlock() throws InterruptedException {
        mutex += 1;
        notify();
        System.out.println("producer un lock mutex when he finished");
    }
}

