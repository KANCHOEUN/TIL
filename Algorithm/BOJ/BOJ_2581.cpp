#include <iostream>
#include <cstdio>
#define MAX 10000
using namespace std;

int main() {
  bool * isPrime = new bool[MAX + 1];

  isPrime[1] = false; // 1은 소수에서 제외

  for(int i = 2; i <= MAX; i++) {
    isPrime[i] = true;
  }

  for(int i = 2; i * i <= MAX; i++) {
    if(isPrime[i]) {
      for(int j = i * 2; j <= MAX; j += i) {
        isPrime[j] = false;
      }
    }
  }

  int M, N;
  scanf("%d", &M);
  scanf("%d", &N);

  int sum = 0;
  int min = N;

  for(int i = M; i <= N; i++) {
    if(isPrime[i]) {
      if(min > i) {
        min = i;
      }
      sum += i;
    }
  }

  if(!sum) {
    printf("-1");
  } else {
    printf("%d\n%d\n", sum, min);
  }

  return 0;
}
