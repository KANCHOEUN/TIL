#include <iostream>
#include <stdio.h>
#include <string.h>
using namespace std;
int used[26] = { 0, };

int main() {
	int N;
	char str[101];
	bool flag;
	int count = 0;

	scanf("%d", &N);

	for (int i = 0; i < N; i++) {
		memset(used, 0, sizeof(used));
		flag = true;
		cin >> str;

		for (int j = 0; j < strlen(str) - 1; j++) {
			if (used[str[j] - 'a'] == 0) {
				used[str[j] - 'a'] = 1;
			}

			if (str[j] == str[j + 1]) {
				continue;
			} else {
				if (used[str[j+1] - 'a'] == 1) {
					flag = false;
					break;
				}
			}
		}
		if (flag) {
			count++;
		}
	}

	cout << count << endl;

	return 0;
}
