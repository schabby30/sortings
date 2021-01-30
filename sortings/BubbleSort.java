package com.schabby.sortings;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BubbleSort extends JPanel {
    
    int[] arr;
    
    public BubbleSort(int[] arr) {
        setPreferredSize(new Dimension(400, 250));
        this.arr = arr;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < this.arr.length; i++) {
            g.fillRect(i*3+50,50, 2, 50+this.arr[i]);
        }
    }
    
    public void bubbleSort() {
            
        int temp;
        
        for (int i=0; i < 100; i++) {
            for (int j=0; j < this.arr.length-1; j++) {
                if (this.arr[j] < this.arr[j+1]) {
                    temp = this.arr[j];
                    this.arr[j] = this.arr[j+1];
                    this.arr[j+1] = temp;
                    
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
        
    }
    
}
