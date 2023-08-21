import java.util.Scanner;

public class aaa2 {
    public static void main(String[] args) {

            //创建一个扫描器对象，用于接收键盘数据
            Scanner scanner = new Scanner(System.in);
            //nextLine方式接收字符串(可以接收空格)
            System.out.println("NextLine方式接收:");
            //判断用户还有没有输入字符
            if (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                System.out.println("输入内容：" + str);
            }


            // 凡是属于IO流的类如果不关闭会一直占用资源.要养成好习惯用完就关掉.
            // 就好像你接水完了要关 水龙头一样.很多下载软件或者视频软件如果你不彻底关,
            // 都会自己上传下载从而占用资源,你就会觉得 卡,这一个道理.
            scanner.close();

    }
}
