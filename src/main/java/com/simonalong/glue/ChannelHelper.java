package com.simonalong.glue;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * @author shizi
 * @since 2020/3/3 下午3:02
 */
@Slf4j
@UtilityClass
public class ChannelHelper {

    /**
     * 解析对端地址
     *
     * @param channel channel
     * @return ip地址
     */
    public String parseChannelRemoteAddress(final Channel channel) {
        if (null == channel) {
            return "";
        }
        SocketAddress remote = channel.remoteAddress();
        final String addr = remote != null ? remote.toString() : "";

        if (addr.length() > 0) {
            int index = addr.lastIndexOf("/");
            if (index >= 0) {
                return addr.substring(index + 1);
            }

            return addr;
        }

        return "";
    }

    public void closeChannel(Channel channel) {
        final String addressRemote = parseChannelRemoteAddress(channel);
        channel.close()
            .addListener((ChannelFutureListener) future -> log.info(GlueConstant.LOG_PRE + "closeChannel: close the connection to remote address[{}] result: {}", addressRemote, future.isSuccess()));
    }

    public SocketAddress string2SocketAddress(final String addr) {
        int split = addr.lastIndexOf(":");
        String host = addr.substring(0, split);
        String port = addr.substring(split + 1);
        return new InetSocketAddress(host, Integer.parseInt(port));
    }
}
