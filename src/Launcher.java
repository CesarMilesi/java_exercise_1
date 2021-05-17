import java.util.Scanner;

public class Launcher
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        var user = scanner.nextLine();
        switch (user)
        {
            case "quit":
                break;
            default:
                System.out.println("Unknown command");
        }
    }
}