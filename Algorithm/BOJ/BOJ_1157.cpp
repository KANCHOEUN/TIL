#include <iostream>
#include <stdio.h>
char arr[1000001];
int used[26] = { 0,  };

int main() {
	int i = 0;
	scanf("%s", arr);

	while (arr[i] != '\0') {
		if ('a' <= arr[i] && arr[i] <= 'z') {
			arr[i] -= 'a' - 'A';
		}
		used[arr[i] - 'A']++;
		i++;
	}

	int max = used[0];
	int flag = 0;
	int index = 0;

	for (int i = 1; i < 26; i++) {
		if (used[i] > max) {
			max = used[i];
			index = i;
		}
	}

	for (int i = 0; i < 26; i++) {
		if (max != 0 && used[i] == max) {
			if (i != index) {
				flag = 1;
			}
		}
	}

	if (flag == 0) {
		printf("%c", 'A' + index);
	}
	else {
		printf("?");
	}

	return 0;
}
