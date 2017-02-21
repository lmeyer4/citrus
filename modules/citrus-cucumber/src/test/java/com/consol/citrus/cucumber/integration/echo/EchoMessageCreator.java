/*
 * Copyright 2006-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.consol.citrus.cucumber.integration.echo;

import com.consol.citrus.cucumber.message.MessageCreator;
import com.consol.citrus.message.DefaultMessage;
import com.consol.citrus.message.Message;

/**
 * @author Christoph Deppisch
 * @since 2.6
 */
public class EchoMessageCreator {

    @MessageCreator("echoRequest")
    public Message createEchoRequest() {
        return new DefaultMessage("<message>" +
                    "<text>${text}</text>" +
                "</message>")
                .setHeader("operation", "${operation}");
    }
}