/*Really nice solution! Let me try to explain the code with example in the problem description:

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
Then use Karn's aglorithm to do topological sort. This is essentially BFS. https://en.wikipedia.org/wiki/Topological_sorting
