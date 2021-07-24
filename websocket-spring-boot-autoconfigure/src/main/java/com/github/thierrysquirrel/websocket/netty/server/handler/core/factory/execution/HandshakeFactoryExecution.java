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

import com.github.thierrysquirrel.websocket.core.exception.WebsocketException;
import com.github.thierrysquirrel.websocket.core.template.WebsocketRouteTemplate;
import com.github.thierrysquirrel.websocket.netty.server.handler.core.factory.HandshakeFactory;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * ClassName: HandshakeFactoryExecution 
 * Description: 
 * date: 2020/8/18 0:02
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class HandshakeFactoryExecution {
    private HandshakeFactoryExecution() {
    }
    public static void upgradeWebsocket(Channel channel, FullHttpRequest request, int maxFramePayloadLength, int readTimeoutMilli) throws WebsocketException {
        String requestUri = request.uri ();
        WebsocketRouteTemplate routeTemplate = HandshakeFactory.pathValidation (requestUri);
        HandshakeFactory.handshake (request, maxFramePayloadLength, channel);
        HandshakeFactory.upgradePipeline (routeTemplate, readTimeoutMilli, channel, request);
    }
}
