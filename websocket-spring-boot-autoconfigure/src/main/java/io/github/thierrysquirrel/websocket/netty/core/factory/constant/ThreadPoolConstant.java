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
package io.github.thierrysquirrel.websocket.netty.core.factory.constant;

/**
 * ClassName: ThreadPoolConstant
 * Description:
 * date: 2020/8/18 0:12
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public final class ThreadPoolConstant {
    public static final String HTTP_SERVER_HANDSHAKE = "HttpServerHandshake";
    public static final int HTTP_SERVER_HANDSHAKE_CORE_POOL_SIZE = Runtime.getRuntime ().availableProcessors () * 2;
    public static final int HTTP_SERVER_HANDSHAKE_MAXIMUM_POOL_SIZE = Runtime.getRuntime ().availableProcessors () * 2;
    public static final int HTTP_SERVER_HANDSHAKE_KEEP_ALIVE_TIME = 0;

    public static final String WEBSOCKET_SERVER_BUSINESS = "WebsocketServerBusiness";
    public static final int WEBSOCKET_SERVER_BUSINESS_CORE_POOL_SIZE = Runtime.getRuntime ().availableProcessors () * 3;
    public static final int WEBSOCKET_SERVER_BUSINESS_MAXIMUM_POOL_SIZE = Runtime.getRuntime ().availableProcessors () * 3;
    public static final int WEBSOCKET_SERVER_BUSINESS_KEEP_ALIVE_TIME = 0;

    public static final String WEBSOCKET_SERVER_INIT = "WebsocketServerInit";
    public static final int WEBSOCKET_SERVER_INIT_CORE_POOL_SIZE = 1;
    public static final int WEBSOCKET_SERVER_INIT_MAXIMUM_POOL_SIZE = 1;
    public static final int WEBSOCKET_SERVER_INIT_KEEP_ALIVE_TIME = 0;

    private ThreadPoolConstant() {
    }

}
