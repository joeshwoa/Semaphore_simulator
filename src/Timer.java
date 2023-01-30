public class Timer extends Thread{
    static public long time;
    private boolean stop;
    Timer()
    {
        time=0;
        stop=false;
        start();
    }
    @Override
    public void run() {
        while (!stop)
        {
            try {
                Timer.sleep(1);
                time+=1;
                Gui.SetTime(String.valueOf(time));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public void Stop ()
    {
        stop=true;
    }
}
