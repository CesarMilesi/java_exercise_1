import java.util.Scanner;

public class Quit implements Command
{

    @Override
    public String name()
    {
        return "quit";
    }

    @Override
    public boolean run(Scanner scanner)
    {
        System.out.println("Entre un mot :");
        var user = scanner.nextLine();
        switch (user)
        {
            case "quit":
                break;
            default:
                System.out.println("Unknown command");
        }
        return false;
    }
}