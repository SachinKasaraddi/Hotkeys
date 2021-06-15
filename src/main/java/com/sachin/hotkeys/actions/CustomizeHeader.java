package com.sachin.hotkeys.actions;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomizeHeader extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table,
                                                   Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel parent = (JLabel) super.getTableCellRendererComponent(table,
                value, isSelected, hasFocus, row, column);
        switch (row) {
            case 0:
            case 11:
            case 36:
            case 41:
            case 56:
            case 68:
            case 109:
            case 115:
            case 127:
            case 140:
                parent.setFont(parent.getFont().deriveFont(Font.BOLD));
        }
        return parent;
    }
}
