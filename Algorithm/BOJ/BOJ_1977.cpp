#include <iostream>
#include <stdio.h>
using namespace std;

int main() {
	int M, N;
	scanf("%d", &M);
	scanf("%d", &N);

	int sum = 0;
	int min;

	for (int i = 1; i * i <= N; i++) {
		if (M <= i * i && i * i <= N) {
			if (sum == 0) {
				min = i * i;
			}
			sum += i * i;
		}
	}

	if (sum == 0) {
		printf("-1");
	}
	else {
		printf("%d\n", sum);
		printf("%d", min);
	}

	return 0;
}
