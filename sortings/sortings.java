package com.schabby.sortings;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class sortings {
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                sortings app = new sortings();
            }
        });
        
    }
    
    private sortings() {
        //create, fill up and print array of 100 elements
        int[] arr = new int[100];
        
        for (int i=0; i<100; i++) {
            int element = ThreadLocalRandom.current().nextInt(1, 100);
            arr[i] = element;
        }
        
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        
        //set up GUI
        JFrame frame = new JFrame();
        frame.setTitle("sorting algorithms");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setVisible(true);
        
        JPanel panel = new JPanel(new BorderLayout());
        Box menu = new Box(BoxLayout.X_AXIS);
        JButton button = new JButton("sort");
        
        String[] algorithms = new String[] {"Bubble Sort", "Selection Sort",
                                    "Insertion Sort", "QuickSort", "Merge Sort"};
 
        JComboBox<String> algorithmList = new JComboBox<>(algorithms);
        algorithmList.setPreferredSize(new Dimension(200, 30));
        
        Container contentPane = frame.getContentPane();
        contentPane.setPreferredSize(new Dimension(400, 300));
        
        menu.setPreferredSize(new Dimension(400, 50));
        menu.add(algorithmList);
        menu.add(button);
        
        BubbleSort bs = new BubbleSort(arr);
        SelectionSort ss = new SelectionSort(arr);
        InsertionSort is = new InsertionSort(arr);
        QuickSort qs = new QuickSort(arr);
        MergeSort ms = new MergeSort(arr);
                
        panel.add(menu, BorderLayout.NORTH);
        panel.add(bs, BorderLayout.SOUTH);
        
        frame.add(panel);
        frame.pack();
        
        button.addActionListener((ActionEvent e) -> {
            int chosenAlgorithm = algorithmList.getSelectedIndex();
            switch (chosenAlgorithm) {
                case 0:
                    Thread thread1 = new Thread() {
                        @Override
                        public void run() {
                            bs.bubbleSort();
                        }
                    };
                    frame.remove(panel);
                    panel.remove(bs);
                    panel.add(bs, BorderLayout.SOUTH);
                    frame.add(panel);
                    frame.pack();
                    thread1.start();
                    break;
                case 1:
                    Thread thread2 = new Thread() {
                        @Override
                        public void run() {
                            ss.selectionSort();
                        }
                    };
                    frame.remove(panel);
                    panel.remove(bs);
                    panel.add(ss, BorderLayout.SOUTH);
                    frame.add(panel);
                    frame.pack();
                    thread2.start();
                    break;
                case 2:
                    Thread thread3 = new Thread() {
                        @Override
                        public void run() {
                            is.insertionSort();
                        }
                    };
                    frame.remove(panel);
                    panel.remove(bs);
                    panel.add(is, BorderLayout.SOUTH);
                    frame.add(panel);
                    frame.pack();
                    thread3.start();
                    break;
                case 3:
                    Thread thread4 = new Thread(qs);
                    frame.remove(panel);
                    panel.remove(bs);
                    panel.add(qs, BorderLayout.SOUTH);
                    frame.add(panel);
                    frame.pack();
                    thread4.start();
                    break;
                case 4:
                    Thread thread5 = new Thread(ms);
                    frame.remove(panel);
                    panel.remove(bs);
                    panel.add(ms, BorderLayout.SOUTH);
                    frame.add(panel);
                    frame.pack();
                    thread5.start();
                    break;
            }
        });
    }
}
