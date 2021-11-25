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
    public Verification_code(String name) throws IOException {

        String strurl= "https://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fm=result&fr=&sf=1&fmq=1637850740341_R&pv=&ic=&nc=1&z=&hd=&latest=&copyright=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&dyTabStr=MCwzLDEsNiw0LDIsNSw3LDgsOQ==&ie=utf-8&ctd=1637850740342^00_308X929&sid=&word=" + name;
        String Login_html="";
        // 正则表达式\"[(https)].+?\
        String regStr="https://img1.baidu.com/it/u=[0-9]*,[0-9]*&fm=26&fmt=auto";
        //http://([w-]+.)+[w-]+(/[w- ./?%&=]*)?
        //https://img0.baidu.com/it/u=([w-]+.)+[w-]+(/[w- ./?%&=]*)?
        //https://img1.baidu.com/it/u=515667589,262650834&fm=26&fmt=auto

        try {
            URL url=new URL(strurl);
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            //conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36");
            //Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36

            //请求头 很重要
            conn.setRequestProperty("accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
            //源码未知错误会乱码
            //conn.setRequestProperty("accept-encoding","gzip, deflate, br");
            conn.setRequestProperty("accept-language","zh-CN,zh;q=0.9");
            conn.setRequestProperty("cache-control","max-age=0");
            conn.setRequestProperty("connection","keep-alive");
            conn.setRequestProperty("sec-ch-ua","\"Google Chrome\";v=\"95\", \"Chromium\";v=\"95\", \";Not A Brand\";v=\"99\"");
            conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36");

            conn.connect();


            InputStream is=conn.getInputStream();
/*           //下载源码
            FileOutputStream fos=new FileOutputStream("html.txt");
            byte[] buffer =new byte[1000000];
            int len;
            while((len = is.read(buffer)) != -1) {
                fos.write(buffer,0,len);
            }
  */

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while((line = br.readLine())!= null) {
                Login_html += line;
            }
            //输出源码
            //System.out.println(Login_html);


            Pattern pattern = Pattern.compile(regStr);
            Matcher matcher = pattern.matcher(Login_html);
            //System.out.println("正则表达式后的源码" + matcher);
            int z = 0;
            while(matcher.find()) {
                if (z == 30 ) {
                    break;
                }
                //图片链接
                System.out.println(matcher.group());
                //批量
                //(int)(1+Math.random()*(9999-1000+1))) 随机数
                new Download(matcher.group(), z, name);
                z++;

            }

            br.close();
        } catch (Exception e) {
            System.out.println("爬取源码被拦截或发生未知错误");
            e.printStackTrace();
        }

    }


}

