import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Launcher
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("freq"))
        {
            var command = Paths.get(args[0]);
            if (command.equals(null))
            {
                System.out.println("Unreadable file: " + command);
            }
            else
            {
                var array = Array(command);
                System.out.println(array);
            }
        }
    }

    public static String Array(Path path)
    {
        String[] words = new String[100];
        try
        {
            String francis = Files.readString(path);
            words = francis.split(" ");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Stream<String> wordStream = Arrays.stream(words);
        Map<String, Long> collectbis = wordStream
                .filter(s -> !s.isBlank())
                .map(s -> s.toLowerCase())
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        Function<Map.Entry<String, Long>, Long> count = c -> c.getValue();

        String threecounting = collectbis.entrySet().stream()
                .sorted(Comparator.comparing(count).reversed())
                .limit(3)
                .map (e -> e.getKey())
                .collect(Collectors.joining(" "));
        return threecounting;
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