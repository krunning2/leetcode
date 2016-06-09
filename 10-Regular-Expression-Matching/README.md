p: a*  baa
s: aaabaa

1. if next char is '*', we need to check all possible char in S that "*" can be replaced. we can start from 0 which means remove a.
We need to check this (p.charAt(pp) == s.charAt(ps) || p.charAt(pp) == '.'), so we can move the ps to next