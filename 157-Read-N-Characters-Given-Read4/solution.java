/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int p_buff = 0;
    private int buffCnt = 0;
    private char[] buff = new char[4];
    public int read(char[] buf, int n) {
        int p = 0;
        while(p < n){
            if(p_buff == 0){
                buffCnt = read4(buff);
            }
            while(p < n && p_buff < buffCnt){
                buf[p++] = buff[p_buff++];
            }
            if(p_buff == buffCnt){
                p_buff = 0;
            }
            if(buffCnt < 4){
                break;
            }
        }
        return p;
    }
}