package Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author JiaLess
 */



public class Search extends JPanel{


    private JLabel label;
    private JTextField jTextField;
    private JButton jButton;

    public JPanel panelSearch() {
        JPanel jPanel = new JPanel();
        jPanel.setPreferredSize(new Dimension(1366,50));
        //jPanel.setBackground(Color.red);
        jPanel.setLayout(new FlowLayout(FlowLayout.LEFT,5,10));

        label = new JLabel("搜索");
        label.setSize(300,200);
        Font labelFont = new Font("仿宋", Font.PLAIN, 30);
        label.setFont(labelFont);

        jTextField = new JTextField();
        jTextField.setColumns(105);
        jTextField.setPreferredSize(new Dimension(900,50));
        Font jTextFieldFont = new Font("仿宋", Font.PLAIN, 22);
        jTextField.setFont(jTextFieldFont);

        jButton = new JButton("确认");
        jButton.setPreferredSize(new Dimension(100,50));
        jButton.setBackground(Color.WHITE);

        jPanel.add(label);
        jPanel.add(jTextField);
        jPanel.add(jButton);

        return jPanel;

    }



    public JLabel getLabel() {
        return label;
    }

    public JTextField getjTextField() {
        return jTextField;
    }

    public JButton getjButton() {
        return jButton;
    }


}
