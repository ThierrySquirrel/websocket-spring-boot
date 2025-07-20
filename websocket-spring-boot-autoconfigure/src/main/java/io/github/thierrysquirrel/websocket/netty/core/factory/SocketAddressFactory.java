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
package io.github.thierrysquirrel.websocket.netty.core.factory;

import io.github.thierrysquirrel.websocket.netty.core.factory.constant.SocketAddressConstant;

import java.net.InetSocketAddress;

/**
 * ClassName: SocketAddressFactory 
 * Description: 
 * date: 2020/8/17 23:56
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class SocketAddressFactory {
    private SocketAddressFactory() {
    }

    public static InetSocketAddress getSocketAddress(String url) {
        int i = url.indexOf (SocketAddressConstant.SEPARATOR);
        String host = url.substring (0, i);
        int port = Integer.parseInt (url.substring (i + 1));
        return new InetSocketAddress (host, port);
    }
}
