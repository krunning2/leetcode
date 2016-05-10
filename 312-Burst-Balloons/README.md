http://algobox.org/burst-balloons/

i should <= len - k, because j  has to reach [i][len]
for(int i = 1; i <= len - k; i ++){
   int j = i + k;
   for(int x = i; x <= j; x ++)