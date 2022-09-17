import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame implements ActionListener {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    private JButton shuffleButton, exitButton, sortButton[];
    private JPanel optionsPanel;

    private Visualizer visualizer;

    private final String sortersName[] = {"Bubble Sort", "Insertion Sort", "Merge Sort", "Selection Sort", "Quick Sort"};

    public Window() {
        visualizer = new Visualizer();
        visualizer.repaint();

        optionsPanel = new JPanel();
        optionsPanel.setLayout(new FlowLayout());
        optionsPanel.setPreferredSize(new Dimension(0, 40));
        optionsPanel.setBackground(Color.BLACK);

        sortButton = new JButton[5];
        for (int i = 0; i < sortButton.length; i++) {
            sortButton[i] = new JButton();
            sortButton[i].setForeground(Color.WHITE);
            sortButton[i].setFont(new Font("Cambria", Font.PLAIN, 20));
            sortButton[i].setText(sortersName[i]);
            sortButton[i].setFocusable(false);
            sortButton[i].setBackground(Color.BLACK);
            sortButton[i].setForeground(Color.WHITE);
            sortButton[i].addActionListener(this);
            optionsPanel.add(sortButton[i]);
            optionsPanel.add(Box.createHorizontalStrut(3));
        }

        shuffleButton = new JButton();
        shuffleButton.setFont(new Font("Cambria", Font.PLAIN, 20));
        shuffleButton.setText("SHUFFLE");
        shuffleButton.setForeground(Color.WHITE);
        shuffleButton.setBackground(Color.BLACK);
        shuffleButton.setFocusable(false);
        shuffleButton.addActionListener(this);

        exitButton = new JButton();
        exitButton.setFont(new Font("Cambria", Font.PLAIN, 20));
        exitButton.setText("EXIT");
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(Color.BLACK);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);

        optionsPanel.add(shuffleButton);
        optionsPanel.add(Box.createHorizontalStrut(3));
        optionsPanel.add(exitButton);
        
        this.setTitle("Sorting Visualizer");
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.add(optionsPanel, BorderLayout.NORTH);
        this.add(visualizer, BorderLayout.CENTER);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object a = e.getSource();
        if (a == shuffleButton) {
            System.out.println("Shuffled");
        }

        if (a == exitButton) {
            System.exit(0);
        }

        for (int i = 0; i < sortButton.length; i++) {
            if (a == sortButton[i]) {
                System.out.println(sortButton[i].getText());
            }
        }
    }
}