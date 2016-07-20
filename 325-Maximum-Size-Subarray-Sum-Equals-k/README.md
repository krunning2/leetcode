sum[i...j] = sum[0...i] - sum[0..j-1];
Keep a hash map to store the sum and the index for sum[0..i].
Also keep finding the possible solution and compare the length to the maxLength