1.build a graph with edge and degree with two maps, one is for degree, another is for the neighborhood and edges
2.using set to avoid the duplicate edges
3.Go BFS
  3.1 Push the in-degree == 0 node to queue
  3.2 Decrease the degree by 1 when removing the dependent node.
  3.3 Push the in-degree == 0 node to queue
4. In case of circle or invalid list, we should check the size of degree map and the length of result string.


First, build a degree map for each character in all the words:

w:0
r:0
t:0
f:0
e:0
Then build the hashmap by comparing the adjacent words, the first character that is different between two adjacent words reflect the lexicographical order. For example:

 "wrt",
 "wrf",
    first different character is 3rd letter, so t comes before f

 "wrf",
 "er",
    first different character is 1rd letter, so w comes before e
The characters in set come after the key. x->y means letter x comes before letter y. x -> set: y,z,t,w means x comes before all the letters in the set. The final HashMap "map" looks like.

t -> set: f    
w -> set: e
r -> set: t
e -> set: r
and final HashMap "degree" looks like, the number means "how many letters come before the key":

w:0
r:1
t:1
f:1
e:1
Then use Karn's aglorithm to do topological sort. This is essentially BFS. 
计数时需要注意的是，我们不能将同样一条边计数两次，所以要用一个集合来排除已经计数过的边。
https://en.wikipedia.org/wiki/Topological_sorting