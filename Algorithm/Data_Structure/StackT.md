# Stack\<T>

##### 어댑터 클래스 ( adapter class )

: 다른 기능을 제공하기 위해 컨테이너의 기존 인터페이스를 확장한 클래스 템플릿



##### Stack\<T>

: deque\<T> 컨테이너를 **후입선출 ( Last In First Out )** 로 저장하는 방식으로 변환하는 **어댑터 클래스 템플릿**

: stack 헤더에 정의되어 있음



- T& top()

  : 스택이 비어있을 경우, 반환 값 정의되어 있지 않음

  : 스택이 비어있지 않을 경우, top 원소 반환

- void push(const T& obj)

  : 스택 상위에 obj의 복제본 삽입

  : 기반 컨테이너의 push_back() 멤버 호출하여 수행

- void push(T&& ojb)

  : 스택 상위에 obj를 이동하여 삽입

  : 기반 컨테이너의 우측값 참조 매개변수 버전의 push_back() 멤버 호출하여 수행 

- void pop()

  : 스택 상위 원소 삭제

- int size()

  : 스택에 있는 원소의 개수 반환

- bool empty()

  : 스택이 비어있을 경우, true 반환



**백준 10828 번**

스택 STL 로 구현

```c++
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

```



##### 백준 9012번

```c++
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

```

