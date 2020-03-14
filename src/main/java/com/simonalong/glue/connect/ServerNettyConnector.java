package com.simonalong.glue.connect;

import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author shizi
 * @since 2020/3/12 下午9:40
 */
@Slf4j
public class ServerNettyConnector extends AbstractConnectSender {

    private Channel channel;
    private String addr;

    public ServerNettyConnector(Channel channel, String addr) {
        this.channel = channel;
        this.addr = addr;
    }

    @Override
    public Channel getChannel() {
        return channel;
    }

    @Override
    public String getAddr() {
        return addr;
    }

    @Override
    public boolean isOK() {
        return channel != null && channel.isActive();
    }
}
