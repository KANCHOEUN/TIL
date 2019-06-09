#include <iostream>
#include <stdio.h>
char arr[1000001];
int used[9] = { 0,  };

int main() {
	int i = 0;
	int max = 0;
	scanf("%s", arr);

	while (arr[i] != '\0') {
		if (arr[i] == '6' || arr[i] == '9') {
			used[6]++;
		}
		else {
			used[arr[i] - '0']++;
		}
		i++;
	}

	used[6] = (used[6] + 1) / 2;

	i = 0;

	for (int i = 0; i < 9; i++) {
		if (used[i] > max) {
			max = used[i];
		}
	}

	printf("%d", max);
	return 0;
}
