package nettyTest;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/09/04/11:57
 * @Description:
 */
public class NettyServer {
    public static void main(String[] args) throws Exception {
        new NettyServer().start("127.0.0.1", 8081);
    }

    public void start(String host, int port) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //Boss I/O线程池,用于处理客户端连接,连接建立之后交给work I/O处理
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        //Work I/O线程池
        ServerBootstrap server = new ServerBootstrap();
        //启动类
        server.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024).childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast("idleStateHandler", new IdleStateHandler(0, 0, 3));
                pipeline.addLast( new ServerHandler());
            }
        });
        server.childOption(ChannelOption.TCP_NODELAY, true);
        server.childOption(ChannelOption.SO_RCVBUF, 32 * 1024);
        server.childOption(ChannelOption.SO_SNDBUF, 32 * 1024);
        InetSocketAddress addr = new InetSocketAddress(host, port);
        server.bind(addr).sync().channel();
        //重启服务

    }
}
