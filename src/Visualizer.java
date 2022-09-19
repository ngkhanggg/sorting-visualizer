import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Visualizer extends JPanel {
    private int[] arr;

    private final int WIDTH = 1100;
    private final int HEIGHT = 600;

    private final int BAR_WIDTH = 4;
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
        draw(g);
    }

    // draw
    public void draw(Graphics g) {
        for (int i = 0; i < NUM_BARS; i++) {
            int height = arr[i]*10;
            int x = i + (BAR_WIDTH - 1) * i;
            int y = HEIGHT - height;

            g.setColor(Color.GREEN);
            g.fillRect(x, y, BAR_WIDTH, height);
            g.setColor(Color.WHITE);
            g.drawRect(x, y, BAR_WIDTH, height);
        }
    }

    // get number of bars
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

        this.repaint();
    }

    // sort animation
    public void sortAnimate(String name) {
        BubbleSort bubbleSort = new BubbleSort(arr);

        switch(name) {
            case "Bubble Sort":
                bubbleSort.sort();
                System.out.println(bubbleSort.toString());
                break;
            default:
                System.out.println("Hehehe");
                break;
        }

        this.repaint();
    }
}