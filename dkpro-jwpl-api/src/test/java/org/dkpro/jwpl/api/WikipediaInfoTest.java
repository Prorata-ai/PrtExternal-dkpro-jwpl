/*
 * Licensed to the Technische Universität Darmstadt under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The Technische Universität Darmstadt 
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.
 *  
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dkpro.jwpl.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class WikipediaInfoTest
    extends BaseJWPLTest
{

    private static WikipediaInfo wikipediaInfo;

    /**
     * Made this static so that following tests don't run if assumption fails. (With AT_Before,
     * tests also would not be executed but marked as passed) This could be changed back as soon as
     * JUnit ignored tests after failed assumptions
     */
    @BeforeAll
    public static void setupWikipedia()
    {
        DatabaseConfiguration db = obtainHSDLDBConfiguration();
        try {
            wikipediaInfo = new WikipediaInfo(new Wikipedia(db));
        }
        catch (Exception e) {
            fail("WikipediaInfo could not be initialized: " + e.getLocalizedMessage());
        }
    }

    @Test
    public void testGetAverageFanOut() {
        double average = wikipediaInfo.getAverageFanOut();
        assertTrue(average > 0);
        assertEquals(1.1176470588235294d, average);
        //call it twice
        average = wikipediaInfo.getAverageFanOut();
        assertEquals(1.1176470588235294d, average);
    }

}
