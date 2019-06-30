#include <iostream>
#include <stdio.h>
using namespace std;
bool selfN[10001] = { 0, };

int d(int num) {
	int sum = num;

	if (num >= 1000) {
		sum += num / 1000;
		num %= 1000;
	}
	if (num >= 100) {
		sum += num / 100;
		num %= 100;
	}
	if (num >= 10) {
		sum += num / 10;
		num %= 10;
	}
	if (num > 0) {
		sum += num;
	}

	return sum;
}

int main() {
	for (int i = 1; i < 10001; i++) {
		if (d(i) < 10001) {
			selfN[d(i)] = true;
		}
	}

	for (int i = 1; i < 10001; i++) {
		if (!selfN[i]) {
			cout << i << endl;
		}
	}
	return 0;
}
