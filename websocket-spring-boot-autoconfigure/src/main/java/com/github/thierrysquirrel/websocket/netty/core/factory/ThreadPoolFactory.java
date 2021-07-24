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
package com.github.thierrysquirrel.websocket.netty.core.factory;

import com.github.thierrysquirrel.websocket.netty.core.factory.constant.ThreadPoolConstant;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: ThreadPoolFactory
 * Description:
 * date: 2020/8/18 0:11
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class ThreadPoolFactory {
    private ThreadPoolFactory() {
    }

    public static ThreadPoolExecutor createHttpServerHandshakeThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder ()
                .setNameFormat (ThreadPoolConstant.HTTP_SERVER_HANDSHAKE).build ();
        return new ThreadPoolExecutor (ThreadPoolConstant.HTTP_SERVER_HANDSHAKE_CORE_POOL_SIZE,
                ThreadPoolConstant.HTTP_SERVER_HANDSHAKE_MAXIMUM_POOL_SIZE,
                ThreadPoolConstant.HTTP_SERVER_HANDSHAKE_KEEP_ALIVE_TIME,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<> (),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy ()
        );
    }

    public static ThreadPoolExecutor createWebsocketServerBusinessThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder ()
                .setNameFormat (ThreadPoolConstant.WEBSOCKET_SERVER_BUSINESS).build ();
        return new ThreadPoolExecutor (ThreadPoolConstant.WEBSOCKET_SERVER_BUSINESS_CORE_POOL_SIZE,
                ThreadPoolConstant.WEBSOCKET_SERVER_BUSINESS_MAXIMUM_POOL_SIZE,
                ThreadPoolConstant.WEBSOCKET_SERVER_BUSINESS_KEEP_ALIVE_TIME,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<> (),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy ()
        );
    }

    public static ThreadPoolExecutor createWebsocketServerInitThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder ()
                .setNameFormat (ThreadPoolConstant.WEBSOCKET_SERVER_INIT).build ();
        return new ThreadPoolExecutor (ThreadPoolConstant.WEBSOCKET_SERVER_INIT_CORE_POOL_SIZE,
                ThreadPoolConstant.WEBSOCKET_SERVER_INIT_MAXIMUM_POOL_SIZE,
                ThreadPoolConstant.WEBSOCKET_SERVER_INIT_KEEP_ALIVE_TIME,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<> (),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy ()
        );
    }
}
