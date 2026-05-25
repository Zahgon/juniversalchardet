/*

(C) Copyright 2016-2017 Alberto Fernández <infjaf@gmail.com>

The contents of this file are subject to the Mozilla Public License Version
1.1 (the "License"); you may not use this file except in compliance with
the License. You may obtain a copy of the License at
http://www.mozilla.org/MPL/

Software distributed under the License is distributed on an "AS IS" basis,
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
for the specific language governing rights and limitations under the
License.

Alternatively, the contents of this file may be used under the terms of
either the GNU General Public License Version 2 or later (the "GPL"), or
the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
in which case the provisions of the GPL or the LGPL are applicable instead
of those above. If you wish to allow use of your version of this file only
under the terms of either the GPL or the LGPL, and not to allow others to
use your version of this file under the terms of the MPL, indicate your
decision by deleting the provisions above and replace them with the notice
and other provisions required by the GPL or the LGPL. If you do not delete
the provisions above, a recipient may use your version of this file under
the terms of any one of the MPL, the GPL or the LGPL.

*/
package org.mozilla.universalchardet;

import java.io.IOException;
import java.io.InputStream;

/**
 * Stream that detect encoding while reading.
 * The normal usage is to fully read from inputstream and call close before check for charset.
 */
public class EncodingDetectorInputStream extends InputStream {

    private InputStream in;

    private final UniversalDetector detector = new UniversalDetector(null);

    /**
     * Create the stream
     * @param in The InputStream to read from
     */
    public EncodingDetectorInputStream(InputStream in) {
        super();
        this.in = in;
    }

    /**
     * {@inheritDoc}
     */
    public int available() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    public void close() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    public void mark(int readlimit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    public boolean markSupported() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    public int read() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    public int read(byte[] b, int off, int len) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    public int read(byte[] b) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    public void reset() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    public long skip(long n) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the detected charset, null if not yet detected.
     * @return The detected charset
     */
    public String getDetectedCharset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
