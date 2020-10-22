package com.example.demo.nio;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/10/22/21:54
 * @Description:
 */
public class SelectorTest {
    public static void main(String[] args) {
        try (Selector selector = Selector.open()) {
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(false);
            SelectionKey key1 = channel.register(selector, SelectionKey.OP_READ);
            while (true) {
                int readyChannels = selector.select();
                if (readyChannels == 0) {
                    continue;
                }
                Set selectedKeys = selector.selectedKeys();
                Iterator keyIterator = selectedKeys.iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = (SelectionKey) keyIterator.next();
                    if (key.isAcceptable()) {
                        // a connection was accepted by a ServerSocketChannel.
                    } else if (key.isConnectable()) {
                        // a connection was established with a remote server.
                    } else if (key.isReadable()) {
                        // a channel is ready for reading
                    } else if (key.isWritable()) {
                        // a channel is ready for writing
                    }
                    keyIterator.remove();
                }
                channel.close();
            }
        } catch (Exception e) {
        }
    }
}
