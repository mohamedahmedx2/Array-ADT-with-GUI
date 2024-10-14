import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // تشغيل التطبيق في الـ Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            ArrayADTGUI gui = new ArrayADTGUI();
            gui.setVisible(true);  // عرض الواجهة الرسومية
        });
    }
}
