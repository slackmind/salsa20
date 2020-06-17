public class salsa20 {


    final static int ROUNDS = 20;

    // constant values
    final int OUTPUTBYTES = 64;
    final int INPUTBYTES = 16;
    final int KEYBYTES = 64;
    final int CONSTBYTES = 64;
    final int STREAM_KEYBYTES = 64;
    final int STREAM_NONCEBYTES = 64;

    static long rotLeft(int input, int shift) {

        return (input << shift) | (input >>> (32-shift));
    }

    static int load_LittleEndian(byte[] a, int offset) {

        return ((int)(a[offset]) & 0xff) |
                ((((int)(a[offset + 1])&0xff)) << 8) |
                ((((int)(a[offset + 2])&0xff)) << 16) |
                ((((int)(a[offset + 3])&0xff)) << 24);

    }

}
