package nettyTest;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/11/04/11:02
 * @Description:
 */
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/07/28/11:10
 * @Description:
 */
public class TcpClient {
    private static String ip;
    private static int port;
    public static Channel channel;
    public static void init() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE,true);
            bootstrap.handler(new ChannelInitializer() {
                @Override
                protected void initChannel(Channel ch) throws Exception {
                    ch.pipeline().addLast("logging",new LoggingHandler("DEBUG"));
                    ch.pipeline().addLast(new ClientHandler());
                }
            });
            bootstrap.remoteAddress(ip,port);
            ChannelFuture future = bootstrap.connect().sync();
            channel = future.channel();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully().sync();
        }
    }

    public static void setTcpClient(String ip, int port) {
        TcpClient.ip = ip;
        TcpClient.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        TcpClient.setTcpClient("127.0.0.1",8081);
        TcpClient.init();
    }
}

