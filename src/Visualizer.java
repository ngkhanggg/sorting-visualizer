import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class Visualizer extends JPanel {
    private int[] arr;
    
    public static int[] barColours;

    private final int WIDTH = 1000;
    private final int HEIGHT = 600;

    private final int BAR_WIDTH = 25;
    private final int NUM_BARS = WIDTH / BAR_WIDTH;

    // constructor
    public Visualizer() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        
        barColours = new int[NUM_BARS];

        generateArr();
    }

    // paint
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    // draw
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        for (int i = 0; i < NUM_BARS; i++) {
            int height = arr[i]*10;
            int x = i + (BAR_WIDTH - 1) * i;
            int y = HEIGHT - height;

            int val = barColours[i]*2;
            g.setColor(new Color(255, 255 - val, 255 - val));
            g.fillRect(x, y, BAR_WIDTH, height);
            g.setColor(Color.WHITE);
            g.drawRect(x, y, BAR_WIDTH, height);

            if (barColours[i] > 0) {
                barColours[i] -= 10;
            }
        }
    }

    public int getNumBars() {
        return NUM_BARS;
    }

    // generate and draw a new array
    public void generateArr() {
        Random rd = new Random();

        this.arr = new int[NUM_BARS];

        for (int i = 0; i < NUM_BARS; i++) {
            this.arr[i] = rd.nextInt(50 - 1) + 1;
        }

        resetColours();

        this.repaint();
    }

    // reset colours
    public void resetColours() {
        for (int i = 0; i < NUM_BARS; i++) {
            barColours[i] = 0;
        }
    }

    // sort animation
    public void sortAnimate(String name) {
        BubbleSort bubbleSort = new BubbleSort(arr);
        SelectionSort selectionSort = new SelectionSort(arr);

        Timer timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(name) {
                    case "Bubble Sort":
                        if (bubbleSort.isSorted()) {
                            ((Timer)e.getSource()).stop();
                            System.out.println(bubbleSort);
                        }
                        else {
                            bubbleSort.sort();
                        }
                        repaint();
                        break;
                    case "Selection Sort":
                        if (selectionSort.isSorted()) {
                            ((Timer)e.getSource()).stop();
                            System.out.println(selectionSort);
                        }
                        else {
                            selectionSort.sort();
                        }
                        repaint();
                        break;
                }
            }
        });
        timer.start();
    }
}