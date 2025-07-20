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
package io.github.thierrysquirrel.websocket.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ClassName: WebsocketProperties
 * Description:
 * date: 2020/8/17 20:37
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Data
@ConfigurationProperties(prefix = WebsocketProperties.WEBSOCKET_PREFIX)
public class WebsocketProperties {
    public static final String WEBSOCKET_PREFIX = "websocket";
    /**
     * ServerUrl
     * 服务Url
     */
    private String url;
    /**
     * MaxFramePayloadLength
     * 最大帧载荷长度
     */
    private int maxFramePayloadLength = 65536;
    /**
     * ReadTimeoutMilli
     * 读取超时
     */
    private int readTimeoutMilli = 16000;
}
