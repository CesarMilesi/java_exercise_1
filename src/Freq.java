import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Freq implements Command
{

    @Override
    public String name()
    {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner)
    {
        // A finir
        return false;
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
}