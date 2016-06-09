idea:
1 keeping a pointer to the last "*" position + 1.
2. if(two characters are same or p.charAt(p1) == '?'), move both pointers to next position.
3. else trackback to the last "*" position + 1, also move s2 to the next position, which means skip one character in s