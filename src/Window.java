import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame implements KeyListener {
    private final int WIDTH = 1280;
    private final int LENGTH = 720;

    private JFrame window;
    private JLabel labels[] = new JLabel[5];
    private JPanel optionsPanel;

    private final String sortersName[] = {"1 - Bubble Sort", "2 - Insertion Sort", "3 - Merge Sort", "4 - Selection Sort", "5 - Quick Sort"};

    public Window() {        
        optionsPanel = new JPanel();
        optionsPanel.setLayout(new FlowLayout());
        optionsPanel.setPreferredSize(new Dimension(0, 35));
        optionsPanel.setBackground(Color.BLACK);

        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
            labels[i].setForeground(Color.WHITE);
            labels[i].setFont(new Font("Cambria", Font.PLAIN, 20));
            labels[i].setText(sortersName[i]);
            labels[i].setVerticalAlignment(JLabel.CENTER);
            optionsPanel.add(labels[i]);
            optionsPanel.add(Box.createHorizontalStrut(25));
        }
        
        window = new JFrame("Sorting Visualizer");
        window.setSize(WIDTH, LENGTH);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setLayout(new BorderLayout());
        window.add(optionsPanel, BorderLayout.NORTH);
        window.addKeyListener(this);
        window.setVisible(true);
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getLength() {
        return LENGTH;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("You press key char: " + e.getKeyChar());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("You type key char: " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("You release key char: " + e.getKeyChar());
    }
}