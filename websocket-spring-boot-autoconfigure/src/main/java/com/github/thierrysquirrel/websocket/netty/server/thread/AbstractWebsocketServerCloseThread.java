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
package com.github.thierrysquirrel.websocket.netty.server.thread;

import com.github.thierrysquirrel.websocket.core.template.WebsocketChannelTemplate;
import com.github.thierrysquirrel.websocket.core.template.WebsocketRouteTemplate;
import lombok.Getter;
import lombok.Setter;

/**
 * ClassName: AbstractWebsocketServerCloseThread
 * Description:
 * date: 2020/8/18 1:56
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Getter
@Setter
public abstract class AbstractWebsocketServerCloseThread implements Runnable {
    private WebsocketRouteTemplate websocketRouteTemplate;
    private WebsocketChannelTemplate websocketChannelTemplate;

    public AbstractWebsocketServerCloseThread(WebsocketRouteTemplate websocketRouteTemplate, WebsocketChannelTemplate websocketChannelTemplate) {
        this.websocketRouteTemplate = websocketRouteTemplate;
        this.websocketChannelTemplate = websocketChannelTemplate;
    }

    /**
     * close
     *
     * @param websocketRouteTemplate   websocketRouteTemplate
     * @param websocketChannelTemplate websocketChannelTemplate
     */
    protected abstract void close(WebsocketRouteTemplate websocketRouteTemplate, WebsocketChannelTemplate websocketChannelTemplate);

    @Override
    public void run() {
        close (this.websocketRouteTemplate, this.websocketChannelTemplate);
    }
}
