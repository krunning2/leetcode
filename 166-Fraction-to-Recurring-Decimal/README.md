1. deal with the integral part by a / b
2. deal with the float part
    2.1 Keep map to store the remainder and the start position of possible repeated      numbers.
   2.2 when we find the repeated numbers or remainder = 0, exit the loop and return the result.

idea: if the remainder starts repeating, the results will also start repeating, so we don't have to calculate again. e.g. 22 / 7 =  "3.(142857)"