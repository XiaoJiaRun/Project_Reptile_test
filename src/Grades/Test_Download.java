package Grades;

import org.junit.Test;
import java.io.IOException;

public class Test_Download {
    @Test
    public void Test() {
        String str = "https://img2.baidu.com/it/u=2095658351,1467955612&fm=26&fmt=auto";
        try {
            Download down = new Download(str, 9999);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Test.down出错了");
        }

    }
}
