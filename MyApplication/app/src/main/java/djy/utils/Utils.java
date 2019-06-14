package djy.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/7/16 0016.
 */
public class Utils {

    public static  String getTextFromStream(InputStream is){
       byte[] b = new byte[1024];
        int len = 0;
        //创建字节数组输出流，读取输入流的文本数据时，同时把数据写入数组输出流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            while((len = is.read(b)) != -1){
                bos.write(b,0,len);
            }
            //把字节数组输出流里的数据转换成字节数组
            String text =new String (bos.toByteArray());
            return text;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
