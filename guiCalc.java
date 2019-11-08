
import javax.swing.*;

public class guiCalc {

    
    /** 
     * @return 
     */
    public guiCalc() {
        JFrame window = new JFrame("Calculator");
        window.setSize(416, 539);
        window.add(new CalcPanel());
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new guiCalc());
    
    }
}
