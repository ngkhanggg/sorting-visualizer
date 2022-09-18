import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame implements ActionListener {
    // components
    private JButton shuffleButton, exitButton, sortButton[];
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
            buttonsPanel.add(sortButton[i]);
            buttonsPanel.add(Box.createHorizontalStrut(3));
        }

        // shuffle button
        shuffleButton = new JButton();
        shuffleButton.setFont(new Font("Cambria", Font.PLAIN, 20));
        shuffleButton.setText("Shuffle");
        shuffleButton.setForeground(Color.WHITE);
        shuffleButton.setBackground(Color.BLACK);
        shuffleButton.setFocusable(false);
        shuffleButton.addActionListener((e) -> visualizer.generateArr());

        // exit button
        exitButton = new JButton();
        exitButton.setFont(new Font("Cambria", Font.PLAIN, 20));
        exitButton.setText("Exit");
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(Color.BLACK);
        exitButton.setFocusable(false);
        exitButton.addActionListener((e) -> System.exit(0));

        // add exit button and shuffle button to button panel
        buttonsPanel.add(shuffleButton);
        buttonsPanel.add(Box.createHorizontalStrut(3));
        buttonsPanel.add(exitButton);
        
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

        for (int i = 0; i < sortButton.length; i++) {
            if (a == sortButton[i]) {
                System.out.println(sortButton[i].getText());
            }
        }
    }
}