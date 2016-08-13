// Try to find the left first element and right element which are less than current element, so we can get the max area.
    // So we can maintain a increasing stack

Always compare the first element in the stack, and use the next element to find the length, because it can have a gap. e.g. 3, 4, 5, 6, 4, 3