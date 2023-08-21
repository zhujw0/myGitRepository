package ioTest;

import java.io.*;

/**
 * io流
 * 硬盘文件：File开头
 * 内存：数组，字符串
 * 键盘：System.in
 * 网络：Socket
 */
public class IoTest {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\io流测试.txt");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\io流测试2.txt");
        int read = 0;
        while((read = fis.read()) != -1){
            System.out.print(read);
            fos.write(read);
        }
        fis.close();
        fos.close();

// 创建转换流对象,编码格式指定为utf-8
//        InputStreamReader isr = new InputStreamReader(fileInputStream, "utf-8");
//
//        // 读取数据
//        char[] buf = new char[1024];
//        int len = 0;
//        while((len = isr.read(buf)) != -1) {
//            System.out.println(new String(buf, 0, len));
//        }
//        // 关闭流：此处只需关闭转换流即可！
//        isr.close();


    }











}
