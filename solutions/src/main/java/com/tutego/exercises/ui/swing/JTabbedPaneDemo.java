package com.tutego.exercises.ui.swing;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

class LanguageTabbedPanel extends JPanel
{
  LanguageTabbedPanel()
  {
    add( new JLabel("Language") );
  }
}

class ColorChooserTabbedPanel extends JPanel
{
  ColorChooserTabbedPanel()
  {
    add( new JLabel("Color") );
  }
}

public class JTabbedPaneDemo
{
  public static void main( String[] args )
  {
    JFrame f = new JFrame();
    
    JTabbedPane tabs = new JTabbedPane();
    tabs.addTab( "Backgroundcolor", new LanguageTabbedPanel() );
    tabs.addTab( "Language", new ColorChooserTabbedPanel() );
    
    f.getContentPane().add( tabs );
    f.pack();
    f.setVisible( true );
  }
}
