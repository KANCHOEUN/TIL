#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		stack<char> s;
		bool flag = true;
		string str;
		cin >> str;

		for (int j = 0; j < (int) str.length(); j++) {
			if (str.at(j) == '(') {
				s.push('(');
			}
			else {
				if (s.empty()) {
					flag = false;
				}
				else {
					s.pop();
				}
			}
		}
		if (!s.empty()) {
			flag = false;
		}
		if (flag) {
			cout << "YES" << endl;
		}
		else {
			cout << "NO" << endl;
		}
	}

	return 0;
}
