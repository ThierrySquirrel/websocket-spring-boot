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
package com.github.thierrysquirrel.websocket.netty.server.handler.core.factory.execution;

import com.github.thierrysquirrel.websocket.core.template.WebsocketChannelTemplate;
import com.github.thierrysquirrel.websocket.core.template.WebsocketRouteTemplate;
import com.github.thierrysquirrel.websocket.netty.core.factory.constant.ThreadPoolFactoryConstant;
import com.github.thierrysquirrel.websocket.netty.core.factory.execution.ThreadPoolFactoryExecution;
import com.github.thierrysquirrel.websocket.netty.server.handler.core.factory.WebsocketServerHandlerFactory;
import com.github.thierrysquirrel.websocket.netty.server.thread.execution.WebsocketServerBusinessThreadExecution;
import com.github.thierrysquirrel.websocket.netty.server.thread.execution.WebsocketServerCloseThreadExecution;
import com.github.thierrysquirrel.websocket.netty.server.thread.execution.WebsocketServerTimeoutThreadExecution;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.timeout.IdleState;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * ClassName: WebsocketServerHandlerFactoryExecution
 * Description:
 * date: 2020/8/18 2:14
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class WebsocketServerHandlerFactoryExecution {
    private WebsocketServerHandlerFactoryExecution() {
    }

    public static void business(WebsocketRouteTemplate websocketRouteTemplate, WebsocketChannelTemplate websocketChannelTemplate, WebSocketFrame webSocketFrame) {
        WebsocketServerBusinessThreadExecution businessThreadExecution = new WebsocketServerBusinessThreadExecution (websocketRouteTemplate, websocketChannelTemplate, webSocketFrame.retain ());
        ThreadPoolExecutor businessThreadPool = ThreadPoolFactoryConstant.WEBSOCKET_SERVER_BUSINESS_THREAD_POOL;
        ThreadPoolFactoryExecution.statsThread (businessThreadPool, businessThreadExecution);
    }

    public static void timeoutEvent(IdleState state, WebsocketRouteTemplate websocketRouteTemplate, WebsocketChannelTemplate websocketChannelTemplate) {
        if (WebsocketServerHandlerFactory.timeout (state)) {
            timeoutEvent (websocketRouteTemplate, websocketChannelTemplate);
        }
    }

    public static void closeEvent(WebsocketRouteTemplate websocketRouteTemplate, WebsocketChannelTemplate websocketChannelTemplate) {
        WebsocketServerCloseThreadExecution closeThreadExecution = new WebsocketServerCloseThreadExecution (websocketRouteTemplate, websocketChannelTemplate);
        ThreadPoolExecutor businessThreadPool = ThreadPoolFactoryConstant.WEBSOCKET_SERVER_BUSINESS_THREAD_POOL;
        ThreadPoolFactoryExecution.statsThread (businessThreadPool, closeThreadExecution);
    }

    private static void timeoutEvent(WebsocketRouteTemplate websocketRouteTemplate, WebsocketChannelTemplate websocketChannelTemplate) {
        WebsocketServerTimeoutThreadExecution timeoutThreadExecution = new WebsocketServerTimeoutThreadExecution (websocketRouteTemplate, websocketChannelTemplate);
        ThreadPoolExecutor businessThreadPool = ThreadPoolFactoryConstant.WEBSOCKET_SERVER_BUSINESS_THREAD_POOL;
        ThreadPoolFactoryExecution.statsThread (businessThreadPool, timeoutThreadExecution);

    }
}
