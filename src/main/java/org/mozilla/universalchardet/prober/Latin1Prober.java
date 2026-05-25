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
 *          Kohei Taketa <k-tak@void.in> (Java port)
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
import org.mozilla.universalchardet.Constants;

public class Latin1Prober extends CharsetProber {

    public static final byte UDF = 0;

    public static final byte OTH = 1;

    public static final byte ASC = 2;

    public static final byte ASS = 3;

    public static final byte ACV = 4;

    public static final byte ACO = 5;

    public static final byte ASV = 6;

    public static final byte ASO = 7;

    public static final int CLASS_NUM = 8;

    public static final int FREQ_CAT_NUM = 4;

    ////////////////////////////////////////////////////////////////
    // constants continued
    ////////////////////////////////////////////////////////////////
    private static final byte[] latin1CharToClass = new byte[] { // 00 - 07
    OTH, // 00 - 07
    OTH, // 00 - 07
    OTH, // 00 - 07
    OTH, // 00 - 07
    OTH, // 00 - 07
    OTH, // 00 - 07
    OTH, // 00 - 07
    OTH, // 08 - 0F
    OTH, // 08 - 0F
    OTH, // 08 - 0F
    OTH, // 08 - 0F
    OTH, // 08 - 0F
    OTH, // 08 - 0F
    OTH, // 08 - 0F
    OTH, // 08 - 0F
    OTH, // 10 - 17
    OTH, // 10 - 17
    OTH, // 10 - 17
    OTH, // 10 - 17
    OTH, // 10 - 17
    OTH, // 10 - 17
    OTH, // 10 - 17
    OTH, // 10 - 17
    OTH, // 18 - 1F
    OTH, // 18 - 1F
    OTH, // 18 - 1F
    OTH, // 18 - 1F
    OTH, // 18 - 1F
    OTH, // 18 - 1F
    OTH, // 18 - 1F
    OTH, // 18 - 1F
    OTH, // 20 - 27
    OTH, // 20 - 27
    OTH, // 20 - 27
    OTH, // 20 - 27
    OTH, // 20 - 27
    OTH, // 20 - 27
    OTH, // 20 - 27
    OTH, // 20 - 27
    OTH, // 28 - 2F
    OTH, // 28 - 2F
    OTH, // 28 - 2F
    OTH, // 28 - 2F
    OTH, // 28 - 2F
    OTH, // 28 - 2F
    OTH, // 28 - 2F
    OTH, // 28 - 2F
    OTH, // 30 - 37
    OTH, // 30 - 37
    OTH, // 30 - 37
    OTH, // 30 - 37
    OTH, // 30 - 37
    OTH, // 30 - 37
    OTH, // 30 - 37
    OTH, // 30 - 37
    OTH, // 38 - 3F
    OTH, // 38 - 3F
    OTH, // 38 - 3F
    OTH, // 38 - 3F
    OTH, // 38 - 3F
    OTH, // 38 - 3F
    OTH, // 38 - 3F
    OTH, // 38 - 3F
    OTH, // 40 - 47
    OTH, // 40 - 47
    ASC, // 40 - 47
    ASC, // 40 - 47
    ASC, // 40 - 47
    ASC, // 40 - 47
    ASC, // 40 - 47
    ASC, // 40 - 47
    ASC, // 48 - 4F
    ASC, // 48 - 4F
    ASC, // 48 - 4F
    ASC, // 48 - 4F
    ASC, // 48 - 4F
    ASC, // 48 - 4F
    ASC, // 48 - 4F
    ASC, // 48 - 4F
    ASC, // 50 - 57
    ASC, // 50 - 57
    ASC, // 50 - 57
    ASC, // 50 - 57
    ASC, // 50 - 57
    ASC, // 50 - 57
    ASC, // 50 - 57
    ASC, // 50 - 57
    ASC, // 58 - 5F
    ASC, // 58 - 5F
    ASC, // 58 - 5F
    ASC, // 58 - 5F
    OTH, // 58 - 5F
    OTH, // 58 - 5F
    OTH, // 58 - 5F
    OTH, // 58 - 5F
    OTH, // 60 - 67
    OTH, // 60 - 67
    ASS, // 60 - 67
    ASS, // 60 - 67
    ASS, // 60 - 67
    ASS, // 60 - 67
    ASS, // 60 - 67
    ASS, // 60 - 67
    ASS, // 68 - 6F
    ASS, // 68 - 6F
    ASS, // 68 - 6F
    ASS, // 68 - 6F
    ASS, // 68 - 6F
    ASS, // 68 - 6F
    ASS, // 68 - 6F
    ASS, // 68 - 6F
    ASS, // 70 - 77
    ASS, // 70 - 77
    ASS, // 70 - 77
    ASS, // 70 - 77
    ASS, // 70 - 77
    ASS, // 70 - 77
    ASS, // 70 - 77
    ASS, // 70 - 77
    ASS, // 78 - 7F
    ASS, // 78 - 7F
    ASS, // 78 - 7F
    ASS, // 78 - 7F
    OTH, // 78 - 7F
    OTH, // 78 - 7F
    OTH, // 78 - 7F
    OTH, // 78 - 7F
    OTH, // 80 - 87
    OTH, // 80 - 87
    UDF, // 80 - 87
    OTH, // 80 - 87
    ASO, // 80 - 87
    OTH, // 80 - 87
    OTH, // 80 - 87
    OTH, // 80 - 87
    OTH, // 88 - 8F
    OTH, // 88 - 8F
    OTH, // 88 - 8F
    ACO, // 88 - 8F
    OTH, // 88 - 8F
    ACO, // 88 - 8F
    UDF, // 88 - 8F
    ACO, // 88 - 8F
    UDF, // 90 - 97
    UDF, // 90 - 97
    OTH, // 90 - 97
    OTH, // 90 - 97
    OTH, // 90 - 97
    OTH, // 90 - 97
    OTH, // 90 - 97
    OTH, // 90 - 97
    OTH, // 98 - 9F
    OTH, // 98 - 9F
    OTH, // 98 - 9F
    ASO, // 98 - 9F
    OTH, // 98 - 9F
    ASO, // 98 - 9F
    UDF, // 98 - 9F
    ASO, // 98 - 9F
    ACO, // A0 - A7
    OTH, // A0 - A7
    OTH, // A0 - A7
    OTH, // A0 - A7
    OTH, // A0 - A7
    OTH, // A0 - A7
    OTH, // A0 - A7
    OTH, // A0 - A7
    OTH, // A8 - AF
    OTH, // A8 - AF
    OTH, // A8 - AF
    OTH, // A8 - AF
    OTH, // A8 - AF
    OTH, // A8 - AF
    OTH, // A8 - AF
    OTH, // A8 - AF
    OTH, // B0 - B7
    OTH, // B0 - B7
    OTH, // B0 - B7
    OTH, // B0 - B7
    OTH, // B0 - B7
    OTH, // B0 - B7
    OTH, // B0 - B7
    OTH, // B0 - B7
    OTH, // B8 - BF
    OTH, // B8 - BF
    OTH, // B8 - BF
    OTH, // B8 - BF
    OTH, // B8 - BF
    OTH, // B8 - BF
    OTH, // B8 - BF
    OTH, // B8 - BF
    OTH, // C0 - C7
    ACV, // C0 - C7
    ACV, // C0 - C7
    ACV, // C0 - C7
    ACV, // C0 - C7
    ACV, // C0 - C7
    ACV, // C0 - C7
    ACO, // C0 - C7
    ACO, // C8 - CF
    ACV, // C8 - CF
    ACV, // C8 - CF
    ACV, // C8 - CF
    ACV, // C8 - CF
    ACV, // C8 - CF
    ACV, // C8 - CF
    ACV, // C8 - CF
    ACV, // D0 - D7
    ACO, // D0 - D7
    ACO, // D0 - D7
    ACV, // D0 - D7
    ACV, // D0 - D7
    ACV, // D0 - D7
    ACV, // D0 - D7
    ACV, // D0 - D7
    OTH, // D8 - DF
    ACV, // D8 - DF
    ACV, // D8 - DF
    ACV, // D8 - DF
    ACV, // D8 - DF
    ACV, // D8 - DF
    ACO, // D8 - DF
    ACO, // D8 - DF
    ACO, // E0 - E7
    ASV, // E0 - E7
    ASV, // E0 - E7
    ASV, // E0 - E7
    ASV, // E0 - E7
    ASV, // E0 - E7
    ASV, // E0 - E7
    ASO, // E0 - E7
    ASO, // E8 - EF
    ASV, // E8 - EF
    ASV, // E8 - EF
    ASV, // E8 - EF
    ASV, // E8 - EF
    ASV, // E8 - EF
    ASV, // E8 - EF
    ASV, // E8 - EF
    ASV, // F0 - F7
    ASO, // F0 - F7
    ASO, // F0 - F7
    ASV, // F0 - F7
    ASV, // F0 - F7
    ASV, // F0 - F7
    ASV, // F0 - F7
    ASV, // F0 - F7
    OTH, // F8 - FF
    ASV, // F8 - FF
    ASV, // F8 - FF
    ASV, // F8 - FF
    ASV, // F8 - FF
    ASV, // F8 - FF
    ASO, // F8 - FF
    ASO, // F8 - FF
    ASO };

    private static final byte[] latin1ClassModel = new byte[] { /*      UDF OTH ASC ASS ACV ACO ASV ASO  */
    /*UDF*/
    0, 0, 0, 0, 0, 0, 0, 0, /*OTH*/
    0, 3, 3, 3, 3, 3, 3, 3, /*ASC*/
    0, 3, 3, 3, 3, 3, 3, 3, /*ASS*/
    0, 3, 3, 3, 1, 1, 3, 3, /*ACV*/
    0, 3, 3, 3, 1, 2, 1, 2, /*ACO*/
    0, 3, 3, 3, 3, 3, 3, 3, /*ASV*/
    0, 3, 1, 3, 1, 1, 1, 3, /*ASO*/
    0, 3, 1, 3, 1, 1, 3, 3 };

    private ProbingState state;

    private byte lastCharClass;

    private int[] freqCounter;

    public Latin1Prober() {
        super();
        this.freqCounter = new int[FREQ_CAT_NUM];
        reset();
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
}
