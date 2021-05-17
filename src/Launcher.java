import java.util.Scanner;

public class Launcher
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("fibo"))
        {
            var number = scanner.nextInt();
            scanner.nextLine();
            System.out.println(fibo(number));
        }
    }

    public static int fibo(int fib)
    {
        if (fib == 0)
        {
            return 0;
        }
        else if (fib == 1)
        {
            return 1;
        }
        else
        {
            return fibo(fib - 1) + fibo(fib - 2);
        }
    }
}