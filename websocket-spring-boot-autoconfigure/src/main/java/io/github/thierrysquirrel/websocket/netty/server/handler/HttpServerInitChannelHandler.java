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
package io.github.thierrysquirrel.websocket.netty.server.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: HttpServerInitChannelHandler
 * Description:
 * date: 2020/8/17 20:47
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Getter
@Setter
public class HttpServerInitChannelHandler extends ChannelInitializer<SocketChannel> {
    private int httpReaderIdleTime;
    private int httpWriterIdleTime;
    private int httpAllIdleTime;
    private int httpMaxContentLength;
    private int websocketMaxFramePayloadLength;
    private int websocketReadTimeoutMilli;

    public HttpServerInitChannelHandler(int httpReaderIdleTime, int httpWriterIdleTime, int httpAllIdleTime, int httpMaxContentLength, int websocketMaxFramePayloadLength, int websocketReadTimeoutMilli) {
        this.httpReaderIdleTime = httpReaderIdleTime;
        this.httpWriterIdleTime = httpWriterIdleTime;
        this.httpAllIdleTime = httpAllIdleTime;
        this.httpMaxContentLength = httpMaxContentLength;
        this.websocketMaxFramePayloadLength = websocketMaxFramePayloadLength;
        this.websocketReadTimeoutMilli = websocketReadTimeoutMilli;
    }

    @Override
    protected void initChannel(SocketChannel ch) {

        ch.pipeline ().addLast (new IdleStateHandler (httpReaderIdleTime, httpWriterIdleTime, httpAllIdleTime, TimeUnit.MILLISECONDS))
                .addLast (new HttpServerCodec ())
                .addLast (new HttpObjectAggregator (httpMaxContentLength))
                .addLast (new HttpServerHandler (websocketMaxFramePayloadLength, websocketReadTimeoutMilli));
    }
}
