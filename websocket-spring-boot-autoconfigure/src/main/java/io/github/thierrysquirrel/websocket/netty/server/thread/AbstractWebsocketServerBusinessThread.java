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
package io.github.thierrysquirrel.websocket.netty.server.thread;

import io.github.thierrysquirrel.websocket.core.template.WebsocketChannelTemplate;
import io.github.thierrysquirrel.websocket.core.template.WebsocketRouteTemplate;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import lombok.Getter;
import lombok.Setter;

/**
 * ClassName: AbstractWebsocketServerBusinessThread
 * Description:
 * date: 2020/8/18 0:39
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Getter
@Setter
public abstract class AbstractWebsocketServerBusinessThread implements Runnable {
    private WebsocketRouteTemplate websocketRouteTemplate;
    private WebsocketChannelTemplate websocketChannelTemplate;
    private WebSocketFrame webSocketFrame;

    protected AbstractWebsocketServerBusinessThread(WebsocketRouteTemplate websocketRouteTemplate, WebsocketChannelTemplate websocketChannelTemplate, WebSocketFrame webSocketFrame) {
        this.websocketRouteTemplate = websocketRouteTemplate;
        this.websocketChannelTemplate = websocketChannelTemplate;
        this.webSocketFrame = webSocketFrame;
    }

    /**
     * businessExecution
     *
     * @param websocketRouteTemplate   websocketRouteTemplate
     * @param websocketChannelTemplate websocketChannelTemplate
     * @param webSocketFrame           webSocketFrame
     */
    protected abstract void businessExecution(WebsocketRouteTemplate websocketRouteTemplate, WebsocketChannelTemplate websocketChannelTemplate, WebSocketFrame webSocketFrame);

    @Override
    public void run() {
        businessExecution (this.websocketRouteTemplate,
                this.websocketChannelTemplate,
                this.webSocketFrame);
    }
}
