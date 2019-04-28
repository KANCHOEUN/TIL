#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std;
int arr[1000001];

int BinarySearch(int *a, const int x, const int len) {
	int left = 0;
	int right = len - 1;
	int mid;

	while (left <= right) {
		mid = (left + right) / 2;
		if (x < a[mid]) {
			right = mid - 1;
		}
		else if (x > a[mid]) {
			left = mid + 1;
		}
		else {
			return mid;
		}
	}
	return -1;
}

int main() {
	int N, M;
	int x;

	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}
	sort(arr, arr + N);

	scanf("%d", &M);
	for (int i = 0; i < M; i++) {
		scanf("%d", &x);
		if (BinarySearch(arr, x, N) == -1) {
			printf("0\n");
		}
		else {
			printf("1\n");
		}
	}

	return 0;
}
