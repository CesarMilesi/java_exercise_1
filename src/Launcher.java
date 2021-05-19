import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Launcher
{
    public static void main(String[] args)
    {
        List<Command> commands = List.of(new Quit(), new Fibo(), new Freq());
        Map<String, Command> commandsByName = commands.stream().collect(Collectors.toMap(c -> c.name(), c->c));

        Scanner scanner = new Scanner(System.in);
        boolean shouldQuit = false;
        do
        {
            System.out.println("Entrez une commande :");
            String userInput = scanner.nextLine();
            Command command = commandsByName.get(userInput);

            if (command == null)
                System.out.println("Unknown command");
            else
                shouldQuit = command.run(scanner);
        } while (!shouldQuit);
    }
}