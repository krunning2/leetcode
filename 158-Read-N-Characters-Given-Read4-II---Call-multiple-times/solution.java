/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] buffer = new char[4];
    int bufferPointer = 0;
    int bufferCount = 0;
    public int read(char[] buf, int n) {
        int p = 0;
        while(p < n){
            if(bufferPointer == 0){
                bufferCount = read4(buffer);
            }
            while(p < n && bufferPointer < bufferCount){
                buf[p++] = buffer[bufferPointer++];
            }
            if(bufferPointer == bufferCount) bufferPointer = 0;
            if(bufferCount < 4) break;
        }
        return p;
    }
}