public class Vector2D implements Iterator<Integer> {
    Iterator<Integer> cur = null;
    Iterator<List<Integer>> iterator = null;
    public Vector2D(List<List<Integer>> vec2d) {
        if(vec2d != null){
            iterator = vec2d.iterator();
            if(iterator.hasNext()){
                cur = iterator.next().iterator();
            }
        }
    }

    @Override
    public Integer next() {
        return cur.next();
    }

    @Override
    public boolean hasNext() {
        if(cur == null || !cur.hasNext() && !iterator.hasNext()) return false;
        while(!cur.hasNext() && iterator.hasNext()){
            cur = iterator.next().iterator();
        }
        return cur.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */