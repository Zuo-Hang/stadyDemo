package nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/10/22/18:25
 * @Description:
 */
public class ChannelTest {
    public static void main(String[] args) {
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("NioTest/src/main/resources/nio-data.txt", "rw");
            FileChannel inChannel = aFile.getChannel();
            //create buffer with capacity of 48 bytes
            ByteBuffer buf = ByteBuffer.allocate(48);
            //read into buffer.
            int bytesRead = inChannel.read(buf);
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                //make buffer ready for read
                buf.flip();
                while(buf.hasRemaining()){
                    // read 1 byte at a time
                    System.out.print((char) buf.get());
                }
                //make buffer ready for writing
                buf.clear();
                bytesRead = inChannel.read(buf);
                aFile.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
