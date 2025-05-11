package GUIpanels;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

//A helper class to create something similar to JComoboBox but with multiple selections available as you press Control
public class MultiSelectionList extends JScrollPane {
    private final JList<String> list;
    private final int maxSelections;

    public MultiSelectionList(String[] options, int maxSelections) {
        this.maxSelections = maxSelections;

        DefaultListModel<String> model = new DefaultListModel<>();
        for (String option : options) {
            model.addElement(option);
        }

        list = new JList<>(model);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setVisibleRowCount(Math.min(options.length, 5));

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && list.getSelectedIndices().length > maxSelections) {
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(
                                list,
                                "You can select up to " + maxSelections + " items only!",
                                "Selection Limit",
                                JOptionPane.WARNING_MESSAGE
                        );
                        list.clearSelection();
                    });
                }
            }
        });

        this.setViewportView(list);
        this.setPreferredSize(new Dimension(200, 80));
    }

    public java.util.List<String> getSelectedValues() {
        return list.getSelectedValuesList();
    }
}
