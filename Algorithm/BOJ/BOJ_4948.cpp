#include <iostream>
#define MAX 246912
using namespace std;

/* 에라토스테네스의 체 활용 */

int main()
{
  bool * isPrime = new bool[MAX + 1];

  isPrime[1] = false; // 1은 소수 X

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

  while(1) {
    int N;
    int count = 0;
    cin >> N;

    if(N == 0) {
      break;
    }

    for(int i = N + 1; i <= 2 * N; i++) {
      if(isPrime[i]) {
        count++;
      }
    }

    cout << count << endl;
  }

  return 0;
}
