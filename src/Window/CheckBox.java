package Window;
/*
@author JiaLess
@date 2021/11/28 16:13
*/


import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CheckBox {

    private ButtonGroup group= new ButtonGroup();
    private JRadioButton jra1 = new JRadioButton("前10页");
    private JRadioButton jra2 = new JRadioButton("前30页");
    private JRadioButton jra3 = new JRadioButton("前50页");
    private JTextField textFieldStart = new JTextField("");
    private JTextField textFieldEnd = new JTextField("");

    public ButtonGroup getGroup() {
        return group;
    }

    public JTextField getTextFieldStart() {
        return textFieldStart;
    }

    public JTextField getTextFieldEnd() {
        return textFieldEnd;
    }

    public JRadioButton getJra1() {
        return jra1;
    }

    public JRadioButton getJra2() {
        return jra2;
    }

    public JRadioButton getJra3() {
        return jra3;
    }

    //面板
    private JPanel pan = new JPanel();

    private JLabel pan1 = new JLabel("从第");
    private JLabel pan2 = new JLabel("页，到");
    private JLabel pan3 = new JLabel("页。");

    private JLabel pan4 = new JLabel("                                          ");
    private JLabel pan5 = new JLabel("爬虫本身不违法，但请勿恶意使用，仅供学习使用。");

    public JPanel CheckBox() {

        // 设置组件的排版
        pan.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
        // 增加组件

        this.jra1.setSize(60,60);
        this.jra2.setSize(60,60);
        this.jra3.setSize(60,60);

        Font labelFont = new Font("宋体", Font.PLAIN, 20);
        Font labelFont2 = new Font("楷体", Font.PLAIN, 30);
        pan5.setFont(labelFont2);

        jra1.setFont(labelFont);
        jra2.setFont(labelFont);
        jra3.setFont(labelFont);


        textFieldStart.setPreferredSize(new Dimension(50,30));
        textFieldEnd.setPreferredSize(new Dimension(50,30));


        pan.setPreferredSize(new Dimension(1366,200));

        // 设置可显示
        //this.pan.setVisible(true);
        group.add(this.jra1);
        group.add(this.jra2);
        group.add(this.jra3);

        pan.add(this.jra1);
        pan.add(this.jra2);
        pan.add(this.jra3);
        pan.add(pan1);
        pan.add(this.textFieldStart);
        pan.add(pan2);
        pan.add(this.textFieldEnd);
        pan.add(pan3);
        pan.add(pan4);
        pan.add(pan5);

        return pan;

    }
}

