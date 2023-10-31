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
package org.dkpro.jwpl.revisionmachine.difftool.data.tasks.content;

import java.io.Serializable;
import java.util.Objects;

/**
 * The DiffPart class represents the operation used to create a new revision from an older revision.
 */
public class DiffPart
    implements Serializable
{

    private static final long serialVersionUID = 6208903899064982679L;

    /**
     * Start position of the text block
     */
    private int start;

    /**
     * Lengthof the text block
     */
    private int length;

    /**
     * DiffAction value
     */
    private final DiffAction action;

    /**
     * Textual information
     */
    private String text;

    /**
     * (Constructor) Creates a new DiffPart object.
     *
     * @param action
     *            DiffAction
     */
    public DiffPart(final DiffAction action)
    {

        this.action = action;
    }

    /**
     * Returns the length of the text block.
     *
     * @return length of the text block
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Sets the length of the text block.
     *
     * @param length
     *            length of the text block
     */
    public void setLength(final int length)
    {
        this.length = length;
    }

    /**
     * Returns the start position of the text block.
     *
     * @return start position
     */
    public int getStart()
    {
        return start;
    }

    /**
     * Returns the end position of the text block.
     *
     * @return end position
     */
    public int getEnd()
    {
        return start + length;
    }

    /**
     * Sets the start position of the text block.
     *
     * @param start
     *            start position
     */
    public void setStart(final int start)
    {
        this.start = start;
    }

    /**
     * Sets the textual information.
     *
     * @param text
     *            content
     */
    public void setText(final String text)
    {
        this.text = text;
    }

    /**
     * Returns the DiffAction value.
     *
     * @return DiffAction
     */
    public DiffAction getAction()
    {
        return this.action;
    }

    /**
     * Returns the textual information.
     *
     * @return content
     */
    public String getText()
    {
        return this.text;
    }

    /**
     * Returns a representation of the DiffAction content.
     *
     * @return [ DiffAction, start position, length, content ]
     */
    @Override
    public String toString()
    {
        return "[" + action + " " + start + " " + length + " " + text + "]\n";
    }

    /**
     * Returns the estimated number of bytes used to encode the contained information.
     *
     * @return estimated size in bytes
     */
    public int byteSize()
    {
        if (text == null) {
            return 9;
        }
        return 9 + text.length();
    }

    @Override
    public boolean equals(final Object other)
    {
        if (!(other instanceof DiffPart)) {
            return false;
        }
        DiffPart castOther = (DiffPart) other;
        return Objects.equals(start, castOther.start) && Objects.equals(length, castOther.length)
                && Objects.equals(action, castOther.action) && Objects.equals(text, castOther.text);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(start, length, action, text);
    }
}
