#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std;
int arr[1000001];

int BinarySearch(int *a, const int x, const int len) {
  int left = 0;
  int right = len - 1;
  int mid;

  while(left <= right) {
    mid = (left + right) / 2;
    if(x < a[mid]) {
      right = mid - 1;
    }
    else if(x > a[mid]) {
      left = mid + 1;
    }
    else {
      return mid;
    }
  }
  return -1;
}

int main() {
  int T;
  int N, M;
  int x;

  scanf("%d", &T);

  for(int i = 0; i < T; i++) {
    scanf("%d", &N);
    for(int j = 0; j < N; j++) {
      scanf("%d", &arr[j]);
    }
    sort(arr, arr+N);

    scanf("%d", &M);
    for(int k = 0; k < M; k++) {
      scanf("%d", &x);
      if(BinarySearch(arr, x, N) == -1) {
        printf("0\n");
      }
      else {
        printf("1\n");
      }
    }
  }

  return 0;
}
