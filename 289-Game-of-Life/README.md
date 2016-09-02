https://leetcode.com/discuss/68352/easiest-java-solution-with-explanation


use two state 00 to show the status,  first bit is next state, second bit is the current state.

00 -> 10
00 -> 00
01 -> 00 we don't have to do any thing,
01 -> 11 

use bit & 1 to get current state,
after all, use >> 1 to get next state
