public class salsa20 {


    final static int ROUNDS = 20;

    // constant values
    final int OUTPUT_BYTES = 64;
    final int INPUT_BYTES = 16;
    final int KEY_BYTES = 64;
    final int CONST_BYTES = 64;
    final int STREAM_KEY_BYTES = 64;
    final int STREAM_NONCE_BYTES = 64;

    static long rotLeft(int input, int shift) {

        return (input << shift) | (input >>> (32-shift));
    }

    static int load_LittleEndian(byte[] a, int offset) {

        return ((int)(a[offset]) & 0xff) |
                ((((int)(a[offset + 1])&0xff)) << 8) |
                ((((int)(a[offset + 2])&0xff)) << 16) |
                ((((int)(a[offset + 3])&0xff)) << 24);

    }

    static void store_LittleEndian(byte[] a, int offset, int b)
    {
        a[offset] = (byte) b;
        b >>>= 8;
        a[offset + 1] = (byte) b;
        b >>>= 8;
        a[offset + 2] = (byte) b;
        b >>>= 8;
        a[offset + 3] = (byte) b;
    }

    public static int crypto_core(byte[] outv, byte[] inv, byte[] k, byte[] c)
    {
        int x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15;
        int j0, j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15;

        j0 = x0 = load_LittleEndian(c, 0);
        j1 = x1 = load_LittleEndian(k, 0);
        j2 = x2 = load_LittleEndian(k, 4);
        j3 = x3 = load_LittleEndian(k, 8);
        j4 = x4 = load_LittleEndian(k, 12);
        j5 = x5 = load_LittleEndian(c, 4);
        j6 = x6 = load_LittleEndian(inv, 0);
        j7 = x7 = load_LittleEndian(inv, 4);
        j8 = x8 = load_LittleEndian(inv, 8);
        j9 = x9 = load_LittleEndian(inv, 12);
        j10 = x10 = load_LittleEndian(c, 8);
        j11 = x11 = load_LittleEndian(k, 16);
        j12 = x12 = load_LittleEndian(k, 20);
        j13 = x13 = load_LittleEndian(k, 24);
        j14 = x14 = load_LittleEndian(k, 28);
        j15 = x15 = load_LittleEndian(c, 12);

        for (int i = ROUNDS; i > 0; i -= 2)
        {
            x4 ^= rotLeft(x0 + x12, 7);
            x8 ^= rotLeft(x4 + x0, 9);
            x12 ^= rotLeft(x8 + x4, 13);
            x0 ^= rotLeft(x12 + x8, 18);
            x9 ^= rotLeft(x5 + x1, 7);
            x13 ^= rotLeft(x9 + x5, 9);
            x1 ^= rotLeft(x13 + x9, 13);
            x5 ^= rotLeft(x1 + x13, 18);
            x14 ^= rotLeft(x10 + x6, 7);
            x2 ^= rotLeft(x14 + x10, 9);
            x6 ^= rotLeft(x2 + x14, 13);
            x10 ^= rotLeft(x6 + x2, 18);
            x3 ^= rotLeft(x15 + x11, 7);
            x7 ^= rotLeft(x3 + x15, 9);
            x11 ^= rotLeft(x7 + x3, 13);
            x15 ^= rotLeft(x11 + x7, 18);
            x1 ^= rotLeft(x0 + x3, 7);
            x2 ^= rotLeft(x1 + x0, 9);
            x3 ^= rotLeft(x2 + x1, 13);
            x0 ^= rotLeft(x3 + x2, 18);
            x6 ^= rotLeft(x5 + x4, 7);
            x7 ^= rotLeft(x6 + x5, 9);
            x4 ^= rotLeft(x7 + x6, 13);
            x5 ^= rotLeft(x4 + x7, 18);
            x11 ^= rotLeft(x10 + x9, 7);
            x8 ^= rotLeft(x11 + x10, 9);
            x9 ^= rotLeft(x8 + x11, 13);
            x10 ^= rotLeft(x9 + x8, 18);
            x12 ^= rotLeft(x15 + x14, 7);
            x13 ^= rotLeft(x12 + x15, 9);
            x14 ^= rotLeft(x13 + x12, 13);
            x15 ^= rotLeft(x14 + x13, 18);
        }

        x0 += j0;
        x1 += j1;
        x2 += j2;
        x3 += j3;
        x4 += j4;
        x5 += j5;
        x6 += j6;
        x7 += j7;
        x8 += j8;
        x9 += j9;
        x10 += j10;
        x11 += j11;
        x12 += j12;
        x13 += j13;
        x14 += j14;
        x15 += j15;

        store_LittleEndian(outv, 0, x0);
        store_LittleEndian(outv, 4, x1);
        store_LittleEndian(outv, 8, x2);
        store_LittleEndian(outv, 12, x3);
        store_LittleEndian(outv, 16, x4);
        store_LittleEndian(outv, 20, x5);
        store_LittleEndian(outv, 24, x6);
        store_LittleEndian(outv, 28, x7);
        store_LittleEndian(outv, 32, x8);
        store_LittleEndian(outv, 36, x9);
        store_LittleEndian(outv, 40, x10);
        store_LittleEndian(outv, 44, x11);
        store_LittleEndian(outv, 48, x12);
        store_LittleEndian(outv, 52, x13);
        store_LittleEndian(outv, 56, x14);
        store_LittleEndian(outv, 60, x15);

        return 0;
    }


}
