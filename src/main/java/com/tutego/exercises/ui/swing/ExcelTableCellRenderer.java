package com.tutego.exercises.ui.swing;
/*
package com.tutego.insel.solutions.swing;

import java.awt.Component;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ExcelTableCellRenderer extends JLabel implements TableCellRenderer
{
	private static final JLabel emplyLabel = new JLabel();
	private org.nfunk.jep.JEP jep = new org.nfunk.jep.JEP();

	public Component getTableCellRendererComponent(
		JTable table,
		Object value,
		boolean isSelected,
		boolean hasFocus,
		int row,
		int column)
	{
		if ( value == null )
			return emplyLabel;

		String text = value.toString();

		if ( text.startsWith("=") )
		{
			text = text.substring( 1 );
			
			if ( text.equalsIgnoreCase("heute()") )
				text = new Date().toString();
			else
			{
				jep.parseExpression( text );
				if ( jep.hasError() )
					text = "######";
				else
					text = new Double( jep.getValue() ).toString();
			}
		}

		setText( text );

		return this;
	}
}
*/