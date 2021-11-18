package Grades;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verification_code {
    public Verification_code() throws IOException {

        String strurl="https://www.tooopen.com/tag/5b6be7eeebc8b20da80a4f04.aspx";
        String Login_html="";
        String regStr="https://img08.tooopen.com/.......................................";// 正则表达式\"[(https)].+?\"

        try {
            URL url=new URL(strurl);
            URLConnection conn=url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36");//伪装连接
            //Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36
            InputStream is=conn.getInputStream();

//                FileOutputStream fos=new FileOutputStream("html.txt"); //下载源码
//                byte[] buffer =new byte[1000000];
//                int len;
//                while((len=is.read(buffer))!=-1){
//                    fos.write(buffer,0,len);
//                }

            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String line=null;
            while((line=br.readLine())!=null){
                Login_html+=line;
            }
            //System.out.println(Login_html);输出源码


            Pattern pattern=Pattern.compile(regStr);
            Matcher matcher=pattern.matcher(Login_html);
            int z = 0;
            while(matcher.find()) {
                if (z == 10) {
                    break;
                }
                System.out.println(matcher.group());  //图片链接
                new Download(matcher.group(), (int)(1+Math.random()*(9999-1000+1)));
                z++;

            }

            br.close();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }


}

/*
class Panel extends JPanel{   //窗口
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
*/
