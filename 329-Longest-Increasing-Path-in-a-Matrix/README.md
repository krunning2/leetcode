Do DFS from every cell
Compare every 4 direction and skip cells that are out of boundary or smaller
Get matrix max from every cell's max
Use matrix[][] > cur, so don't need visited[][] 
The key is to cache the distance because it's highly possible to revisit a cell