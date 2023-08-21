package ioTest;

import java.io.*;

/**
 * lo流记录
 * 字节流：以Stream结尾的用于读写任何类型的数据，如图像，音频，视频等
 * 字符流：字符流主要用于处理文本数据
 *缓冲流（Buffered开头的：BufferedInputStream）在读写操作中添加了缓冲区，可以提高IO操作的效率。缓冲区在读取时一次性读取多个字节到内存，或在写入时先将多个字节写入缓冲区，然后一次性写入文件
 *数据流（Data开头的：DataInputStream ）用于读写Java基本数据类型的数据（如int, float, long等）以及String类型的数据
 *对象流（ObjectInputStream/ObjectOutputStream）用于读取或写入对象。这些对象可以是任何实现了 Serializable 接口的对象、、只对对象的非静态数据成员进行序列化操作，静态数据成员属于类级别的，所以不需要序列化
 *打印流（PrintStream / PrintWriter）主要用于创建格式化的输出，而不是原始的字节。这种类型的流非常适合打印输出，或者写入文本文件。
 *
 */
public class IoWei {

    /**
     * 简单的文件复制粘贴
     * @param readFileUrl   要复制的文件路径 如：C:\\Users\\xxx.txt
     * @param readFileName  要复制的文件名称
     * @param writeFileUrl  要粘贴的文件路径
     * @param writeFileName 要粘贴的文件名称
     * @throws IOException
     */
    public void copyAndPaste(String readFileUrl,String readFileName,String writeFileUrl,String writeFileName){
      try {
          BufferedInputStream bis = new BufferedInputStream(new FileInputStream(readFileUrl+"\\"+readFileName));
          BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(writeFileUrl+"\\"+writeFileName));

            int read = 0;
            while((read = bis.read()) != -1){
                bos.write(read);
            }
          bis.close();
          bos.close();
      }catch (IOException e){
        e.printStackTrace();
      }
  }



}
