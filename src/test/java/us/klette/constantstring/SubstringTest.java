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
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Parameterized tests for the substring operation.
 *
 * @author Kristian Klette (klette@klette.us)
 */
@RunWith(Parameterized.class)
public class SubstringTest {
    /**
     * The base value.
     */
    private final transient String value;
    /**
     * The index on which to split on.
     */
    private final transient int index;
    /**
     * The expected results.
     */
    private final transient String expected;

    /**
     * Constructor run for each object in parameters list.
     *
     * @param val The base value
     * @param idx The index to subsplit on
     * @param exp The expected result
     */
    public SubstringTest(final String val, final int idx, final String exp) {
        this.value = val;
        this.index = idx;
        this.expected = exp;
    }

    /**
     * The parameters defined for this test.
     *
     * @return The collection of assert objects.
     */
    @Parameterized.Parameters(
            name = "{index}: {0}.substring({1}) == \"{2}\"")
    public static Collection<Object[]> data() {
        final String base = "abc";
        return Arrays.asList(
                new Object[][]{
                        {base, 0, base},
                        {base, 1, base.substring(1)},
                        {base, 2, base.substring(2)},
                        {base, 3, base.substring(3)},
                        {base, 4, ""},
                }
        );
    }

    /**
     * Run the assert against all paramters.
     *
     * @throws Exception e
     */
    @Test
    public final void substringTest() throws Exception {
        final String result = CString.create(this.value)
                .substring(this.index)
                .toString();
        Assertions.assertThat(result).isEqualTo(this.expected);
    }
}
