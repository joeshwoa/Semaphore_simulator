public class Counter {
    public static int c;
    Counter ()
    {
        c=0;
        Gui.SetCounter(String.valueOf(c));
    }
    public void Plus ()
    {
        c+=1;
        Gui.SetCounter(String.valueOf(c));
    }
    public void SetLargest (long num)
    {
        Gui.Setlargest(String.valueOf(num));
    }
}
