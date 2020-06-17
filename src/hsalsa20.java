public class hsalsa20 {
    static final int ROUNDS = 20;

    static long rotLeft(int input, int shift) {

        return (input << shift) | (input >>> (32-shift));
    }
}
