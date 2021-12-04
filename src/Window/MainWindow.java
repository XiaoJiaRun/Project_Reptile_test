package Window;

import Grades.Verification;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author JiaLess
 */

public class MainWindow extends JFrame {

    private String Key = "";
    public static void main(String[] args) {


        JFrame mainFrame = new JFrame("Java爬虫学习");

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1366,768);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));

        Search search = new Search();
        mainFrame.add(search.panelSearch());

        CheckBox checkBox = new CheckBox();
        mainFrame.add(checkBox.CheckBox());

        mainFrame.setVisible(true);

        //按钮触发事件
        String Key = "";
        JButton button = search.getjButton();
        JTextField jTextField = search.getjTextField();

        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                String key = jTextField.getText();

                boolean a = checkBox.getJra1().isSelected();
                boolean b = checkBox.getJra2().isSelected();
                boolean c = checkBox.getJra3().isSelected();

                if(a) {
                    //10
                    Verification verification = new Verification();
                    verification.Loop(key, 1, 10);
                    // 设置按钮显示效果
                    UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
                    // 设置文本显示效果
                    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));

                    JOptionPane.showMessageDialog(null, "下载成功" + verification.getNumber() + "张。");

                    //System.out.println("end");
                }else if(b) {
                    //20
                    Verification verification = new Verification();
                    verification.Loop(key, 1, 20);
                    // 设置按钮显示效果
                    UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
                    // 设置文本显示效果
                    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));

                    JOptionPane.showMessageDialog(null, "下载成功" + verification.getNumber() + "张。");

                    //System.out.println("end");
                }else if(c) {
                    //30
                    Verification verification = new Verification();
                    verification.Loop(key, 1, 50);
                    // 设置按钮显示效果
                    UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
                    // 设置文本显示效果
                    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));

                    JOptionPane.showMessageDialog(null, "下载成功" + verification.getNumber() + "张。");

                    //System.out.println("end");
                }else if(checkBox.getTextFieldStart().equals("") && checkBox.getTextFieldEnd().equals("")) {
                    //start end
                    int start = Integer.valueOf(String.valueOf(checkBox.getTextFieldStart())).intValue();
                    int end = Integer.valueOf(String.valueOf(checkBox.getTextFieldEnd())).intValue();

                    Verification verification = new Verification();
                    verification.Loop(key, start, end);
                    // 设置按钮显示效果
                    UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
                    // 设置文本显示效果
                    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));

                    JOptionPane.showMessageDialog(null, "下载成功" + verification.getNumber() + "张。");

                    //System.out.println("end");
                }else{
                    //第一张
                    Verification verification = new Verification();
                    verification.Loop(key, 1, 1);
                    // 设置按钮显示效果
                    UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
                    // 设置文本显示效果
                    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));

                    JOptionPane.showMessageDialog(null, "下载成功" + verification.getNumber() + "张。");

                    //System.out.println("end");
                }
            }
        });
            /*测试
            Scanner sc = new Scanner(System.in);
            System.out.println("start");
            System.out.println("关键字");
            String name = sc.next();
            try {
                new Verification(name);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("test获取链接错误。");
            }
            System.out.println("end");

            */

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
