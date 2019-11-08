
import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private enum Action {
        plus ("+"),
        minus ("-"),
        multi ("*"),
        div ("/"),
        def ("_");

        private String title;

        Action(String title) {
            if (title.equals("+") || title.equals("-") || title.equals("*") || title.equals("/") || title.equals("_")) this.title = title;
            else this.title = "_";
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return title;
        }
    }
    private class ActionButton{
        private JButton button;
        private ActionListener listener;

        public ActionButton() {
            listener = (ActionEvent e) -> {
                calculator.setNum(bufferNum);
                bufferNum = 0;
                output.setText("");
            };
            button = new JButton("");
        }

        public JButton getButton(Action action) {
            button.setText(action.getTitle());

            switch (action) {
                case plus:
                    button.setBounds(300, 100, 100, 100);
                    button.addActionListener((ActionEvent e) -> {
                        currentAction = Action.plus;
                    });
                    break;
                case minus:
                    button.setBounds(300, 200, 100, 100);
                    button.addActionListener((ActionEvent e) -> {
                        currentAction = Action.minus;
                    });
                    break;
                case multi:
                    button.setBounds(300, 300, 100, 100);
                    button.addActionListener((ActionEvent e) -> {
                        currentAction = Action.multi;
                    });
                    break;
                case div:
                    button.setBounds(300, 400, 100, 100);
                    button.addActionListener((ActionEvent e) -> {
                        currentAction = Action.div;
                    });
                    break;
                default:
                    throw (new ExceptionInInitializerError(action + " is not a valid action like plus or minus"));
            }
            button.addActionListener(listener);
            return button;
        }
    }

    private Action currentAction;
    private JButton[] numbers;
    private JTextField output;
    private double bufferNum;
    private Calculator calculator;


    private void setNumbers() {
        ActionListener listener = (ActionEvent e) -> {
            JButton button = (JButton)e.getSource();

            if (!output.getText().contains(".") || !button.getText().equals(".")) {
                if (button.getText().equals(".") && output.getText().length() == 0) output.setText("0");
                if (output.getText().equals("NaN")) output.setText("");
                output.setText(output.getText() + button.getText());
                bufferNum = Double.parseDouble(output.getText());
            }
        };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                numbers[j*3 + i + 1] = new JButton((j*3 + i + 1) + "");
                numbers[j*3 + i + 1].setBounds(i*100, j*100+100, 100, 100);
                numbers[j*3 + i + 1].addActionListener(listener);
                add(numbers[j*3 + i + 1]);
            }
        }
        numbers[0] = new JButton("0");
        numbers[0].setBounds(100, 400, 100, 100);
        numbers[0].addActionListener(listener);
        add(numbers[0]);

        JButton dot = new JButton(".");
        dot.setBounds(0, 400, 100, 100);
        dot.addActionListener(listener);
        add(dot);
    }

    private void setTextField() {
        output = new JTextField();
        output.setBounds(0, 0, 300, 100);
        output.setEditable(false);
        add(output);
    }

    private void setActionButtons(){
        JButton equal = new JButton("=");
        equal.setBounds(200, 400, 100, 100);
        equal.addActionListener((ActionEvent e) -> {
            switch (currentAction) {
                case plus:
                    bufferNum = calculator.plus(bufferNum);
                    break;
                case minus:
                    bufferNum = calculator.minus(bufferNum);
                    break;
                case multi: bufferNum = calculator.multi(bufferNum);
                    break;
                case div:
                    bufferNum = calculator.div(bufferNum);
                    break;
                default:
                    break;
            }
            currentAction = Action.def;
            output.setText(bufferNum + "");
        });
        add(equal);

        JButton backsapce = new JButton("<");
        backsapce.setBounds(300, 0, 100, 100);
        backsapce.addActionListener((ActionEvent e) -> {
            try {
                if (output.getText().length() > 0)
                {
                    output.setText(output.getText(0, output.getText().length()-1));
                    if (output.getText().length() > 0) bufferNum = Double.parseDouble(output.getText());
                    else bufferNum = 0;
                } else bufferNum = 0;
            } catch (BadLocationException e1) {
                e1.printStackTrace();
            }
        });
        add(backsapce);

        JButton plus = new ActionButton().getButton(Action.plus);
        add(plus);

        JButton minus = new ActionButton().getButton(Action.minus);
        add(minus);

        JButton mult = new ActionButton().getButton(Action.multi);
        add(mult);

        JButton div = new ActionButton().getButton(Action.div);
        add(div);
    }

    
    /** 
     * @return 
     */
    public CalcPanel() {
        setLayout(null);
        numbers = new JButton[10];
        calculator = new Calculator();
        bufferNum = 0;
        currentAction = Action.def;

        setTextField();
        setNumbers();
        setActionButtons();
    }
}
