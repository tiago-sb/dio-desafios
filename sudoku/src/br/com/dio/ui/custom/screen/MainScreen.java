package ui.custom.screen;

import java.awt.Dimension;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Space;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import service.BoardService;
import service.EventEnum;
import service.NotifierService;
import ui.custom.button.ButtonCheckGameStatus;
import ui.custom.button.ButtonFinish;
import ui.custom.button.ButtonReset;
import ui.custom.frame.MainFrame;
import ui.custom.input.NumberText;
import ui.custom.panel.MainPanel;
import ui.custom.panel.SudokuSector;

public class MainScreen {
  private final static Dimension dimension = new Dimension(600, 600);
  private final BoardService boardService;
  private final NotifierService notifierService;
  private JButton buttonCheckGameStatus;
  private JButton buttonFinish;
  private JButton buttonReset;

  public MainScreen(Map<String, String> gameConfig) {
    this.boardService = new BoardService(gameConfig);
    this.notifierService = new NotifierService();
  }

  public void buildMainScreen() {
    JPanel mainPanel = new MainPanel(dimension);
    JFrame mainFrame = new MainFrame(dimension, mainPanel);
    
    for(int r = 0; r < 9; r += 3){
      var endRow = r + 2;
      for(int c = 0; c < 9; c += 3){
        var endCol = c + 2;
        var spaces = getSpacesFromSector(boardService.getSpaces(), c, endCol, r, endRow);
        JPanel sector = generateSection(spaces);
        mainPanel.add(sector);
      }
    }

    addResetButton(mainPanel);
    addShowGameStatusButton(mainPanel);
    addFinishGameButton(mainPanel);
    mainFrame.revalidate();
    mainFrame.repaint();
  }

  private List<Space> getSpacesFromSector(final List<List<Space>> spaces, final int initCol, final int endCol, final int initRow, final int endRow){
    List<Space> spaceSector = new ArrayList<>();
    for(int r = initRow; r <= endRow; r++){
      for(int c = initCol; c <= endCol; c++){
        spaceSector.add(spaces.get(c).get(r));
      }
    }

    return spaceSector;
  }

  private JPanel generateSection(final List<Space> spaces){
    List<NumberText> fields = new ArrayList<>(spaces.stream().map(NumberText::new).toList());
    fields.forEach(t -> notifierService.subscribe(EventEnum.CLEAR_SPACE, t));
    return new SudokuSector(fields);
  }

  private void addFinishGameButton(JPanel mainPanel) {
    buttonFinish = new ButtonFinish(e -> {
      if(boardService.gameFinish()){
        JOptionPane.showMessageDialog(null, "Parabéns! Jogo finalizado!!");
        buttonReset.setEnabled(false);
        buttonCheckGameStatus.setEnabled(false);
        buttonFinish.setEnabled(false);
      } else {
        JOptionPane.showMessageDialog(null, "Seu jogo ainda possi inconsistência!!");
      }
    });
    mainPanel.add(buttonFinish);
  }

  private void addShowGameStatusButton(JPanel mainPanel) {
    buttonCheckGameStatus = new ButtonCheckGameStatus(e -> {
      var hasErros = boardService.hasErros();
      var gameStatus = boardService.getStatus();
      var message = switch (gameStatus) {
        case NAO_INICIADO -> "O jogo não foi iniciado";
        case INCOMPLETO -> "O jogo está incompleto";
        case COMPLETO -> "O jogo está completo";
      };

      message += hasErros ? " e contém erros" : " e não contém erros";
      JOptionPane.showMessageDialog(null, message);
    });

    mainPanel.add(buttonCheckGameStatus);
  }

  private void addResetButton(JPanel mainPanel) {
    buttonReset = new ButtonReset(e -> {
      var dialogResult = JOptionPane.showConfirmDialog(
          null,
          "Deseja realmente iniciar o jogo?",
          "Limpar o jogo",
          YES_NO_OPTION,
          JOptionPane.QUESTION_MESSAGE);

      if (dialogResult == 0) {
        boardService.reset();
        notifierService.notify(EventEnum.CLEAR_SPACE);
      }
    });

    mainPanel.add(buttonReset);
  }
}