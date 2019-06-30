#include <iostream>
#include <stdio.h>
using namespace std;

int d(int num) {
	int sum = num;

	while (num >= 10) {
		sum += num % 10;
		num /= 10;
	}

	sum += num;

	return sum;
}

int main() {
	int N;
	bool flag = false;

	scanf("%d", &N);

	for (int i = 1; i < N; i++) {
		if (d(i) == N) {
			flag = true;
			cout << i << endl;
			break;
		}
	}

	if (!flag) {
		cout << "0" << endl;
	}

	return 0;
}
