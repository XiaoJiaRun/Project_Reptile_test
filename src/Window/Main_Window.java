package Window;

import javax.swing.*;
import java.awt.*;

public class Main_Window {

}



class Panel extends JPanel {   //窗口
        Image img;
        public Panel(Image img){
            this.img = img;
            repaint();
        }
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);
            g.drawImage(img,0 ,0 , getWidth(), getHeight(), this);
        }

}

