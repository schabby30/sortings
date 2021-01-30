package com.schabby.sortings;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MergeSort extends JPanel implements Runnable {
    
    int[] arr;
    
    public MergeSort(int[] arr) {
        
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
        mergeSort(this.arr, 0);
    }
    
    public int[] mergeSort(int[] array, int offset) {

        int midPoint = array.length / 2;
        int[] left, right;
        int[] result = new int[array.length];

        //recursive control 
        if (array.length <= 1) {
            return array;
        }

        //initializing arrays
        left = new int[midPoint];

        if (array.length % 2 == 0) {
            right = new int[midPoint];
        } else {
            right = new int[midPoint + 1];
        }

        //populating left and right arrays
        for (int i = 0; i < midPoint; i++) {
            left[i] = array[i];
        }
        
        for (int j = 0; j < right.length; j++) {
            right[j] = array[midPoint + j];
        }

        //resursive calls for both subarrays
        left = mergeSort(left, offset);
        right = mergeSort(right, offset + left.length); 

        //merging the subarrays
        result = merge(left, right);
        
        for (int i = offset; i < result.length; i++) {
            
            this.arr[i] = result[i];
            
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
        
        return result;
        
    }
     
    public int[] merge (int[] left, int[] right) {

        int[] result = new int[left.length + right.length];
        int leftPointer, rightPointer, resultPointer;

        leftPointer = rightPointer = resultPointer = 0;

        while (leftPointer < left.length || rightPointer < right.length) {

            if (leftPointer < left.length && rightPointer < right.length ) {

                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }

            }

            else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            }

            else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
            
        }
        
        return result;

    }
    
}
