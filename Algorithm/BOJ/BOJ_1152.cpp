#include <stdio.h>
#define MAX 1000001

int main() {
	int i = 0;
	int count = 1;
	char str[MAX];

	gets(str);

	while (str[i] != '\0') {
		if (str[i] == ' ' && str[i + 1] != '\0') {
			count++;
		}
		i++;
	}

	if (str[0] == '\0' || str[0] == ' ') {
		count--;
	}

	printf("%d", count);

	return 0;
}
