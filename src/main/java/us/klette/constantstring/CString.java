/**
 * Copyright (c) 2014-2015, Kristian Klette
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the Qulice.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package us.klette.constantstring;

import javax.annotation.Nonnull;

/**
 * The CString interface defines the allowed operations
 * within ConstantString.
 * <p>
 * This is a small utility library for doing constant time string manipulation.
 * Or in simpler terms, you can do operations on strings that are done in a
 * fixed time, and delay the linear time computation until you evaluate your
 * set of operations.
 *
 * @author Kristian Klette (klette@klette.us)
 */
public interface CString {

    /**
     * Creates a new CString instance from a String.
     *
     * @param value The String to use as a base value
     * @return The CString instance from the string
     */
    static CString create(final String value) {
        return new CStringLeaf(value);
    }

    /**
     * Evaluates the CString into a String.
     *
     * @return The resulting {@link String} instance.
     */
    @Override
    String toString();

    /**
     * Applies a substring operations similar to
     * {@link java.lang.String#substring(int)}.
     *
     * @param index The index of which to start the new string
     * @return The CString representation after the applied substring operation
     */
    default CString substring(final int index) {
        return new CStringSub(this, index);
    }
    /**
     * Applies a substring operations similar to
     * {@link java.lang.String#substring(int, int)}.
     *
     * @param index The index of which to start the new string
     * @param end The end index of the substring
     * @return The CString representation after the applied substring operation
     */
    default CString substring(final int index, final int end) {
        return new CStringSubRange(this, index, end);
    }

    /**
     * Append another CString after the current instance.
     *
     * @param other The instance to be appended.
     * @return The CString representation of the two
     */
    default CString concat(@Nonnull final CString other) {
        return new CStringConcat(this, other);
    }
    /**
     * Append another String after the current instance.
     *
     * @param other The instance to be appended.
     * @return The CString representation of the two
     */
    default CString concat(@Nonnull final String other) {
        return this.concat(new CStringLeaf(other));
    }

    /**
     * Delete a subsection of the String.
     *
     * @param start The start index of the delete
     * @param end The end index of the deleted part
     * @return The CString representation with the delete applied.
     */
    default CString delete(final int start, final int end) {
        return this.substring(0, start).concat(this.substring(end));
    }

    /**
     * Insert the given CString at the given index.
     *
     * @param other The CString to insert
     * @param index The position where the string should be inserted
     * @return The resulting CString representation
     */
    default CString insert(@Nonnull final CString other, final int index) {
        return this.substring(0, index)
                .concat(other)
                .concat(this.substring(index));
    }

    /**
     * Insert the given String at the given index.
     *
     * @param other The String to insert
     * @param index The position where the string should be inserted
     * @return The resulting CString representation
     */
    default CString insert(@Nonnull final String other, final int index) {
        return this.insert(new CStringLeaf(other), index);
    }
}
