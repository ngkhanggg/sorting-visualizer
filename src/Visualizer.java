import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class Visualizer extends JPanel {
    private int[] array;
    
    public static int[] barColours;

    private final int WIDTH = 1000;
    private final int HEIGHT = 600;

    private final int BAR_WIDTH = 25;
    private final int NUM_BARS = WIDTH / BAR_WIDTH;

    // constructor
    public Visualizer() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        
        barColours = new int[NUM_BARS];

        generateArray();
    }

    // get the size of the array
    public int getArraySize() {
        return NUM_BARS;
    }

    // get value from array
    public int getValue(int index) {
        return array[index];
    }

    // generate and draw a new array
    public void generateArray() {
        Random rd = new Random();

        array = new int[NUM_BARS];

        for (int i = 0; i < NUM_BARS; i++) {
            array[i] = rd.nextInt(50 - 1) + 1;
        }

        resetColours();

        repaint();
    }

    // reset colours
    public void resetColours() {
        for (int i = 0; i < NUM_BARS; i++) {
            barColours[i] = 0;
        }
    }

    // swap
    public void swap(int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

        barColours[index1] = 100;
        barColours[index2] = 100;
    }

    // set colour for bars
    public void updateSingle(int index, int value) {
        array[index] = value;
        barColours[index] = 100;
        repaint();
    }

    // highlight bars
    public void highlightArray() {
        for (int i = 0; i < getArraySize(); i++) {
            updateSingle(i, getValue(i));
        }
    }

    // sort animation
    public void sortAnimate(String name, Visualizer visualizer) {
        BubbleSort bubbleSort = new BubbleSort(visualizer);
        SelectionSort selectionSort = new SelectionSort(visualizer);

        Timer timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(name) {
                    case "Bubble Sort":
                        if (bubbleSort.isSorted()) {
                            ((Timer)e.getSource()).stop();
                            System.out.println(bubbleSort);
                            highlightArray();
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
                            highlightArray();
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

    // paint
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    // draw
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        for (int i = 0; i < NUM_BARS; i++) {
            int height = array[i]*10;
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
}