#include <iostream>
#include <stdio.h>
using namespace std;
char c[8][8] = { 0, };

int main() {
	int count = 0;

	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
			scanf("%c", &c[i][j]);
		}
		getchar();
	}

	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
			if (c[i][j] == 'F' && (i + j) % 2 == 0) {
				count++;
			}
		}
	}

	printf("%d", count);

	return 0;
}
