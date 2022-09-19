import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class Visualizer extends JPanel {
    private int[] arr;

    private final int WIDTH = 1000;
    private final int HEIGHT = 600;

    private final int BAR_WIDTH = 10;
    private final int NUM_BARS = WIDTH / BAR_WIDTH;

    // constructor
    public Visualizer() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);

        generateArr();
    }

    // paint
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawInitialBars(g);
    }

    // draw
    public void drawInitialBars(Graphics g) {
        for (int i = 0; i < NUM_BARS; i++) {
            int height = arr[i]*10;
            int x = i + (BAR_WIDTH - 1) * i;
            int y = HEIGHT - height;

            g.setColor(Color.RED);
            g.fillRect(x, y, BAR_WIDTH, height);
            g.setColor(Color.WHITE);
            g.drawRect(x, y, BAR_WIDTH, height);
        }
    }

    // generate and draw a new array
    public void generateArr() {
        Random rd = new Random();

        this.arr = new int[NUM_BARS];

        for (int i = 0; i < NUM_BARS; i++) {
            this.arr[i] = rd.nextInt(50 - 1) + 1;
        }

        this.repaint();
    }

    // sort animation
    public void sortAnimate(String name) {
        BubbleSort bubbleSort = new BubbleSort(arr);

        Timer timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bubbleSort.isSorted()) {
                    ((Timer) e.getSource()).stop();
                    System.out.println(bubbleSort);
                }
                else {
                    bubbleSort.sort();
                }
                repaint();
            }
        });
        timer.start();
    }
}