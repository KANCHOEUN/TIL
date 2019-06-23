#include <iostream>
#include <stdio.h>
using namespace std;

int main() {
	int n;
	int a, b, c;

	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d %d %d", &a, &b, &c);
		printf("Scenario #%d: \n", i + 1);

		a = a * a;
		b = b * b;
		c = c * c;

		if (a + b == c || a + c == b || b + c == a) {
			printf("yes\n");
		}
		else {
			printf("no\n");
		}
		printf("\n");
	}

	return 0;
}
