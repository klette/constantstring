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

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Test cases for basic operations.
 *
 * @author Kristian Klette (klette@klette.us)
 */
public final class OperationsTest {

    /**
     * Verify that CString can store and evaluate basic strings.
     *
     * @throws Exception e
     */
    @Test
    public void evalShouldReturnBasicValue() throws Exception {
        final String string = "basic";
        final CString cString = CStringInit.create(string);
        final String eval = cString.toString();
        Assertions.assertThat(eval).isEqualTo(string);
    }

    /**
     * Verify that we can substring a value once.
     *
     * @throws Exception e
     */
    @Test
    public void shouldBeAbleToSubstring() throws Exception {
        final String string = "substr";
        final int index = 3;
        final CString initial = CStringInit.create(string);
        final CString substring = initial.substring(index);
        final String evaluated = substring.toString();
        Assertions.assertThat(evaluated).isEqualTo(string.substring(index));
    }

    /**
     * Verify that substring operations with an index higher than
     * the length of the underlying CString, then an empty string
     * should be returned.
     */
    @Test
    public void substringWithIndexOutsideBoundsShouldBeEmptyString() {
        final String foobar = "foobar";
        final String substr = CStringInit
                .create(foobar)
                .substring(foobar.length())
                .toString();
        Assertions.assertThat(substr).isEqualTo("");
    }

    /**
     * Verify that substrings of substrings are working.
     *
     * @throws Exception e
     */
    @Test
    public void substringOfSubstring() throws Exception {
        final CString initial = CStringInit.create("abc");
        final CString first = initial.substring(1);
        final CString second = first.substring(1);
        final String evaluated = second.toString();
        Assertions.assertThat(evaluated).isEqualTo("c");
    }
}
