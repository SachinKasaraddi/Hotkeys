package com.sachin.hotkeys.actions;

import com.github.markusbernhardt.proxy.util.PlatformUtil;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class HotKeys {
    private JTable hotKeyTable;
    private JPanel panel1;

    public JPanel getPanel1() {
        return panel1;
    }

    private void createUIComponents() {
        String[] columnNames = {"Action", "Windows/Linux", "Mac"};
        Object[][] data = {
                {"General", "", ""},
                {"Save all", "⌃ S", "⌘  S"},
                {"Synchronize", "⌃ Alt Y", "⌘  ⌥ Y"},
                {"Maximize/minimize editor", "⌃ ⇧ F12", "⌃ ⌘  F12"},
                {"Add to favorites", "Alt ⇧ F", "⌥ ⇧ F"},
                {"Inspect current file with current profile", "Alt ⇧ I", "⌥ ⇧ I"},
                {"Quick switch scheme", "⌃ ` (backquote)", "⌃ ` (backquote)"},
                {"Open settings dialogue", "⌃ Alt S", "⌘  ,(comma)"},
                {"Open project structure dialog", "⌃ Alt ⇧ S", "⌘  ; (semicolon)"},
                {"Switch between tabs and tool window", "⌃ Tab", "⌃ Tab"},

                {"", "", ""},
                {"Navigating and searching within Studio", "", ""},
                {"Search everything (including code and menus)", "Press ⇧ twice", "Press ⇧ twice"}
                , {"Find", "⌃ F", "⌘  F"}
                , {"Find next", "F3", "⌘  G"}
                , {"Find previous", "⇧ F3", "⌘  ⇧ G"}
                , {"Replace", "⌃ R", "⌘  R"}
                , {"Find action", "⌃ ⇧ A", "⌘  ⇧ A"}
                , {"Search by symbol name", "⌃ Alt ⇧ N", "⌘  ⌥ O"}
                , {"Find class", "⌃ N", "⌘  O"}
                , {"Find file (instead of class)", "⌃ ⇧ N", "⌘  ⇧ O"}
                , {"Find in path", "⌃ ⇧ F", "⌘  ⇧ F"}
                , {"Open file structure pop-up", "⌃ F12", "⌘  F12"}
                , {"Navigate between open editor tabs", "Alt Right Arrow or Left Arrow", "⌃ Right Arrow or ⌃ Left Arrow"}
                , {"Jump to source", "F4 or ⌃ Enter", "F4 or ⌘  Down Arrow"}
                , {"Open current editor tab in new window", "⇧ F4", "⇧ F4"}
                , {"Recently opened files pop-up", "⌃ E", "⌘  E"}
                , {"Recently edited files pop-up", "⌃ ⇧ E", "⌘  ⇧ E"}
                , {"Go to last edit location", "⌃ ⇧ Backspace", "⌘  ⇧ Delete"}
                , {"Close active editor tab", "⌃ F4", "⌘  W"}
                , {"Return to editor window from a tool window", "Esc", "Esc"}
                , {"Hide active or last active tool window", "⇧ Esc", "⇧ Esc"}
                , {"Go to line", "⌃ G", "⌘  L"}
                , {"Open type hierarchy", "⌃ H", "⌃ H"}
                , {"Open method hierarchy", "⌃ ⇧ H", "⌘  ⇧ H"},

                {"", "", ""},
                {"Viewing layouts", "", ""},
                {"Zoom in/out", "⌃ plus or ⌃ minus", "⌘  plus or ⌘  minus"},
                {"Fit to screen", "⌃ 0", "⌘  0"},
                {"Actual size", "⌃ ⇧ 1", "⌘  ⇧ 1"},

                {"", "", ""},
                {"Design tools: Layout Editor", "", ""},
                {"Toggle between Design and Blueprint modes", "B", "B"},
                {"Toggle between Portrait and Landscape modes", "O", "O"},
                {"Toggle devices", "D", "D"},
                {"Force refresh", "R", "R"},
                {"Toggle render errors panel", "E", "E"},
                {"Delete constraints", "Delete or ⌃ click", "Delete or ⌘  click"},
                {"Zoom in", "⌃ plus", "⌘  plus"},
                {"Zoom out", "⌃ minus", "⌘  minus"},
                {"Zoom to fit", "⌃ 0", "⌘  0"},
                {"Pan", "Hold Space click and drag", "Hold Space click and drag"},
                {"Go to XML", "⌃ B", "⌘  B"},
                {"Select all components", "⌃ A", "⌘  A"},
                {"Select multiple components", "⇧ click or ⌃ click", "⇧ click or ⌘  click"},

                {"", "", ""},
                {"Design tools: Navigation Editor", "", ""},
                {"Zoom in", "⌃ plus   ", "⌘  plus"},
                {"Zoom out", "⌃ minus  ", "⌘  minus"},
                {"Zoom to fit", "⌃ 0  ", "⌘  0"},
                {"Pan", "Hold Space click and drag  ", "Hold Space click and drag"},
                {"Go to XML", "⌃ B  ", "⌘  B"},
                {"Toggle render errors panel", "E  ", "E"},
                {"Group into nested graph", "⌃ G  ", "⌘  G"},
                {"Cycle through destinations", "Tab or ⇧ Tab   ", "Tab or ⇧ Tab"},
                {"Select all destinations", "⌃ A  ", "⌘  A"},
                {"Select multiple destinations", "⇧ click or ⌃ click   ", "⇧ click or ⌘  click"},

                {"", "", ""},
                {"Writing code", "", ""},
                {"Generate code", "Alt Insert", "⌘  N"},
                {"Override methods", "⌃ O", "⌃ O"},
                {"Implement methods", "⌃ I", "⌃ I"},
                {"Surround with (if...else / try...catch / etc.)", "⌃ Alt T", "⌘  ⌥ T"},
                {"Delete line at caret", "⌃ Y", "⌘  Delete"},
                {"Collapse/expand current code block", "⌃ minus or ⌃ plus", "⌘  minus or ⌘  plus"},
                {"Collapse/expand all code blocks", "⌃ ⇧ minus or ⌃ ⇧ plus", "⌘  ⇧ minus or ⌘  ⇧ plus"},
                {"Duplicate current line or selection", "⌃ D", "⌘  D"},
                {"Basic code completion", "⌃ Space", "⌃ Space"},
                {"Smart code completion (filters the list of methods and variables by expected type)", "⌃ ⇧ Space", "⌃ ⇧ Space"},
                {"Complete statement", "⌃ ⇧ Enter", "⌘  ⇧ Enter"},
                {"Quick documentation lookup", "⌃ Q", "⌃ J"},
                {"Show parameters for selected method", "⌃ P", "⌘  P"},
                {"Go to declaration (directly)", "⌃ B or ⌃ click", "⌘  B or ⌘  click"},
                {"Go to implementations", "⌃ Alt B", "⌘  ⌥ B"},
                {"Go to super-method/super-class", "⌃ U", "⌘  U"},
                {"Open quick definition lookup", "⌃ ⇧ I", "⌘  Y"},
                {"Toggle project tool window visibility", "Alt 1", "⌘  1"},
                {"Toggle bookmark", "F11", "F3"},
                {"Toggle bookmark with mnemonic", "⌃ F11", "⌥ F3"},
                {"Comment/uncomment with line comment", "⌃ /", "⌘  /"},
                {"Comment/uncomment with block comment", "⌃ ⇧ /", "⌘  ⇧ /"},
                {"Select successively increasing code blocks", "⌃ W", "⌥ Up"},
                {"Decrease current selection to previous state", "⌃ ⇧ W", "⌥ Down"},
                {"Move to code block start", "⌃ [", "⌥ ⌘  ["},
                {"Move to code block end", "⌃ ]", "⌥ ⌘  ]"},
                {"Select to the code block start", "⌃ ⇧ [", "⌥ ⌘  ⇧ ["},
                {"Select to the code block end", "⌃ ⇧ ]", "⌥ ⌘  ⇧ ]"},
                {"Delete to end of word", "⌃ Delete", "⌥ Delete"},
                {"Delete to start of word", "⌃ Backspace", "⌥ Delete"},
                {"Optimize imports", "⌃ Alt O", "⌃ ⌥ O"},
                {"Project quick fix (show intention actions and quick fixes)", "Alt Enter", "⌥ Enter"},
                {"Reformat code", "⌃ Alt L", "⌘  ⌥ L"},
                {"Auto-indent lines", "⌃ Alt I", "⌃ ⌥ I"},
                {"Indent/unindent lines", "Tab or ⇧ Tab", "Tab or ⇧ Tab"},
                {"Smart line join", "⌃ ⇧ J", "⌃ ⇧ J"},
                {"Smart line split", "⌃ Enter", "⌘  Enter"},
                {"Start new line", "⇧ Enter", "⇧ Enter"},
                {"Next/previous highlighted error", "F2 or ⇧ F2", "F2 or ⇧ F2"},

                {"", "", ""},
                {"Build and run", "", ""},
                {"Build", "⌃ F9", "⌘  F9"},
                {"Build and run", "⇧ F10", "⌃ R"},
                {"Apply Changes and Restart Activity", "⌃ F10", "⌃ ⌘  R"},
                {"Apply Code Changes", "⌃ Alt F10", "⌃ ⇧` ⌘  R"},


                {"", "", ""},
                {"Debugging", "", ""},
                {"Debug", "⇧ F9l", "⌃ D"},
                {"Step over", "F8l", "F8"},
                {"Step into", "F7l", "F7"},
                {"Smart step into", "⇧ F7l", "⇧ F7"},
                {"Step out", "⇧ F8l", "⇧ F8"},
                {"Run to cursor", "Alt F9l", "⌥ F9"},
                {"Evaluate expression", "Alt F8l", "⌥ F8"},
                {"Resume program", "F9l", "⌘  ⌥ R"},
                {"Toggle breakpoint", "⌃ F8l", "⌘  F8"},
                {"View breakpoints", "⌃ ⇧ F8l", "⌘  ⇧ F8"},

                {"", "", ""},
                {"Refactoring", "", ""},
                {"Copy", "F5", "F5"},
                {"Move", "F6", "F6"},
                {"Safe delete", "Alt Delete", "⌘  Delete"},
                {"Rename", "⇧ F6", "⇧ F6"},
                {"Change signature", "⌃ F6", "⌘  F6"},
                {"Inline", "⌃ Alt N", "⌘  ⌥ N"},
                {"Extract method", "⌃ Alt M", "⌘  ⌥ M"},
                {"Extract variable", "⌃ Alt V", "⌘  ⌥ V"},
                {"Extract field", "⌃ Alt F", "⌘  ⌥ F"},
                {"Extract constant", "⌃ Alt C", "⌘  ⌥ C"},
                {"Extract parameter", "⌃ Alt P", "⌘  ⌥ P"},

                {"", "", ""},
                {"Version control / local history", "", ""},
                {"Commit project to VCS", "⌃ K", "⌘  K"},
                {"Update project from VCS", "⌃ T", "⌘  T"},
                {"View recent changes", "Alt ⇧ C", "⌥ ⇧ C"},
                {"", "", ""}

        };
        hotKeyTable = new JTable(data, columnNames);
        hotKeyTable.setFillsViewportHeight(true);
        hotKeyTable.setDefaultRenderer(Object.class, new CustomizeHeader());
        hotKeyTable.setModel(new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        hotKeyTable.setShowVerticalLines(true);
        hotKeyTable.setRowHeight(hotKeyTable.getRowHeight() + 20);
        hideWindowsOrMacOsColumn(PlatformUtil.getCurrentPlattform().equals(PlatformUtil.Platform.MAC_OS));
    }

    private void hideWindowsOrMacOsColumn(boolean isMacOs) {
        int columnIndex = isMacOs ? 1 : 2;
        hotKeyTable.getColumnModel().removeColumn(hotKeyTable.getColumnModel().getColumn(columnIndex));
        hotKeyTable.getColumnModel().getColumn(columnIndex).setPreferredWidth(5);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        hotKeyTable.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
    }
}
