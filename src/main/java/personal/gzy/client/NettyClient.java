package personal.gzy.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName NettyClient
 * @Description TODO netty客户端
 * @Author gzy
 * @Date 2019/2/21 10:51
 * @Version
 **/
public class NettyClient {
    private static final int PORT = 8000;
    private static final String HOST = "localhost";
    private static final int MAX_RETRY = 5;

    public static void main(String[] args) {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                .group(workerGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE,true)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS,5000)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ClientHandler());
                    }
                });
        connect(bootstrap,HOST,PORT,MAX_RETRY);
    }

    /**
     * 每隔2幂次方重连服务端 ，最多重连5此
     * @param bootstrap
     * @param host
     * @param port
     * @param retry
     */
    private static void connect(Bootstrap bootstrap, String host, int port, int retry) {
        bootstrap.connect(host, port).addListener(future -> {
           if(future.isSuccess()){
               System.out.println("连接成功...");
           }else if(retry == 0){
               System.out.println("超过重试次数...");
               System.exit(0);
           }else{
               int order = (MAX_RETRY - retry)+1;
               int delay = 1<<order;
               System.err.println(new Date() + ": 连接失败，第" + order + "次重连……");
               bootstrap.config().group().schedule(
                       () -> connect(bootstrap, host, port,retry-1),
                       delay, TimeUnit.SECONDS);
           }
        });
    }
}
