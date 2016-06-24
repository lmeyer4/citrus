/*
 * Copyright 2006-2016 the original author or authors.
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

package cucumber.runtime.java.spring;

import cucumber.runtime.java.CitrusBackend;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @author Christoph Deppisch
 * @since 2.6
 */
public class CitrusSpringObjectFactoryTest {

    @AfterMethod(alwaysRun = true)
    public void resetCitrus() {
        CitrusBackend.resetCitrus();
    }

    @Test
    public void testDesignerInject() throws Exception {
        CitrusSpringObjectFactory factory = new CitrusSpringObjectFactory();
        factory.addClass(SpringDesignerSteps.class);

        // Scenario 1
        factory.start();
        final SpringDesignerSteps steps = factory.getInstance(SpringDesignerSteps.class);
        Assert.assertNotNull(steps.getTestDesigner());
        factory.stop();
    }

    @Test
    public void testDesignerInjectWithDefaultContext() throws Exception {
        CitrusSpringObjectFactory factory = new CitrusSpringObjectFactory();
        factory.addClass(DefaultSpringDesignerSteps.class);

        // Scenario 1
        factory.start();
        final DefaultSpringDesignerSteps steps = factory.getInstance(DefaultSpringDesignerSteps.class);
        Assert.assertNotNull(steps.getTestDesigner());
        factory.stop();
    }

    @Test
    public void testRunnerInject() throws Exception {
        CitrusSpringObjectFactory factory = new CitrusSpringObjectFactory();
        factory.addClass(SpringRunnerSteps.class);

        // Scenario 1
        factory.start();
        final SpringRunnerSteps steps = factory.getInstance(SpringRunnerSteps.class);
        Assert.assertNotNull(steps.getTestRunner());
        factory.stop();
    }

    @Test
    public void testRunnerInjectWithDefaultContext() throws Exception {
        CitrusSpringObjectFactory factory = new CitrusSpringObjectFactory();
        factory.addClass(DefaultSpringRunnerSteps.class);

        // Scenario 1
        factory.start();
        final DefaultSpringRunnerSteps steps = factory.getInstance(DefaultSpringRunnerSteps.class);
        Assert.assertNotNull(steps.getTestRunner());
        factory.stop();
    }
}