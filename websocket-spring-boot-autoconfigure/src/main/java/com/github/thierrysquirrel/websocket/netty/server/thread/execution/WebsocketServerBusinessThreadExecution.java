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
package com.github.thierrysquirrel.websocket.netty.server.thread.execution;

import com.github.thierrysquirrel.websocket.core.exception.WebsocketException;
import com.github.thierrysquirrel.websocket.core.template.WebsocketChannelTemplate;
import com.github.thierrysquirrel.websocket.core.template.WebsocketRouteTemplate;
import com.github.thierrysquirrel.websocket.netty.server.handler.core.strategy.MessageEventStrategy;
import com.github.thierrysquirrel.websocket.netty.server.thread.AbstractWebsocketServerBusinessThread;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

/**
 * ClassName: WebsocketServerBusinessThreadExecution
 * Description:
 * date: 2020/8/18 0:40
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class WebsocketServerBusinessThreadExecution extends AbstractWebsocketServerBusinessThread {
    public WebsocketServerBusinessThreadExecution(WebsocketRouteTemplate websocketRouteTemplate, WebsocketChannelTemplate websocketChannelTemplate, WebSocketFrame webSocketFrame) {
        super (websocketRouteTemplate, websocketChannelTemplate, webSocketFrame);
    }

    @Override
    protected void businessExecution(WebsocketRouteTemplate websocketRouteTemplate, WebsocketChannelTemplate websocketChannelTemplate, WebSocketFrame webSocketFrame) {
        try {
            MessageEventStrategy.messageEvent (websocketRouteTemplate, websocketChannelTemplate, webSocketFrame);
        } catch (Exception e) {
            websocketRouteTemplate.errorEvent (websocketChannelTemplate, new WebsocketException (e));
        }
    }
}
