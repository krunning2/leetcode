Let miss as the number which we already know we can build all sums in [0,miss). So if the num[i] <= miss, we know we can form the sum to [0, miss + num[i]), else we simply patch Miss itself as the number to form [0, miss + miss);

if there is no more element in the num[], we also patch Miss.

