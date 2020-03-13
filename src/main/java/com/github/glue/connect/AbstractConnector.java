package com.github.glue.connect;

import lombok.extern.slf4j.Slf4j;

import static com.github.glue.GlueConstant.LOG_PRE;

/**
 * @author shizi
 * @since 2020/3/12 下午11:44
 */
@Slf4j
public abstract class AbstractConnector implements Connector {

    @Override
    public void close() {
        getChannel().close().addListener(future -> log.info(LOG_PRE + "closeChannel: close the connection to remote address[{}] result: {}", getAddr(), future.isSuccess()));
    }
}