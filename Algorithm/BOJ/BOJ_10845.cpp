#include <iostream>
#include <cstdio>
#include <string>
#define MAX 10000
using namespace std;

/* First In First Out */
class Queue {
private:
	int q[MAX];
	int begin; // 원소가 삭제되는 곳
	int end; // 원소가 삽입되는 곳

public:
	Queue() {
		begin = 0;
		end = 0;
	}

	void Push(int x) {
		q[end++] = x;
	}

	void Pop() {
		if (IsEmpty()) {
			cout << "-1" << endl;
		}
		else {
			cout << q[begin++] << endl;
		}
	}

	int Size() const {
		return end - begin;
	}

	int Front() {
		if (IsEmpty()) {
			return -1;
		}
		else {
			return q[begin];
		}
	}

	int Back() {
		if (IsEmpty()) {
			return -1;
		}
		else {
			return q[end-1];
		}
	}

	bool IsEmpty() const {
		return (Size() == 0) ? true : false;
	}
};

int main() {
	Queue q;
	int N;
	string str;

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> str;

		if (!str.compare("push")) {
			int num;
			cin >> num;
			q.Push(num);
		}
		else if (!str.compare("pop")) {
			q.Pop();
		}
		else if (!str.compare("size")) {
			cout << q.Size() << endl;
		}
		else if (!str.compare("empty")) {
			cout << q.IsEmpty() << endl;
		}
		else if (!str.compare("front")) {
			cout << q.Front() << endl;
		}
		else if (!str.compare("back")) {
			cout << q.Back() << endl;
		}
		else {
			cout << "Not available" << endl;
		}
	}

	return 0;
}
