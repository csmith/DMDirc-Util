/*
 * Copyright (c) 2006-2017 DMDirc Developers
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.dmdirc.util.validators;

import org.junit.Test;

import static org.junit.Assert.*;

public class ServerNameValidatorTest {


    @Test
    public void testValidateNull() {
        final ServerNameValidator instance = new ServerNameValidator();
        assertTrue(instance.validate(null).isFailure());
    }

    @Test
    public void testValidateEmpty() {
        final ServerNameValidator instance = new ServerNameValidator();
        assertTrue(instance.validate("").isFailure());
    }

    @Test
    public void testValidateNoProtocol() {
        final ServerNameValidator instance = new ServerNameValidator();
        assertFalse(instance.validate("test.com").isFailure());
    }

    @Test
    public void testValidateNoHostname() {
        final ServerNameValidator instance = new ServerNameValidator();
        assertEquals("Address requires a hostname.",
                instance.validate("irc://").getFailureReason());
    }

    @Test
    public void testValidateInvalidURI() {
        final ServerNameValidator instance = new ServerNameValidator();
        assertTrue(instance.validate("irc://^").isFailure());
    }

    @Test
    public void testValidateValid() {
        final ServerNameValidator instance = new ServerNameValidator();
        assertFalse(instance.validate("irc://test.com").isFailure());
    }
}
