#include <iostream>
#include <cstdio>
#include <string>
#define MAX 10000
using namespace std;

class Stack {
private:
	int s[MAX];
	int top = -1;

public:
	int Size() const {
		return top + 1;
	}

	bool IsEmpty() const {
		if (top == -1) {
			return true;
		}
		else {
			return false;
		}
	}

	int Top() const {
		if (IsEmpty()) {
			return -1;
		}
		else {
			return s[top];
		}
	}

	void Push(int x) {
		if (top == (MAX - 1)) {
			cout << "Stack Overflow" << endl;
			return;
		}
		s[++top] = x;
	}

	void Pop() {
		if (IsEmpty()) {
			cout << "-1" << endl;
		}
		else {
			cout << s[top--] << endl;
		}
	}
};

int main() {
	Stack s;
	int N;
	string str;

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> str;

		if (!str.compare("push")) {
			int num;
			cin >> num;
			s.Push(num);
		}
		else if (!str.compare("pop")) {
			s.Pop();
		}
		else if (!str.compare("size")) {
			cout << s.Size() << endl;
		}
		else if (!str.compare("empty")) {
			cout << s.IsEmpty() << endl;
		}
		else if (!str.compare("top")) {
			cout << s.Top() << endl;
		}
		else {
			cout << "Not available" << endl;
		}
	}

	return 0;
}
