package com.tutego.exercises.optim;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class AWTThread
{

    public static void main(java.lang.String[] args) {

        Runnable drawRunnable = new Runnable() {

            public void run() {

                String lnf = UIManager.getSystemLookAndFeelClassName();

                try {

                    UIManager.setLookAndFeel(lnf);

                } catch (Exception ex) {

                    ex.printStackTrace();

                }

                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

                JFrame f = new JFrame();

                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                Container c = f.getContentPane();

                c.setLayout(new FlowLayout(FlowLayout.LEADING));

                JButton button1 = new JButton("That's me ... a slow button.");

                button1.setPreferredSize(new Dimension(200, 100));

                button1.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        ((JButton) e.getSource()).setCursor(Cursor
                                .getPredefinedCursor(Cursor.WAIT_CURSOR));

                        for (int i = 0; i < 100; i++) {

                            System.out.println("Very slow implementation ...");

                            try {

                                Thread.sleep(100);
                            } catch (InterruptedException ex) {

                                ex.printStackTrace();
                            }
                        }

                        ((JButton) e.getSource()).setText("Finished.");

                        ((JButton) e.getSource()).setCursor(Cursor
                                .getPredefinedCursor(Cursor.DEFAULT_CURSOR));

                    }

                });

                c.add(button1);

                JButton button2 = new JButton("That's me ... a fast button.");

                button2.setPreferredSize(new Dimension(200, 100));

                button2.addActionListener(new ActionListener() {

                    public void actionPerformed(final ActionEvent e) {

                        new Thread() {

                            public void run() {

                                try {

                                    SwingUtilities
                                            .invokeAndWait(new Runnable() {

                                                public void run() {

                                                    ((JButton) e.getSource())
                                                            .setCursor(Cursor
                                                                    .getPredefinedCursor(Cursor.WAIT_CURSOR));

                                                }

                                            });

                                } catch (Exception ex1) {

                                    ex1.printStackTrace();
                                }

                                for (int i = 0; i < 1000; i++) {

                                    System.out
                                            .println("Better implementation ...");

                                    try {

                                        Thread.sleep(100);

                                    } catch (InterruptedException ex) {

                                        ex.printStackTrace();
                                    }

                                }

                                SwingUtilities.invokeLater(new Runnable() {

                                    public void run() {

                                        ((JButton) e.getSource())
                                                .setText("Finished.");

                                        ((JButton) e.getSource())
                                                .setCursor(Cursor
                                                        .getPredefinedCursor(Cursor.DEFAULT_CURSOR));

                                    }

                                });

                            }

                        }.start();

                    }

                });

                c.add(button2);

                f.pack();

                int w = f.getSize().width;
                int h = f.getSize().height;
                int x = (dim.width - w) / 2;
                int y = (dim.height - h) / 2;

                f.setLocation(x, y);

                f.setVisible(true);

            }

        };

        SwingUtilities.invokeLater(drawRunnable);

    }

}