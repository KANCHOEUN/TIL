#include <iostream>
#include <stdio.h>
using namespace std;
int a[4];
int b[4];

int main() {
	int sum = 0;
	int max = 0;

	for (int i = 0; i < 4; i++) {
		scanf("%d %d", &a[i], &b[i]);
		sum += b[i];
		sum -= a[i];

		if (sum > max) {
			max = sum;
		}
	}

	printf("%d", max);

	return 0;
}
