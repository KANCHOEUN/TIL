#include <iostream>
#include <cstdio>
#define MAX 1000000
using namespace std;

/* 에라토스테네스의 체 활용 */

int main() {
	bool * isPrime = new bool[MAX + 1];

	isPrime[1] = false; // 1은 소수 X

	// 배열 초기화
	for (int i = 2; i <= MAX; i++) {
		isPrime[i] = true;
	}

	// i <= sqrt(MAX) 처럼 math 헤더의 sqrt를 쓸 수도 있음
	for (int i = 2; i * i <= MAX; i++) {
		if (isPrime[i]) {
			for (int j = i * 2; j <= MAX; j += i) {
				isPrime[j] = false;
			}
		}
	}

	int M, N;
	scanf("%d", &M);
	scanf("%d", &N);

	for (int i = M; i <= N; i++) {
		if (isPrime[i]) {
			printf("%d\n", i);
		}
	}

	return 0;
}
