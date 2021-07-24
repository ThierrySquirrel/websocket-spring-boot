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
package com.github.thierrysquirrel.websocket.netty.core.factory.execution;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * ClassName: ThreadPoolFactoryExecution 
 * Description: 
 * date: 2020/8/18 0:18
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class ThreadPoolFactoryExecution {
    private ThreadPoolFactoryExecution() {
    }

    public static void statsThread(ThreadPoolExecutor threadPoolExecutor, Runnable runnable) {
        threadPoolExecutor.execute (runnable);
    }

    public static void statsThreadAndShutdown(ThreadPoolExecutor threadPoolExecutor, Runnable runnable) {
        threadPoolExecutor.execute (runnable);
        threadPoolExecutor.shutdown ();
    }
}
