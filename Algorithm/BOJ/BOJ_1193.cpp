#include <iostream>
#include <cstdio>
using namespace std;

int main() {
	int sum = 0;
  int num = 1;
	int x;
	scanf("%d", &x);

  while(1) {
    if(sum < x && x <= sum + num) {
      break;
    }
    sum += num;
    num++;
  }

  int k = x - sum;
  int nu, de;

  if(num % 2) { // 홀수
    nu = num - (k-1);
    de = k;
  } else { // 짝수
    nu = k;
    de = num - (k-1);
  }

	printf("%d/%d", nu, de);
}
