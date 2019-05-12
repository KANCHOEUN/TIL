#include <iostream>
#include <cstdio>
#include <algorithm>
#define N 7
using namespace std;

int main() {
  int * arr = new int[N];
  int sum = 0;

  for(int i = 0; i < N; i++) {
    scanf("%d", &arr[i]);
    if(!(arr[i] % 2)) {
      arr[i] = 0;
    } else {
      sum += arr[i];
    }
  }

  if(sum) {
    printf("%d\n", sum);
    sort(arr, arr+N);
    for(int i = 0; i < N; i++) {
      if(arr[i]) {
        printf("%d", arr[i]);
        break;
      }
    }
  } else {
    printf("-1");
  }

  return 0;
}
