http://www.cnblogs.com/yrbbest/p/5058571.html

Define C[i] = A[i - 2^k + 1] + ....A[i] where k is the total count of 0 on the tail. e.g. i = 11000 -> k = 3, C[0] = 0;
so C[i] = A[11001] + .... + A[11000]
so use lowbit to calculate 2^k where lobit = i & -i 

So we can easily find that the (parent of C[i]) = C[i + lowbit(i)]

void plus(int pos, int num){
  while(pos <= n){
    C[pos] += sum;
    pos = lowbit(pos) + pos;
  }
}

Also S[11000] = C[11000] + C[10000], S[i] is the sum from 0...i; 
because C[11000] has 2^3 from A[10001]...A[11000] and C[10000] from A[00001] ... A[10000] has 2^4 numbers

int getSum(int i){
  int sum = 0;
  while(i >= 0){
    sum += C[i];
    i = i - lowbit(i);
  }
}
