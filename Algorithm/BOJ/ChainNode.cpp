#include <iostream>
#include <numeric>
using namespace std;

template <class T> class Chain;
template <class T> class ChainIterator;

template <class T>
class ChainNode {
	friend class Chain<T>;
	friend class ChainIterator<T>;

private:
	T data;
	ChainNode<T> *link;

public:
	ChainNode(T  e) {
		data = e;
		link = NULL;
	}
};

template <class T>
class Chain {
private:
	ChainNode<T> * first;
	ChainNode<T> * last;

public:
	class ChainIterator; // 중첩 클래스

	Chain();
	~Chain();

	T& Front();
	T& Back();
	T& Get(int);
	void InsertFront(const T&);
	void InsertBack(const T&);
	void InsertNext(int i, const T);
	void DeleteFront();
	void DeleteBack();
	void Delete(int i);

	ChainIterator begin() {
		return ChainIterator(first);
	}
	ChainIterator end() {
		return ChainIterator(NULL);
	}
};

// 1. 초기에 공백 체인을 생성하는 생성자
template <class T>
Chain<T>::Chain() {
	first = NULL;
	last = NULL;
}

// 2. 체인의 모든 원소를 삭제하는 파괴자
template <class T>
Chain<T>::~Chain() {
	while (first) {
		DeleteFront();
	}
}

// 3. 체인의 맨 앞에 삽입하는 함수
template <class T>
void Chain<T>::InsertFront(const T& e) {
	if (first) { // 공백 체인이 아닐 경우
		ChainNode<T> * newNode = new ChainNode<T>(e);
		newNode->link = first;
		first = newNode;
	}
	else { // 공백 체인인 경우
		first = last = new ChainNode<T>(e);
	}
}

// 4. 체인의 맨 뒤에 삽입하는 함수
template <class T>
void Chain<T>::InsertBack(const T& e) {
	if (first) { // 공백 체인이 아닐 경우
		ChainNode<T> * newNode = new ChainNode<T>(e);
		last->link = newNode;
		last = last->link;
	}
	else { // 공백 체인인 경우
		first = last = new ChainNode<T>(e);
	}
}

// 5. 리스트의 첫 번째 원소(0번째 원소)를 반환하는 Front 함수
template <class T>
T& Chain<T>::Front() {
	if (first) {
		return first->data;
	}
	else {
		throw "Chain is Empty.";
	}
}

// 6. 리스트의 마지막 원소를 반환하는 Back 함수
template <class T>
T& Chain<T>::Back() {
	if (first) {
		return last->data;
	}
	else {
		throw "Chain is Empty.";
	}
}

// 7. 리스트의 i번째 원소를 반환하는 함수 Get(i)
template <class T>
T& Chain<T>::Get(int i) {
	if (first) {
		ChainNode<T> * e = first;
		for (int j = 0; j < i; j++) {
			e = e->link;
		}
		return e->data;
	}
	else {
		throw "Chain is Empty.";
	}
}

// 8. 체인의 맨 앞에서 삭제하는 함수
template <class T>
void Chain<T>::DeleteFront() {
	if (first) {
		ChainNode<T> * delNode = first;
		if (first->link == NULL) {
			// first와 last가 가리키는 곳이 같을 경우,
			// 즉 Chain의 원소가 하나일 경우
			first = last = NULL;
			delete delNode;
		}
		else {
			first = first->link;
			delete delNode;
		}
	}
	else { // 공백 체인인 경우 예외 처리
		throw "Chain is Empty.";
	}
}

// 9. 체인의 맨 뒤에서 삭제하는 함수
template <class T>
void Chain<T>::DeleteBack() {
	if (first) {
		ChainNode<T> * tmp = first;
		for (; tmp->link != last; tmp = tmp->link);
		tmp->link = NULL;
		delete last;
		last = tmp;
	}
	else { // 공백 체인인 경우 예외 처리
		throw "Chain is Empty.";
	}
}

// 10. i 번째 원소 뒤에 삽입하는 함수
template <class T>
void Chain<T>::InsertNext(int i, const T e) {
	if (first) {
		ChainNode<T> * newNode = new ChainNode<T>(e);
		ChainNode<T> * tmp = first;
		for (int j = 0; j < i; j++) {
			tmp = tmp->link;
		}
		newNode->link = tmp->link;
		tmp->link = newNode;
	}
	else {
		throw "Chain is Empty.";
	}
}

