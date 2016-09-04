public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> lists;
    Iterator<Integer> ints;
    public Vector2D(List<List<Integer>> vec2d) {
        if(vec2d != null){
            lists = vec2d.iterator();
            if(lists.hasNext()){
                ints = lists.next().iterator();
            }
        }
    }

    @Override
    public Integer next() {
        return ints.next();
    }

    @Override
    public boolean hasNext() {
        if(ints == null || !ints.hasNext() && !lists.hasNext()) return false;
        while(!ints.hasNext() && lists.hasNext()){
            ints = lists.next().iterator();
        }
        return ints.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */