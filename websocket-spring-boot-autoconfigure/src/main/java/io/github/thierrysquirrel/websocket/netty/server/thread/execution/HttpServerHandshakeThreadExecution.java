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
import io.github.thierrysquirrel.websocket.netty.server.handler.core.factory.execution.HandshakeFactoryExecution;
import io.github.thierrysquirrel.websocket.netty.server.thread.AbstractHttpServerHandshakeThread;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.FullHttpRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * ClassName: HttpServerHandshakeThreadExecution
 * Description:
 * date: 2020/8/18 0:08
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Slf4j
public class HttpServerHandshakeThreadExecution extends AbstractHttpServerHandshakeThread {

    public HttpServerHandshakeThreadExecution(Channel channel, FullHttpRequest request, int maxFramePayloadLength, int readTimeoutMilli) {
        super (channel, request, maxFramePayloadLength, readTimeoutMilli);
    }

    @Override
    protected void httpServerHandshake(Channel channel, FullHttpRequest request, int maxFramePayloadLength, int readTimeoutMilli) {
        try {
            HandshakeFactoryExecution.upgradeWebsocket (channel, request, maxFramePayloadLength, readTimeoutMilli);
        } catch (WebsocketException websocketException) {
            channel.close ();
            log.error ("httpServerHandshake Error", websocketException);
        }
    }
}
