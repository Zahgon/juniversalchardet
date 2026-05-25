/* 
(C) Copyright 2016-2017 Alberto Fernández <infjaf@gmail.com>
(C) Copyright 2006-2007 Kohei TAKETA <k-tak@void.in> (Java port)
(C) Copyright 2001 Netscape Communications Corporation.

 * Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is Mozilla Universal charset detector code.
 *
 * The Initial Developer of the Original Code is
 * Netscape Communications Corporation.
 * Portions created by the Initial Developer are Copyright (C) 2001
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 *          Shy Shalom <shooshX@gmail.com>
 *          Kohei TAKETA <k-tak@void.in> (Java port)
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * 
*/
package org.mozilla.universalchardet;

import static org.mozilla.universalchardet.Constants.CHARSET_US_ASCII;
import static org.mozilla.universalchardet.Constants.CHARSET_UTF_16BE;
import static org.mozilla.universalchardet.Constants.CHARSET_UTF_16LE;
import static org.mozilla.universalchardet.Constants.CHARSET_UTF_32BE;
import static org.mozilla.universalchardet.Constants.CHARSET_UTF_32LE;
import static org.mozilla.universalchardet.Constants.CHARSET_UTF_8;
import static org.mozilla.universalchardet.Constants.CHARSET_X_ISO_10646_UCS_4_2143;
import static org.mozilla.universalchardet.Constants.CHARSET_X_ISO_10646_UCS_4_3412;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.EscCharsetProber;
import org.mozilla.universalchardet.prober.Latin1Prober;
import org.mozilla.universalchardet.prober.MBCSGroupProber;
import org.mozilla.universalchardet.prober.SBCSGroupProber;

public class UniversalDetector {

    private static final float MINIMUM_THRESHOLD = 0.20f;

    private enum InputState {

        PURE_ASCII, ESC_ASCII, HIGHBYTE
    }

    private InputState inputState;

    private boolean done;

    private boolean start;

    private boolean gotData;

    private boolean onlyPrintableASCII = true;

    private byte lastChar;

    private String detectedCharset;

    private CharsetProber[] probers;

    private CharsetProber escCharsetProber;

    private CharsetListener listener;

    /**
     * Create UniversalDetector
     */
    public UniversalDetector() {
        this(null);
    }

    /**
     * Create UniversalDetector
     * @param listener a listener object that is notified of
     *         the detected encocoding. Can be null.
     */
    public UniversalDetector(CharsetListener listener) {
        super();
        this.listener = listener;
        this.escCharsetProber = null;
        this.probers = new CharsetProber[3];
        reset();
    }

    public boolean isDone() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The detected encoding is returned. If the detector couldn't
     *          determine what encoding was used, null is returned.
     */
    public String getDetectedCharset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setListener(CharsetListener listener) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CharsetListener getListener() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Feed the detector with more data
     * @param buf The buffer containing the data
     */
    public void handleData(final byte[] buf) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Feed the detector with more data
     * @param buf Buffer with the data
     * @param offset initial position of data in buf
     * @param length length of data
     */
    public void handleData(final byte[] buf, int offset, int length) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static String detectCharsetFromBOM(final byte[] buf, int offset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Marks end of data reading. Finish calculations.
     */
    public void dataEnd() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Resets detector to be used again.
     */
    public final void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void notifyListener(String detectedCharset) {
        if (this.listener != null && detectedCharset != null && detectedCharset.trim().length() > 0) {
            this.listener.report(detectedCharset);
        }
    }

    /**
     * Gets the charset of a File.
     *
     * @param file The file to check charset for
     * @return The charset of the file, null if cannot be determined
     * @throws IOException if some IO error occurs
     */
    public static String detectCharset(File file) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the charset of a Path.
     *
     * @param path The path to file to check charset for
     * @return The charset of the file, null if cannot be determined
     * @throws IOException if some IO error occurs
     */
    public static String detectCharset(Path path) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the charset of content from InputStream.
     *
     * @param inputStream InputStream containing text file
     * @return The charset of the file, null if cannot be determined
     * @throws IOException if some IO error occurs
     */
    public static String detectCharset(InputStream inputStream) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
