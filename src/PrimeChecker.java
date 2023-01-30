public class PrimeChecker {
    public static boolean Check (long num)
    {
        long i = 2;
        while (i<=(num/2))
        {
            if ((num%i) == 0)
            {
                return false;
            }
            i+=1;
        }
        return num != 1 && num != 0;
    }
}
