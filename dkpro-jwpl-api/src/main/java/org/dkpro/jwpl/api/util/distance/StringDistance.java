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
package org.dkpro.jwpl.api.util.distance;

/**
 * Provides methods to compute the editing distance among strings.
 */
public interface StringDistance
{

    /**
     * Computes the editing distance between {@code s1} and {@code s2}.
     * @param s1 A non-empty string. Must not be {@code null}.
     * @param s2 A non-empty string. Must not be {@code null}.
     * @return The editing distance between {@code s1} and {@code s2}.
     */
    double distance(String s1, String s2);

}
