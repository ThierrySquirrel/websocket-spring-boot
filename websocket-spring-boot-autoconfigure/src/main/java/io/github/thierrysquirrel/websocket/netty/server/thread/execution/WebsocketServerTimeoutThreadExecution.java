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
package io.github.thierrysquirrel.websocket.netty.server.thread.execution;

import io.github.thierrysquirrel.websocket.core.exception.WebsocketException;
import io.github.thierrysquirrel.websocket.core.template.WebsocketChannelTemplate;
import io.github.thierrysquirrel.websocket.core.template.WebsocketRouteTemplate;
import io.github.thierrysquirrel.websocket.netty.server.thread.AbstractWebsocketServerTimeoutThread;

/**
 * ClassName: WebsocketServerTimeoutThreadExecution 
 * Description: 
 * date: 2020/8/18 1:51
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class WebsocketServerTimeoutThreadExecution extends AbstractWebsocketServerTimeoutThread {
    public WebsocketServerTimeoutThreadExecution(WebsocketRouteTemplate websocketRouteTemplate, WebsocketChannelTemplate websocketChannelTemplate) {
        super (websocketRouteTemplate, websocketChannelTemplate);
    }

    @Override
    protected void timeout(WebsocketRouteTemplate websocketRouteTemplate, WebsocketChannelTemplate websocketChannelTemplate) {
        try {
            websocketRouteTemplate.connectionTimeoutEvent (websocketChannelTemplate);
        }catch (Exception e){
            websocketRouteTemplate.errorEvent (websocketChannelTemplate, new WebsocketException (e));
        }
    }
}
