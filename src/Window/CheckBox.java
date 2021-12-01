package Window;
/*
@author JiaLess
@date 2021/11/28 16:13
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CheckBox {

    private JCheckBox jcb1 = new JCheckBox("复选框1");
    private JCheckBox jcb2 = new JCheckBox("复选框2");
    private JCheckBox jcb3 = new JCheckBox("复选框3");
    //面板
    private JPanel pan = new JPanel();

    public JPanel CheckBox() {

            // 设置组件的排版
            pan.setLayout(new GridLayout(1, 3));
            // 增加组件
            pan.add(this.jcb1);
            pan.add(this.jcb2);
            pan.add(this.jcb3);

            this.pan.setSize(800, 200);
            // 设置可显示
            //this.pan.setVisible(true);
        return pan;

    }
}

