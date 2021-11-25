package Grades;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Download {

    public   Download(String str, int k, String name) throws IOException {
        String Url=str;
        int responsecode = 0;
        URL url=new URL(Url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        //伪装连接
        //conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36)")
        //Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36
        //HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();

        conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36");

        //获取服务器响应代码
        responsecode= ((HttpURLConnection) conn).getResponseCode();
        //验证
        if(responsecode == 200){
            //创建文件夹
            File saveFile = new File("Download/"+name+"/",name + k + ".jpg");
            if(!saveFile.getParentFile().exists()){
                saveFile.getParentFile().mkdirs();
            }
            if(!saveFile.exists()){
                saveFile.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(saveFile);
            InputStream is=conn.getInputStream();
            byte[] buffer =new byte[1000000];
            int len;
            while((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            is.close();
            fos.close();
            System.out.println("第" + k + "张成功。");
        }else{
            System.out.println("第" + k + "张出错。");
        }

/*      //打开窗口
        urlConnection.disconnect();
        File file = new File("two.jpg");
        BufferedImage bufImg = null;
        bufImg = ImageIO.read(file);

        Panel pane = new Panel(bufImg);
        JFramxe frame = new JFrame();

        frame.add(pane);
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
*/
    }
}

