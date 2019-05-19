#include <iostream>
#include <string>
#include <stack>
using namespace std;
stack<int> s;

/* C++ STL 스택으로 구현 */
int main() {
	int N;
	string str;
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> str;

		if (!str.compare("push")) {
			int num;
			cin >> num;
			s.push(num);
		}
		else if (!str.compare("pop")) {
			if (s.empty()) {
				cout << "-1" << endl;
			}
			else {
				cout << s.top() << endl;
				s.pop();
			}
		}
		else if (!str.compare("size")) {
			cout << s.size() << endl;
		}
		else if (!str.compare("empty")) {
			cout << s.empty() << endl;
		}
		else if (!str.compare("top")) {
			if (s.empty()) {
				cout << "-1" << endl;
			}
			else {
				cout << s.top() << endl;
			}
		}
		else {
			cout << "Not available" << endl;
		}
	}

	return 0;
}
