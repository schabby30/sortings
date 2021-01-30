package com.schabby.sortings;
    
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SelectionSort extends JPanel {

    int[] arr;

    public SelectionSort(int[] arr) {
        
        this.arr = arr;
        setPreferredSize(new Dimension(400, 250));

    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < this.arr.length; i++) {
            g.fillRect(i*3+50,50, 2, 50+this.arr[i]);
        }
    }

    public void selectionSort() {

        for (int i = 0; i < this.arr.length - 1; i++) {
            
            int index = i;
            
            for (int j = i + 1; j < this.arr.length; j++) {
                
                if (this.arr[j] < this.arr[index]) {
                    index = j;
                }
            }
                
            int smallerNumber = this.arr[index];
            this.arr[index] = this.arr[i];
            this.arr[i] = smallerNumber;


            try
            {
                Thread.sleep(5);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    repaint();
                }
            });

        }

    }
    
}