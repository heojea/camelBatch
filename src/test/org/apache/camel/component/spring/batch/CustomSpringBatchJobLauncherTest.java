/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.spring.batch;

import org.apache.camel.EndpointInject;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomSpringBatchJobLauncherTest extends CamelSpringTestSupport {

    @EndpointInject(uri = "mock:output")
    MockEndpoint outputEndpoint;

    @EndpointInject(uri = "mock:jobExecutionEventsQueue")
    MockEndpoint jobExecutionEventsQueueEndpoint;

    String[] inputMessages = new String[]{"foo", "bar", "baz", null};

    @Before
    public void setUp() throws Exception {
        super.setUp();

        /*for (String message : inputMessages) {
            template.sendBody("seda:inputQueue", message);
        }*/
    }

    @Test
    public void cutstomTestJobLauncher() throws InterruptedException {
    	template.sendBody("direct:start", "Start batch!");
    	//Thread.sleep(40000000);
    }
    
    @Test
    public void cutstomTestLargeFileJobLauncher() throws InterruptedException {
    	template.sendBody("direct:large-file-batch-start", "Start batch!");
    	//Thread.sleep(40000000);
    }

    @Test
    public void cutestJobLauncherRef() throws InterruptedException {
    	 template.sendBody("seda:inputQueue", "foo");

        
    }

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("META-INF/spring/customSpringBatchtestContext.xml");
        
    }
}
