/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int bufferCount = 0;
    int bufferPointer = 0;
    char[] buffer = new char[4];
    public int read(char[] buf, int n) {
        int p = 0;
        while(p < n){
            if(bufferPointer == 0){
                bufferCount = read4(buffer);
            }
            //no matter whether it is remaining buffer or the new incoming data, we just need to need them.
            while(p < n && bufferPointer < bufferCount){
                buf[p ++] = buffer[bufferPointer ++];
            }
            //this means we can read complete 4 chars from the file this around
            if(bufferPointer == bufferCount){
                bufferPointer = 0;
            }
            //this means end of file
            if(bufferCount < 4){
                break;
            }
        }
        return p;
    }
}