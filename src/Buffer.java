import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private final int size;
    private final Queue<Long> buffer ;
    private int in_queue;

    Buffer (int s)
    {
        size = s;
        in_queue=0;
        buffer = new LinkedList<Long>();
    }
    public void Push (long ele){
        in_queue+=1;
        buffer.add(ele);
        System.out.println("in queue now : "+in_queue);
    }
    public synchronized Long Pop ()
    {
        in_queue-=1;
        System.out.println("in queue now : "+in_queue);
        return buffer.remove();
    }
    public Long Front ()
    {
        return buffer.peek();
    }
    public boolean IsFull ()
    {
        return in_queue==size;
    }
    public boolean IsEmpty ()
    {
        return in_queue==0;
    }
}
