import javax.swing.*;
import java.awt.*;

public class Game {
    //region UI
    private JFrame screen;
    private JLabel numberLabel;
    private Font generalFont;
    //endregion

    public static void main(String[] args) {
        Game game = new Game();
        game.showScreen();
    }

    public void showScreen(){
        generalFont = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
        screen = new JFrame("Number Clicker");
        screen.setSize(800, 600);
        screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        screen.setVisible(true);
        numberLabel = new JLabel("0", SwingConstants.CENTER);
        numberLabel.setFont(generalFont);
        screen.add(numberLabel);
    }
}
