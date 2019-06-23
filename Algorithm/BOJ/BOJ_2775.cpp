#include <iostream>
#include <stdio.h>
using namespace std;
int a[15][15] = { 0, };

int main() {
	int T, k, n;

	for (int i = 1; i < 15; i++) {
		a[0][i] = i;
	}

	for (int i = 1; i < 15; i++) {
		for (int j = 1; j < 15; j++) {
			for (int k = 1; k <= j; k++) {
				a[i][j] += a[i - 1][k];
			}
		}
	}

	scanf("%d", &T);

	for (int i = 0; i < T; i++) {
		scanf("%d", &k);
		scanf("%d", &n);

		printf("%d\n", a[k][n]);
	}

	return 0;
}
