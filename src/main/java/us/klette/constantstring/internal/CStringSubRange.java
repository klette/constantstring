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

package us.klette.constantstring.internal;

import us.klette.constantstring.CString;

import javax.annotation.Nonnull;

/**
 * Representation of a substring operation.
 *
 * @author Kristian Klette (klette@klette.us)
 */
public class CStringSubRange implements CString {
    /**
     * The child node which the substring operation is
     * performed upon.
     */
    private final transient CString value;

    /**
     * The index from which the text is kept.
     */
    private final transient int idx;

    /**
     * The number of chars after {@link #idx} to include.
     */
    private final int end;

    /**
     * Creates a new substring operation on the given value.
     *
     * @param val   The value used as the child node for the operation.
     * @param index The index from which the text is kept.
     * @param end The end index of the substring
     */
    public CStringSubRange(@Nonnull final CString val, final int index, final int end) {
        this.value = val;
        this.idx = index;
        this.end = end;
    }

    @Override
    public final String toString() {
        final String childEval = this.value.toString();
        final int length = childEval.length();
        return this.idx > length - 1
               ? ""
               : childEval.substring(this.idx, Math.min(end, length));
    }
}
