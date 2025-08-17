import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    //region UI
    private JFrame screen;
    private JPanel panel;
    private JLabel numberLabel;
    private Font generalFont;
    private JButton increaseBtn, decreaseBtn;
    //endregion

    private int number;

    public static void main(String[] args) {
        Game game = new Game();
        game.setupUI();
        game.setupInteraction();
    }

    public void setupUI() {
        generalFont = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
        screen = new JFrame("Number Clicker");
        screen.setSize(800, 600);
        screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setVisible(true);

        panel = new JPanel();
        screen.add(panel, BorderLayout.CENTER);

        increaseBtn = new JButton("Increase");
        increaseBtn.setFont(generalFont);
        decreaseBtn = new JButton("Decrease");
        decreaseBtn.setFont(generalFont);
        panel.add(increaseBtn);
        panel.add(decreaseBtn);

        numberLabel = new JLabel(String.valueOf(number), SwingConstants.CENTER);
        numberLabel.setFont(generalFont);
        panel.add(numberLabel);
    }

    public void setupInteraction() {
        increaseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number++;
                numberLabel.setText(String.valueOf(number));
            }
        });

        decreaseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number--;
                numberLabel.setText(String.valueOf(number));
            }
        });
    }
}
