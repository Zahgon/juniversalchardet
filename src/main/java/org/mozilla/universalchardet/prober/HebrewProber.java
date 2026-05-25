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
 *          Shy Shalom <shooshX@gmail.com>
 * Portions created by the Initial Developer are Copyright (C) 2005
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 *   Kohei TAKETA <k-tak@void.in> (Java port)
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

import org.mozilla.universalchardet.Constants;

public class HebrewProber extends CharsetProber {

    ////////////////////////////////////////////////////////////////
    // fields
    ////////////////////////////////////////////////////////////////
    public static final int FINAL_KAF = 0xEA;

    public static final int NORMAL_KAF = 0xEB;

    public static final int FINAL_MEM = 0xED;

    public static final int NORMAL_MEM = 0xEE;

    public static final int FINAL_NUN = 0xEF;

    public static final int NORMAL_NUN = 0xF0;

    public static final int FINAL_PE = 0xF3;

    public static final int NORMAL_PE = 0xF4;

    public static final int FINAL_TSADI = 0xF5;

    public static final int NORMAL_TSADI = 0xF6;

    public static final byte SPACE = 0x20;

    public static final int MIN_FINAL_CHAR_DISTANCE = 5;

    public static final float MIN_MODEL_DISTANCE = 0.01f;

    ////////////////////////////////////////////////////////////////
    // fields
    ////////////////////////////////////////////////////////////////
    private int finalCharLogicalScore;

    private int finalCharVisualScore;

    private byte prev;

    private byte beforePrev;

    private CharsetProber logicalProber;

    private CharsetProber visualProber;

    ////////////////////////////////////////////////////////////////
    // methods
    ////////////////////////////////////////////////////////////////
    public HebrewProber() {
        super();
        this.logicalProber = null;
        this.visualProber = null;
        reset();
    }

    public void setModalProbers(CharsetProber logicalProber, CharsetProber visualProber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getCharSetName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public float getConfidence() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProbingState getState() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProbingState handleData(byte[] buf, int offset, int length) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setOption() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static boolean isFinal(byte b) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static boolean isNonFinal(byte b) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
