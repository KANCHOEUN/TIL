#include <iostream>
#include <algorithm>
using namespace std;

template <class K, class E> class BST;

template <class T>
class TreeNode {
	template<class K, class E> friend class BST;

	TreeNode(T data) {
		this->data = data;
		leftChild = rightChild = NULL;
	}
private:
	T data;
	TreeNode<T> * leftChild;
	TreeNode<T> * rightChild;
};

// 이원 탐색 트리 클래스
template <class K, class E>
class BST {
private:
	TreeNode<pair<K, E> > * root;

public:
	BST() {
		root = NULL;
	}
	pair<K, E> * Get(const K&);
	pair<K, E> * Get(TreeNode <pair<K, E>> *, const K&);
	void Inorder();
	void Inorder(TreeNode <pair<K, E>> *);
	void Insert(const pair<K, E> &);
	void Delete(const K&);
};

template <class K, class E>
pair<K, E>* BST<K, E>::Get(const K& k) {
	return Get(root, k);
}

template <class K, class E>
pair<K, E>* BST<K, E>::Get(TreeNode <pair<K, E>> * p, const K &k) {
	if (!p) {
		return 0;
	}
	if (k < p->data.first) {
		return Get(p->leftChild, k);
	}
	if (k > p->data.first) {
		return Get(p->rightChild, k);
	}
	return &p->data;
}

template <class K, class E>
void BST<K, E>::Inorder() {
	Inorder(root);
	cout << endl;
}

template <class K, class E>
void BST<K, E>::Inorder(TreeNode<pair<K, E>> * currentNode) {
	if (currentNode) {
		Inorder(currentNode->leftChild);
		cout << currentNode->data.second << " ";
		Inorder(currentNode->rightChild);
	}
}

template <class K, class E>
void BST<K, E>::Insert(const pair<K, E> & thePair) {
	TreeNode<pair<K, E>> *p = root;
	TreeNode<pair<K, E>> *pp = NULL;
	while (p) {
		pp = p;
		if (thePair.first < p->data.first) {
			p = p->leftChild;
		}
		else if (thePair.first > p->data.first) {
			p = p->rightChild;
		}
		else {
			p->data.second = thePair.second;
			return;
		}
	}

	p = new TreeNode<pair<K, E>>(thePair);
	if (root) { // 트리가 비어있지 않는 경우
		if (thePair.first < pp->data.first) {
			pp->leftChild = p;
		}
		else {
			pp->rightChild = p;
		}
	}
	else {
		root = p;
	}
}

template <class K, class E>
void BST<K, E>::Delete(const K& k) {
	TreeNode<pair<K, E>> *p = root;
	TreeNode<pair<K, E>> *pp = NULL;
	TreeNode<pair<K, E>> *del = NULL;
	int l = 0; // p가 pp의 leftChild인지 rightChild인지 확인하기 위한 용도

	while (p) {
		if (k < p->data.first) {
			pp = p;
			p = p->leftChild;
		}
		else if (k > p->data.first) {
			pp = p;
			p = p->rightChild;
		}
		else {
			del = p;
			break;
		}
	}

	if (!del) {
		// 삭제할 노드가 없는 경우
		cout << "삭제할 노드가 없습니다." << endl;
		return;
	}
	l = pp->leftChild == p ? 1 : 2;
	if (del->leftChild == NULL && del->rightChild == NULL) {
		// 자식 노드가 없는 경우
		switch (l) {
		case 1:
			pp->leftChild = NULL;
			delete del;
			return;
		case 2:
			pp->rightChild = NULL;
			delete del;
			return;
		}
	}
	else if (del->leftChild == NULL) {
		// 자식 노드가 1개인 경우 중 leftChild 값이 없는 경우
		switch (l) {
		case 1:
			pp->leftChild = del->rightChild;
			delete del;
			return;
		case 2:
			pp->rightChild = del->rightChild;
			delete del;
			return;
		}
	}
	else if (del->rightChild == NULL) {
		// 자식 노드가 1개인 경우 중 rightChild 값이 없는 경우
		switch (l) {
		case 1:
			pp->leftChild = del->leftChild;
			delete del;
			return;
		case 2:
			pp->rightChild = del->leftChild;
			delete del;
			return;
		}
	}
	else {
		// 자식 노드가 2개인 경우 : 왼쪽 서브 트리의 가장 큰 원소로 대체
		TreeNode<pair<K, E>> * p1 = p->leftChild;
		TreeNode<pair<K, E>> * pp1 = NULL;

		while (p1->rightChild != NULL) {
			pp1 = p1;
			p1 = p1->rightChild;
		}

		pp1->rightChild = p1->leftChild;
		p1->leftChild = del->leftChild;
		p1->rightChild = del->rightChild;
		switch (l) {
		case 1:
			pp->leftChild = p1;
			delete del;
			return;
		case 2:
			pp->rightChild = p1;
			delete del;
			return;
		}
	}
}

int main() {
	// TreeNode를 pair로 표현
	BST<int, int> Tree;
	pair<int, int> * leaf;

	// 1. Insert 함수 사용 : 이원 탐색 트리의 노드 추가
	Tree.Insert(make_pair(8, 88));
	Tree.Insert(make_pair(4, 44));
	Tree.Insert(make_pair(9, 99));
	Tree.Insert(make_pair(2, 22));
	Tree.Insert(make_pair(1, 11));
	Tree.Insert(make_pair(6, 66));
	Tree.Insert(make_pair(3, 33));
	Tree.Insert(make_pair(5, 55));
	Tree.Insert(make_pair(7, 77));

	// 2. Inorder 함수 사용 : 중위 순회를 수행하여 노드의 second 값 출력
	Tree.Inorder();

	// 3. Delete 함수 사용 : 노드 4 삭제
	Tree.Delete(4);

	// 4. Inorder 함수 사용 : 중위 순회를 수행하여 노드의 second 값 출력
	Tree.Inorder();

	// 5. Delete 함수 사용 : 노드 5 삭제
	Tree.Delete(5);

	// 6. Inorder 함수 사용 : 중위 순회를 수행하여 노드의 second 값 출력
	Tree.Inorder();

	// 7. Delete 함수 사용 : 노드 2 삭제
	Tree.Delete(2);

	// 8. Inorder 함수 사용 : 중위 순회를 수행하여 노드의 second 값 출력
	Tree.Inorder();

	// 9. Get 함수 사용 : 노드 2가 있는지 확인하여 second 결과 출력
	leaf = Tree.Get(2);
	if (leaf) {
		cout << leaf->second << endl;
	}
	else {
		cout << "찾는 노드가 없습니다." << endl;
	}

	// 10. Get 함수 사용 : 노드 9가 있는지 확인하여 second 결과 출력
	leaf = Tree.Get(9);
	if (leaf) {
		cout << leaf->second << endl;
	}
	else {
		cout << "찾는 노드가 없습니다." << endl;
	}

	return 0;
}
