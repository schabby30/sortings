package com.schabby.sortings;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class InsertionSort extends JPanel {

    int[] arr;

    public InsertionSort(int[] arr) {
        
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

    public void insertionSort() {

        for (int i = 1; i < this.arr.length; i++) {
            
            int temp;
            
            for (int j = i; j > 0; j--) {
                
                if (this.arr[j] < this.arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1]= temp;
                }
            }
                
            try
            {
                Thread.sleep(20);
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