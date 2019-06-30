#include <iostream>
#include <stdio.h>
using namespace std;

int main() {
	int K, N, M;
	int money;

	scanf("%d %d %d", &K, &N, &M);

	money = K * N - M;

	if (money < 0) {
		printf("0");
	}
	else {
		printf("%d", money);
	}

	return 0;
}