// 11. i 번째 원소를 삭제하는 함수
template <class T>
void Chain<T>::Delete(int i) {
	if (first) {
		ChainNode<T> * delNode = first;
		ChainNode<T> * tmp = first;
		if (tmp->link != NULL) {
			for (int j = 0; j < i - 1; j++) {
				delNode = delNode->link;
				tmp = tmp->link;
			}
			delNode = delNode->link;
			tmp->link = delNode->link;
			delete delNode;
		}
		else {
			DeleteFront();
		}
	}
	else { // 공백 체인인 경우 예외 처리
		throw "Chain is Empty.";
	}
}

// 12. 반복자
template <class T>
class Chain<T>::ChainIterator {
private:
	ChainNode <T> * current;

public:
	ChainIterator(ChainNode <T> * startNode = NULL) {
		current = startNode;
	}

	T& operator*() const {
		return current->data;
	}
	T* operator->() const {
		return &current->data;
	}

	ChainIterator& operator++() {
		current = current->link;
		return *this;
	}
	ChainIterator operator++(int) {
		ChainIterator old = *this;
		current = current->link;
		return old;
	}

	bool operator!=(const ChainIterator right) const {
		return current != right.current;
	}
	bool operator==(const ChainIterator right) const {
		return current == right.current;
	}
};

class Number {
private:
	int num;
public:
	Number(int n = 0) : num(n) {
	}
	Number& operator=(const Number& ref) {
		num = ref.num;
		return *this;
	}
	operator int() {
		return num;
	}
	void ShowNumber() {
		cout << num << endl;
	}
};

/* 테스트 방법 */
int main() {
	// 1. 1부터 9까지의 정수를 갖는 객체를 추가
	Chain<Number> c;
	Chain<Number>::ChainIterator ci = c.begin();
	int sum = 0;

	for (int i = 1; i < 10; i++) {
		c.InsertBack(i);
	}

	// 2. 체인의 각 노드들을 출력
	for (ci = c.begin(); ci != c.end(); ci++) {
		cout << *ci << " ";
	}
	cout << "\n";

	// 3. 0을 맨 앞에 삽입
	c.InsertFront(0);

	// 4. 전체 노드의 값과 총합을 출력
	for (ci = c.begin(); ci != c.end(); ci++) {
		cout << *ci << " ";
	}
	cout << "\n";
	sum = accumulate(c.begin(), c.end(), 0);
	cout << "총합 : " << sum << endl;

	// 5. 10을 맨 뒤에 삽입
	c.InsertBack(10);

	// 6. 전체 노드의 값과 총합을 출력
	for (ci = c.begin(); ci != c.end(); ci++) {
		cout << *ci << " ";
	}
	cout << "\n";
	sum = accumulate(c.begin(), c.end(), 0);
	cout << "총합 : " << sum << endl;

	// 7. Front 를 호출하여 0이 나오는지 확인
	cout << "Front 호출 : " << c.Front() << endl;

	// 8. Back 을 호출하여 10이 나오는지 확인
	cout << "Back 호출 : " << c.Back() << endl;

	// 9. Get(2) 를 호출하여 2가 나오는지 확인
	cout << "Get(2) 호출 : " << c.Get(2) << endl;

	// 10. 맨 앞에 있는 0을 삭제
	c.DeleteFront();

	// 11. 전체 노드의 값과 총합을 출력
	for (ci = c.begin(); ci != c.end(); ci++) {
		cout << *ci << " ";
	}
	cout << endl;
	sum = accumulate(c.begin(), c.end(), 0);
	cout << "총합 : " << sum << endl;

	// 12. 맨 뒤에 있는 10을 삭제
	c.DeleteBack();

	// 13. 전체 노드의 값과 총합을 출력
	for (ci = c.begin(); ci != c.end(); ci++) {
		cout << *ci << " ";
	}
	cout << endl;
	sum = accumulate(c.begin(), c.end(), 0);
	cout << "총합 : " << sum << endl;

	// 14. 3과 4 노드 사이에 100을 삽입 : 즉 2번째 원소 뒤에 삽입
	cout << "2번째 원소 뒤에 100 삽입 : ";
	c.InsertNext(2, 100);

	// 15. 전체 노드의 값과 총합을 출력
	for (ci = c.begin(); ci != c.end(); ci++) {
		cout << *ci << " ";
	}
	cout << endl;
	sum = accumulate(c.begin(), c.end(), 0);
	cout << "총합 : " << sum << endl;

	// 16. 6번째 원소를 삭제
	c.Delete(6);

	// 17. 전체 노드의 값과 총합을 출력
	for (ci = c.begin(); ci != c.end(); ci++) {
		cout << *ci << " ";
	}
	cout << endl;
	sum = accumulate(c.begin(), c.end(), 0);
	cout << "총합 : " << sum << endl;

	return 0;
}
