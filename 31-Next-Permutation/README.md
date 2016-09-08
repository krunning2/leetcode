1. We scan from the end to beginning, if it is ascending order, continue;
2. find the element where it breaks the rule, and swap it with the first element which is greater than it from the end;
3. Reverse rest of the elements.

tips:

1. p should be -1 to get the number 6, 
2. reverse  p  -> end -1, in other words, we should reverse the descending order of the numbers

6-8-7-6-5-4 => 7-8-6-6-5-4 => 7-4-5-6-6-8