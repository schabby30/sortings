package com.schabby.sortings;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class QuickSort extends JPanel implements Runnable {

    int[] arr;

    public QuickSort(int[] arr) {
        
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
    
    @Override
    public void run() {
        quickSort(0, this.arr.length - 1);
    }
    
    public int partition(int low, int high) {
        
        int pivot = high;
        int index = low;
        
        for (int i = low; i < high; i++) {
            if (this.arr[i] < this.arr[pivot]) {
                int temp = this.arr[index];
                this.arr[index] = this.arr[i];
                this.arr[i] = temp;
                index++;
                
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
        
        int temp = arr[pivot];
        arr[pivot] = arr[index];
        arr[index] = temp;
        
        return index;
    }
    
    public void quickSort(int low, int high) {
        if (high <= low) return;
        int pivot = partition(low, high);
        
        quickSort(low, pivot - 1);
        quickSort(pivot + 1, high);
    }
}