import java.util.*;
public class ReadNCharactersGivenRead4_157 {
    /**
     * The API read4 reads four consecutive characters from file, then writes those characters into the buffer array buf4.
     */
    public int read4(char[] buf4) {
        return 0;
    }
    public int read(char[] buf, int n) {
        int to_read = 0;
        char[] buf4 = new char[4];

        while (to_read < n) {
            int n_read = read4(buf4);
            for (int i = 0; i < 4; i++)
                buf[to_read + i] = buf4[i];
            to_read += n_read;
            if (n_read < 4)
                break;
        }

        return Math.min(to_read, n);
    }
}
