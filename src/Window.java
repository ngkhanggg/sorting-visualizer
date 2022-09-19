import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame implements ActionListener {
    // components
    private JButton shuffle, exit, sortButtons[];
    private JPanel buttonsPanel;

    // visualizer panel
    private Visualizer visualizer;

    // names of sorting algorithms
    private final String sortersName[] = {"Bubble Sort", "Insertion Sort", "Merge Sort", "Selection Sort", "Quick Sort"};

    public Window() {
        visualizer = new Visualizer();

        // panel for different buttons
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.setPreferredSize(new Dimension(0, 40));
        buttonsPanel.setBackground(Color.BLACK);

        // buttons for chosing between sorting algorithms
        sortButtons = new JButton[5];
        for (int i = 0; i < sortButtons.length; i++) {
            sortButtons[i] = new JButton();
            sortButtons[i].setFont(new Font("Cambria", Font.PLAIN, 20));
            sortButtons[i].setText(sortersName[i]);
            sortButtons[i].setFocusable(false);
            sortButtons[i].setBackground(Color.BLACK);
            sortButtons[i].setForeground(Color.WHITE);
            sortButtons[i].addActionListener(this);
            buttonsPanel.add(sortButtons[i]);
            buttonsPanel.add(Box.createHorizontalStrut(3));
        }

        // shuffle button
        shuffle = new JButton();
        shuffle.setFont(new Font("Cambria", Font.PLAIN, 20));
        shuffle.setText("Shuffle");
        shuffle.setForeground(Color.WHITE);
        shuffle.setBackground(Color.BLACK);
        shuffle.setFocusable(false);
        shuffle.addActionListener((e) -> visualizer.generateArr());

        // exit button
        exit = new JButton();
        exit.setFont(new Font("Cambria", Font.PLAIN, 20));
        exit.setText("Exit");
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.BLACK);
        exit.setFocusable(false);
        exit.addActionListener((e) -> System.exit(0));

        // add exit button and shuffle button to button panel
        buttonsPanel.add(shuffle);
        buttonsPanel.add(Box.createHorizontalStrut(3));
        buttonsPanel.add(exit);
        
        // frame
        this.setTitle("Sorting Visualizer");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(buttonsPanel, BorderLayout.NORTH);
        this.add(visualizer, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object a = e.getSource();

        for (int i = 0; i < sortButtons.length; i++) {
            if (a == sortButtons[i]) {
                String algorithm = sortButtons[i].getText();
                visualizer.sortAnimate(algorithm);
            }
        }
    }
}