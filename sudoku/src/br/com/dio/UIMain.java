import java.util.stream.Collectors;
import java.util.stream.Stream;
import ui.custom.screen.MainScreen;

public class UIMain {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.err.println("Nenhum argumento de configuração foi passado.");
      System.out.println(args.toString());
      return;
    }

    final var gameConfig = Stream.of(args)
        .collect(Collectors.toMap(
            k -> k.split(";")[0],
            v -> v.split(";")[1]));

    var mainScreen = new MainScreen(gameConfig);
    mainScreen.buildMainScreen();
  }
}
