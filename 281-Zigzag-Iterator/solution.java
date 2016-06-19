public class ZigzagIterator {
    Iterator<Integer> i1;
    Iterator<Integer> i2;
    boolean readV1;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i1 = v1.iterator();
        i2 = v2.iterator();
        readV1 = true;
    }

    public int next() {
        if(readV1){
            readV1 = !readV1;
            return i1.next();
        }else{
            readV1 = !readV1;
            return i2.next();
        }
    }

    public boolean hasNext() {
        if(!readV1 && !i2.hasNext() || readV1 && !i1.hasNext()){
            readV1 = !readV1;
        }
        return i1.hasNext() || i2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */