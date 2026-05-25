/* ***** BEGIN LICENSE BLOCK *****
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
 * ***** END LICENSE BLOCK ***** */
package org.mozilla.universalchardet.prober;

import java.nio.ByteBuffer;

public abstract class CharsetProber {

    ////////////////////////////////////////////////////////////////
    // constants
    ////////////////////////////////////////////////////////////////
    public static final float SHORTCUT_THRESHOLD = 0.95f;

    // 'a'
    public static final int ASCII_A = 0x61;

    // 'z'
    public static final int ASCII_Z = 0x7A;

    // 'A'
    public static final int ASCII_A_CAPITAL = 0x41;

    // 'Z'
    public static final int ASCII_Z_CAPITAL = 0x5A;

    // '<'
    public static final int ASCII_LT = 0x3C;

    // '>'
    public static final int ASCII_GT = 0x3E;

    // ' '
    public static final int ASCII_SP = 0x20;

    private boolean active = true;

    ////////////////////////////////////////////////////////////////
    // inner types
    ////////////////////////////////////////////////////////////////
    public enum ProbingState {

        DETECTING, FOUND_IT, NOT_ME
    }

    ////////////////////////////////////////////////////////////////
    // methods
    ////////////////////////////////////////////////////////////////
    public CharsetProber() {
        super();
    }

    public abstract String getCharSetName();

    public abstract ProbingState handleData(final byte[] buf, int offset, int length);

    public abstract ProbingState getState();

    public abstract void reset();

    public abstract float getConfidence();

    public abstract void setOption();

    // ByteBuffer.position() indicates number of bytes written.
    public ByteBuffer filterWithoutEnglishLetters(final byte[] buf, int offset, int length) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ByteBuffer filterWithEnglishLetters(final byte[] buf, int offset, int length) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean isAscii(byte b) {
        return ((b & 0x80) == 0);
    }

    // b must be in ASCII code range (MSB can't be 1).
    private boolean isAsciiSymbol(byte b) {
        int c = b & 0xFF;
        return ((c < ASCII_A_CAPITAL) || (c > ASCII_Z_CAPITAL && c < ASCII_A) || (c > ASCII_Z));
    }

    public boolean isActive() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setActive(boolean active) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
