
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArrayADTGUI extends JFrame {
    private Array array;  // المصفوفة الأساسية
    private JTextArea displayArea;
    private JTextField inputField, indexField;
    private JButton fillButton, appendButton, searchButton, insertButton, deleteButton;

    public ArrayADTGUI() {
        array = new Array(5);  // حجم افتراضي 5

        // إعداد النافذة الرئيسية
        setTitle("Array ADT GUI");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // لوحة الإدخال
        JPanel inputPanel = new JPanel();
        inputField = new JTextField(5);
        indexField = new JTextField(5);

        fillButton = new JButton("Fill");
        appendButton = new JButton("Append");
        searchButton = new JButton("Search");
        insertButton = new JButton("Insert");
        deleteButton = new JButton("Delete");

        inputPanel.add(new JLabel("Value:"));
        inputPanel.add(inputField);
        inputPanel.add(new JLabel("Index:"));
        inputPanel.add(indexField);
        inputPanel.add(fillButton);
        inputPanel.add(appendButton);
        inputPanel.add(searchButton);
        inputPanel.add(insertButton);
        inputPanel.add(deleteButton);
        add(inputPanel, BorderLayout.NORTH);

        // منطقة العرض
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // ربط الأزرار بأحداثها
        fillButton.addActionListener(new FillAction());
        appendButton.addActionListener(new AppendAction());
        searchButton.addActionListener(new SearchAction());
        insertButton.addActionListener(new InsertAction());
        deleteButton.addActionListener(new DeleteAction());
    }

    // حدث تعبئة المصفوفة
    private class FillAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            array.fill();
            updateDisplay();
        }
    }

    // حدث الإضافة في نهاية المصفوفة
    private class AppendAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int value = Integer.parseInt(inputField.getText());
                array.append(value);
                updateDisplay();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ArrayADTGUI.this, "Invalid input. Please enter a number.");
            }
        }
    }

    // حدث البحث في المصفوفة
    private class SearchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int key = Integer.parseInt(inputField.getText());
                int index = array.search(key);
                if (index != -1) {
                    JOptionPane.showMessageDialog(ArrayADTGUI.this, "Item found at index: " + index);
                } else {
                    JOptionPane.showMessageDialog(ArrayADTGUI.this, "Item not found.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ArrayADTGUI.this, "Invalid input. Please enter a number.");
            }
        }
    }

    // حدث الإدراج في المصفوفة
    private class InsertAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int index = Integer.parseInt(indexField.getText());
                int value = Integer.parseInt(inputField.getText());
                array.insert(index, value);
                updateDisplay();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ArrayADTGUI.this, "Invalid input. Please enter a number.");
            }
        }
    }

    // حدث الحذف من المصفوفة
    private class DeleteAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int index = Integer.parseInt(indexField.getText());
                array.delete(index);
                updateDisplay();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ArrayADTGUI.this, "Invalid input. Please enter a number.");
            }
        }
    }

    // تحديث منطقة العرض
    private void updateDisplay() {
        displayArea.setText("Array: " + array.toString());
    }
}
