package Grades;


import java.io.IOException;
import java.util.Scanner;

/**
 * @author JiaLess
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("start");
        System.out.println("关键字");
        name = sc.next();
        Verification_code code = new Verification_code(name);
        System.out.println("end");

    }
}
