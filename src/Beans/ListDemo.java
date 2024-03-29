package Beans;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListDemo extends JPanel {
    private JList list;
    private DefaultListModel listModel;
    public String match = null;

    private static final String hireString = "Highlight";
    private JTextField employeeName;

    public ListDemo() {
        super(new BorderLayout());

        listModel = new DefaultListModel();
        listModel.addElement("Test1");
        listModel.addElement("Test2");
        listModel.addElement("Test3");

        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(5);
        list.setCellRenderer(new MyListCellRenderer());
        JScrollPane listScrollPane = new JScrollPane(list);

        JButton hireButton = new JButton(hireString);
        HireListener hireListener = new HireListener(hireButton);
        hireButton.setActionCommand(hireString);
        hireButton.addActionListener(hireListener);
        hireButton.setEnabled(false);

        employeeName = new JTextField(10);
        employeeName.addActionListener(hireListener);
        employeeName.getDocument().addDocumentListener(hireListener);
        listModel.getElementAt(list.getSelectedIndex()).toString();

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,
                                           BoxLayout.LINE_AXIS));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(employeeName);
        buttonPane.add(hireButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);
    }
    class MyListCellRenderer extends JLabel implements ListCellRenderer {
        public MyListCellRenderer() {
            setOpaque(true);
        }
        public Component getListCellRendererComponent(JList paramlist, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            setText(value.toString());
            if (value.toString().equals(match)) {
                setBackground(Color.BLUE);
                SwingWorker worker = new SwingWorker() {
                    @Override
                    public Object doInBackground() {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) { /*Who cares*/ }
                        return null;
                    }
                    @Override
                    public void done() {
                        match = null;
                        list.repaint();
                    }
                };
                worker.execute();
            } else
                setBackground(Color.RED);
            return this;
        }
    }
    class HireListener implements ActionListener, DocumentListener {
        private boolean alreadyEnabled = false;
        private JButton button;
        public HireListener(JButton button) {
            this.button = button;
        }
        public void actionPerformed(ActionEvent e) {
            String name = employeeName.getText();
            if (listModel.contains(name)) {
                match = name;
                list.repaint();
                employeeName.requestFocusInWindow();
                employeeName.selectAll();
                return;
            }
            if (name.equals("")) {
                Toolkit.getDefaultToolkit().beep();
                employeeName.requestFocusInWindow();
                employeeName.selectAll();
                return;
            }
            int index = list.getSelectedIndex();
            if (index == -1)
                index = 0;
            else
                index++;
            listModel.insertElementAt(employeeName.getText(), index);
            employeeName.requestFocusInWindow();
            employeeName.setText("");
            list.setSelectedIndex(index);
            list.ensureIndexIsVisible(index);
        }
        public void insertUpdate(DocumentEvent e) {
            enableButton();
        }
        public void removeUpdate(DocumentEvent e) {
            handleEmptyTextField(e);
        }
        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyTextField(e))
                enableButton();
        }
        private void enableButton() {
            if (!alreadyEnabled)
                button.setEnabled(true);
        }
        private boolean handleEmptyTextField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                button.setEnabled(false);
                alreadyEnabled = false;
                return true;
            }
            return false;
        }
    }
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("ListDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new ListDemo();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });
    }
}
