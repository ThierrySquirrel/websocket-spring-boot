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

import io.netty.channel.Channel;
import io.netty.handler.codec.http.FullHttpRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * ClassName: AbstractHttpServerHandshakeThread
 * Description:
 * date: 2020/8/18 0:05
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Getter
@Setter
public abstract class AbstractHttpServerHandshakeThread implements Runnable {
    private Channel channel;
    private FullHttpRequest request;
    private int maxFramePayloadLength;
    private int readTimeoutMilli;

    protected AbstractHttpServerHandshakeThread(Channel channel, FullHttpRequest request, int maxFramePayloadLength, int readTimeoutMilli) {
        this.channel = channel;
        this.request = request;
        this.maxFramePayloadLength = maxFramePayloadLength;
        this.readTimeoutMilli = readTimeoutMilli;
    }

    /**
     * httpServerHandshake
     *
     * @param channel               channel
     * @param request               request
     * @param maxFramePayloadLength maxFramePayloadLength
     * @param readTimeoutMilli      readTimeoutMilli
     */
    protected abstract void httpServerHandshake(Channel channel, FullHttpRequest request, int maxFramePayloadLength, int readTimeoutMilli);

    @Override
    public void run() {
        httpServerHandshake (this.channel,
                this.request,
                this.maxFramePayloadLength,
                this.readTimeoutMilli);
    }
}
