/**
 * Copyright 2020 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.thierrysquirrel.websocket.netty.server.handler;

import com.github.thierrysquirrel.websocket.core.template.WebsocketChannelTemplate;
import com.github.thierrysquirrel.websocket.core.template.WebsocketRouteTemplate;
import com.github.thierrysquirrel.websocket.netty.server.handler.core.factory.execution.WebsocketServerHandlerFactoryExecution;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.Getter;
import lombok.Setter;

/**
 * ClassName: WebsocketServerHandler
 * Description:
 * date: 2020/8/17 21:36
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Getter
@Setter
public class WebsocketServerHandler extends SimpleChannelInboundHandler<WebSocketFrame> {
    private WebsocketRouteTemplate websocketRouteTemplate;
    private WebsocketChannelTemplate websocketChannelTemplate;

    public WebsocketServerHandler(WebsocketRouteTemplate websocketRouteTemplate, WebsocketChannelTemplate websocketChannelTemplate) {
        this.websocketRouteTemplate = websocketRouteTemplate;
        this.websocketChannelTemplate = websocketChannelTemplate;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame msg) {
        WebsocketServerHandlerFactoryExecution.business (websocketRouteTemplate, websocketChannelTemplate, msg);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        WebsocketServerHandlerFactoryExecution.timeoutEvent (((IdleStateEvent) evt).state (), websocketRouteTemplate, websocketChannelTemplate);
        super.userEventTriggered (ctx, evt);
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        WebsocketServerHandlerFactoryExecution.closeEvent (websocketRouteTemplate, websocketChannelTemplate);
        super.channelInactive (ctx);
    }
}
