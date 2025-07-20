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
package io.github.thierrysquirrel.websocket.init;

import io.github.thierrysquirrel.websocket.autoconfigure.WebsocketProperties;
import io.github.thierrysquirrel.websocket.init.core.factory.execution.WebsocketInitExecution;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * ClassName: WebsocketInit
 * Description:
 * date: 2020/8/18 2:08
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class WebsocketInit {
    @Resource
    private WebsocketProperties websocketProperties;

    @PostConstruct
    public void init() {
        WebsocketInitExecution.init (websocketProperties.getUrl (),
                websocketProperties.getMaxFramePayloadLength (),
                websocketProperties.getReadTimeoutMilli ());
    }
}
