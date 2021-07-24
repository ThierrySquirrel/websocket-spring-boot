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

import com.github.thierrysquirrel.websocket.netty.server.init.WebsocketServerInit;
import com.github.thierrysquirrel.websocket.netty.server.thread.AbstractWebsocketServerInitThread;
import lombok.extern.slf4j.Slf4j;

/**
 * ClassName: WebsocketServerInitThreadExecution
 * Description:
 * date: 2020/8/18 2:03
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Slf4j
public class WebsocketServerInitThreadExecution extends AbstractWebsocketServerInitThread {
    public WebsocketServerInitThreadExecution(String url, int websocketMaxFramePayloadLength, int websocketReadTimeoutMilli) {
        super (url, websocketMaxFramePayloadLength, websocketReadTimeoutMilli);
    }


    @Override
    protected void init(String url, int websocketMaxFramePayloadLength, int websocketReadTimeoutMilli) {
        try {
            new WebsocketServerInit (url, websocketMaxFramePayloadLength, websocketReadTimeoutMilli).init ();
        } catch (InterruptedException e) {
            log.error ("WebsocketServerInit Error", e);
            Thread.currentThread ().interrupt ();
        }

    }
}
