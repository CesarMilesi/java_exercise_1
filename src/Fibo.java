import java.util.Scanner;

public class Fibo implements Command
{

    @Override
    public String name()
    {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scanner)
    {
        System.out.println("Entre un nombre :");
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.println(fibo(n));
        return false;
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