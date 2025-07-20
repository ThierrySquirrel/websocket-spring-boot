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
package io.github.thierrysquirrel.websocket.core.domain;

import io.netty.handler.codec.http.HttpHeaders;
import lombok.Data;

import java.util.Map;

/**
 * ClassName: HttpUpgradeRequest
 * Description:
 * date: 2020/8/17 22:04
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Data
public class HttpUpgradeRequest {
    private HttpHeaders headers;
    private Map<String, String> uriVariable;
    private Map<String, String> uriParam;
}
