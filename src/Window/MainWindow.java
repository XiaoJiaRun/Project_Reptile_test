package Window;

import Grades.Verification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author JiaLess
 */

public class MainWindow extends JFrame {

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("主窗口");

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1366,768);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));

        Search search = new Search();
        mainFrame.add(search.panelSearch());

        mainFrame.setVisible(true);



        //按钮触发事件
        String Key = "";
        JButton button = search.getjButton();
        JTextField jTextField = search.getjTextField();

        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = jTextField.getText();
                System.out.println(key);
                System.out.println("start");
                try {
                    Verification code = new Verification(Key);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    System.out.println("获取链接错误。");
                }
                System.out.println("end");

            }
        });

    }


}



/*打开图片
class Panel extends JPanel {
        Image img;
        public Panel(Image img){
            this.img = img;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);
            g.drawImage(img,0 ,0 , getWidth(), getHeight(), this);
        }

}
*/
