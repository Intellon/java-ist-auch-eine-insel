package com.tutego.exercises.ui.swing;

import java.awt.*;
import java.io.File;

import javax.swing.*;

public class FileCellRenderer implements ListCellRenderer<File>
{
  private Color lightBlue = new Color(240,240,255);
  
  private JPanel panel;
  private JLabel indexLabel;
  private JLabel nameLabel;
  private JLabel sizeLabel;

  public FileCellRenderer()
  {
    panel  = new JPanel(new BorderLayout(5,0));
    indexLabel = new JLabel();
    indexLabel.setHorizontalAlignment(JLabel.RIGHT);
    indexLabel.setPreferredSize(new Dimension(30,10));
    nameLabel  = new JLabel();
    sizeLabel  = new JLabel();
    panel.add(indexLabel,BorderLayout.WEST);
    panel.add(nameLabel,BorderLayout.CENTER);
    panel.add(sizeLabel,BorderLayout.EAST);
  }

  @Override
  public Component getListCellRendererComponent(JList<? extends File> list, File value, int index, boolean isSelected, boolean cellHasFocus)
  {
    File file = (File)value;
    indexLabel.setText("" + (index + 1));
    nameLabel.setText(file.getName());
    sizeLabel.setText("" + file.length());
    
    Color foreground = Color.BLACK;
    Color background = Color.WHITE;
    
    if ( file.getName().endsWith(".class") )
      foreground = Color.red;
    
    if ( (index & 1) == 0 )
      background = lightBlue;

    if ( isSelected )
    {
      background = foreground;
      foreground = Color.white;
    }
    
    indexLabel.setForeground( foreground );
    nameLabel.setForeground( foreground );
    sizeLabel.setForeground( foreground );
    panel.setBackground( background );
    
    return panel;
  }
}