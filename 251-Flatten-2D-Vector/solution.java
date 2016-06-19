public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> i2d;
    Iterator<Integer> i1d;
    public Vector2D(List<List<Integer>> vec2d) {
        i2d = vec2d.iterator();
        if(i2d.hasNext()){
            i1d = i2d.next();
        }
    }

    @Override
    public Integer next() {
        i1d.next();
    }

    @Override
    public boolean hasNext() {
        while(i2d.hasNext() || i1d.hasNext()){
            if(i1d.hasNext()){
                return true;
            }else{
                i1d = i2d.next();
            }
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */