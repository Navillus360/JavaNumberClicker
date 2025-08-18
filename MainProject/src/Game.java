import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game {
    //region UI
    private JFrame screen;
    private JPanel numberPanel, btnPanel;
    private JLabel numberLabel;
    private Font btnFont, numberFont;
    private JButton increaseBtn, decreaseBtn;
    //endregion

    private int number = 0;

    public static void main(String[] args) {
        Game game = new Game();
        game.setupUI();
        game.setupInteraction();
    }

    public void setupUI() {
        btnFont = new Font(Font.SANS_SERIF, Font.PLAIN, 45);
        numberFont = new Font(Font.SANS_SERIF, Font.BOLD, 120);

        //Creating the game window
        screen = new JFrame("Number Clicker");
        screen.setSize(800, 600);
        screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setVisible(true);

        //Panel setup
        btnPanel = new JPanel();
        btnPanel.setBounds(100, 250, 600, 200);
        numberPanel = new JPanel();
        numberPanel.setBounds(700, 500, 100, 100);
        screen.add(btnPanel, BorderLayout.CENTER);
        screen.add(numberPanel, BorderLayout.CENTER);

        //Btn setup
        increaseBtn = new JButton("Increase");
        increaseBtn.setFont(btnFont);
        increaseBtn.setMargin(new Insets(20, 20, 20, 20));
        increaseBtn.setFocusPainted(false);

        decreaseBtn = new JButton("Decrease");
        decreaseBtn.setFont(btnFont);
        decreaseBtn.setMargin(new Insets(20, 20, 20, 20));
        decreaseBtn.setFocusPainted(false);

        btnPanel.add(increaseBtn);
        btnPanel.add(decreaseBtn);

        //Label setup
        numberLabel = new JLabel(String.valueOf(number), SwingConstants.CENTER);
        numberLabel.setFont(numberFont);
        numberPanel.add(numberLabel);
    }

    public void setupInteraction() {
        Timer increaseBtnTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number++;
                numberLabel.setText(String.valueOf(number));
            }
        });

        increaseBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                number++;
                numberLabel.setText(String.valueOf(number));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (!increaseBtnTimer.isRunning()) {
                    increaseBtnTimer.start();
                    increaseBtnTimer.setDelay(20);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                {
                    increaseBtnTimer.setDelay(100);
                    increaseBtnTimer.stop();
                }
            }
        });

        Timer decreaseBtnTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number--;
                numberLabel.setText(String.valueOf(number));
            }
        });

        decreaseBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                number--;
                numberLabel.setText(String.valueOf(number));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (!decreaseBtnTimer.isRunning()) {
                    decreaseBtnTimer.start();
                    decreaseBtnTimer.setDelay(20);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                {
                    decreaseBtnTimer.setDelay(100);
                    decreaseBtnTimer.stop();
                }
            }
        });
    }
}
