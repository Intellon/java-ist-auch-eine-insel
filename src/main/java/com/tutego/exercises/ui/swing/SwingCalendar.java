package com.tutego.exercises.ui.swing;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class SwingCalendar extends JPanel
{
	static String[] months = { "januar", "februar", "m�rz", "april", "mai", "juni",
			"juli", "august", "september", "oktober", "november", "dezember" };

	public SwingCalendar( int iMonat, int iJahr )
	{
		JTable calendarTable = new JTable(new CalendarTableModel(iMonat,iJahr));

		calendarTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		calendarTable.getTableHeader().setReorderingAllowed(false);
		calendarTable.setDefaultRenderer(Object.class,new CalendarTableCellRenderer());
		calendarTable.getColumnModel().getColumn(0).setMinWidth(25);
		calendarTable.getColumnModel().getColumn(0).setMaxWidth(25);
		calendarTable.getColumnModel().getColumn(1).setMinWidth(30);
		calendarTable.getColumnModel().getColumn(1).setMaxWidth(30);
		calendarTable.getColumnModel().getColumn(2).setPreferredWidth(200);
		calendarTable.getColumnModel().getColumn(3).setMinWidth(25);
		calendarTable.getColumnModel().getColumn(3).setMaxWidth(25);
		calendarTable.getColumnModel().getColumn(4).setMinWidth(30);
		calendarTable.getColumnModel().getColumn(4).setMaxWidth(30);
		calendarTable.getColumnModel().getColumn(5).setPreferredWidth(200);

		JPanel pnlTitel  = new JPanel(new BorderLayout());
		JLabel lblTitel1 = new JLabel(months[iMonat - 1] + " " + iJahr);
		JLabel lblTitel2 = new JLabel("  " + iMonat + " ");
		Font   fntTitel2 = lblTitel2.getFont();
		fntTitel2 = fntTitel2.deriveFont(4f * fntTitel2.getSize2D());
		lblTitel1.setHorizontalAlignment(JLabel.RIGHT);
		lblTitel1.setVerticalAlignment(JLabel.BOTTOM);
		lblTitel1.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		lblTitel2.setFont(fntTitel2);
		pnlTitel.setBackground(Color.WHITE);
		pnlTitel.add(lblTitel1,BorderLayout.CENTER);
		pnlTitel.add(lblTitel2,BorderLayout.EAST);
		
		setLayout(new BorderLayout());
		add(pnlTitel,BorderLayout.NORTH);
		add(calendarTable,BorderLayout.CENTER);
	}
}

