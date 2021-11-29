package Grades;

import org.junit.Test;
import java.io.IOException;
import java.util.Scanner;

public class Test_Download {
    @Test
    public void Test() {
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("start");
        System.out.println("关键字");
        name = sc.next();
        try {
            Verification code = new Verification(name);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("test获取链接错误。");
        }
        System.out.println("end");

    }
}
