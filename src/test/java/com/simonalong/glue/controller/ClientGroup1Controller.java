package com.simonalong.glue.controller;

import com.simonalong.glue.NettyErrorResponse;
import com.simonalong.glue.annotation.CommandMapping;
import com.simonalong.glue.annotation.GlueController;

/**
 * @author shizi
 * @since 2020/3/4 下午2:22
 */
@GlueController("group1")
public class ClientGroup1Controller {

    /**
     * 正常返回
     */
    @CommandMapping(request = "getDataRsp")
    public void getDataRsp(QueryRsp req) {
        System.out.println("好的，收到" + req.toString());
    }

    /**
     * 异常返回
     * 注意：异常返回类型，这里指定类型{@link NettyErrorResponse}
     */
    @CommandMapping(request = "getInfoErr")
    public void queryErr(NettyErrorResponse errorResponse) {
        System.out.println("好的，收到" + errorResponse.toString());
    }

    /**
     * 收到服务端信息
     */
    @CommandMapping(request = "rsvServer")
    public void rsvServer(ServerSenderReq serverSenderReq) {
        System.out.println("收到服务端信息：" + serverSenderReq.toString());
    }
}
