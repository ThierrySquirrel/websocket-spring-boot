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

import lombok.Getter;
import lombok.Setter;

/**
 * ClassName: AbstractWebsocketServerInitThread
 * Description:
 * date: 2020/8/18 2:02
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Getter
@Setter
public abstract class AbstractWebsocketServerInitThread implements Runnable {
    private String url;
    private int websocketMaxFramePayloadLength;
    private int websocketReadTimeoutMilli;

    public AbstractWebsocketServerInitThread(String url, int websocketMaxFramePayloadLength, int websocketReadTimeoutMilli) {
        this.url = url;
        this.websocketMaxFramePayloadLength = websocketMaxFramePayloadLength;
        this.websocketReadTimeoutMilli = websocketReadTimeoutMilli;
    }

    /**
     * init
     *
     * @param url                            url
     * @param websocketMaxFramePayloadLength websocketMaxFramePayloadLength
     * @param websocketReadTimeoutMilli      websocketReadTimeoutMilli
     */
    protected abstract void init(String url, int websocketMaxFramePayloadLength, int websocketReadTimeoutMilli);

    @Override
    public void run() {
        init (this.url,
                this.websocketMaxFramePayloadLength,
                this.websocketReadTimeoutMilli);
    }
}
