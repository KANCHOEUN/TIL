#include <iostream>
#include <stdio.h>
using namespace std;
bool selfN[10001];

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
	// 배열 초기화
	for (int i = 1; i < 10001; i++) {
		selfN[i] = true;
	}

	for (int i = 1; i < 10001; i++) {
		for (int j = d(i); j < 10001; j = d(j)) {
			if (selfN[j]) {
				selfN[j] = false;
			}
		}
	}

	for (int i = 1; i < 10001; i++) {
		if (selfN[i]) {
			cout << i << endl;
		}
	}
	return 0;
}
