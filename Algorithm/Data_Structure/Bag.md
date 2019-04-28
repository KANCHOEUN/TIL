## Bag 로 구현 (과제)

1. Bizcard 클래스를 정의한다.

      1.1 멤버 변수는 name과 phone이며 문자열 포인터 변수이다.

      1.2 생성자를 정의한다. 생성자는 이름과 전화번호를 입력받고 동적 메모리를 할당 받아 저장하여

   ​          name과 phone 포인터 변수를 통해 접근할 수 있도록 한다.

      1.3 복사생성자와 대입연산자를 정의한다.

      1.4 소멸자를 정의하여 동적 메모리를 해제한다.

      1.5 이름과 전화번호를 출력하는 ShowInfo() 멤버함수를 정의한다.

2. 프로그램 3.6에서 Bag 용량(capacity)의 초기값은 10이 아닌 3으로 수정

3. 프로그램 3.7에서 Bag의 생성자, 소멸자, Size(), IsEmpty(), Element(), Push(), Pop() 구현

4. 빈 Bag에 대해 Size(), IsEmpty(), Element() 연산 결과 확인

5. Push() 연산을 3번 수행하여 Bizcard 객체를 3개 추가한 후, 연산 결과 확인

6. Push() 연산을 4번 수행하여 Bizcard 객체를 총 7개 추가한 후, 연산 결과 확인     

7. Pop() 연산을 2번 수행하여 Bizcard 객체를 2개 삭제한 후, 연산 결과 확인



```C++
#include <iostream>
#include <cstdlib>
#include <cstring>
#include <ctime>
using namespace std;

// 1. Bizcard 클래스 정의
class Bizcard
{
private:
// 1.1 멤버 변수는 name과 phone이며 문자열 포인터 변수
  char * name;
  char * phone;

public:
// 1.2 생성자를 정의
  Bizcard(const char * name, const char * phone)
  {
    this->name = new char[strlen(name) + 1];
    this->phone = new char[strlen(phone) + 1];

    strcpy(this->name, name);
    strcpy(this->phone, phone);
  }

// 1.3 복사 생성자와 대입 연산자를 정의
  Bizcard(const Bizcard &copy)
  {
    name = new char[strlen(copy.name) + 1];
    phone = new char[strlen(copy.phone) + 1];

    strcpy(name, copy.name);
    strcpy(phone, copy.phone);
  }

  Bizcard& operator=(const Bizcard &copy)
  {
    delete []name;
    delete []phone;

    name = new char[strlen(copy.name) + 1];
    phone = new char[strlen(copy.name) + 1];

    strcpy(name, copy.name);
    strcpy(phone, copy.phone);

    return *this;
  }

// 1.5 Showinfo() 멤버함수를 정의 : 이름과 전화번호를 출력
  void ShowInfo() const
  {
    cout << "이름 " << name;
    cout << ", 전화번호 " << phone << endl;
  }

  // 1.4 소멸자를 정의하며 동적 메모리를 해제
  ~Bizcard()
  {
    delete []name;
    delete []phone;
  }
};

// 2. 템플릿 클래스 Bag 정의
template <class T>
class Bag
{
public:
  Bag(int bagCapacity = 3);
  ~Bag();

  int Size() const;
  bool IsEmpty() const;
  T& Element() const;

  void Push(const T&);
  void Pop();

private:
  T * array;
  int capacity;
  int top;
};

// 3. Bag 연산 구현
template <class T>
Bag<T>::Bag(int bagCapacity) :capacity(bagCapacity)
{
  if(capacity < 1)
  {
    throw "Capacity must be > 0";
  }
  array = new T[capacity];
  top = -1;
}

template <class T>
Bag<T>::~Bag()
{
  delete [] array;
}

template <class T>
int Bag<T>::Size() const
{
  return top + 1;
}

template <class T>
bool Bag<T>::IsEmpty() const
{
  if(top == -1)
  {
    return true;
  }
  else
  {
    return false;
  }
}

template <class T>
T& Bag<T>::Element() const
{
  if(IsEmpty())
  {
    throw "Bag is empty";
  }
  srand((unsigned int)time(NULL));
  return array[rand() % (top+1)];
}

template <class T>
void Bag<T>::Push(const T& x)
{
  if(capacity == top + 1)
  {
    ChangeSize1D(array, capacity, 2 * capacity);
    capacity *= 2;
  }
  array[++top] = x;
}

template <class T>
void Bag<T>::Pop()
{
  if(IsEmpty())
  {
    throw "Bag is empty, cannot delete";
  }
  int deletePos = top / 2;
  copy(array + deletePos + 1, array + top + 1, array + deletePos);
  array[top--].~T(); // destructor for T
}

template <class T>
void ChangeSize1D(T* (&a), const int oldSize, const int newSize)
{
  T* temp = new T[newSize];
  copy(a, a + oldSize, temp);
  delete [] a;
  a = temp;
}

int main()
{
  Bag<Bizcard *> bag;

  // 4. 빈 Bag에 대해 연산 결과 확인
  try
  {
    cout << "빈 Bag에 대해 Size(), IsEmpty(), Element() 연산 결과" << endl;
    cout << "Size() : " << bag.Size() << endl;
    cout << "IsEmpty() : " << (bag.IsEmpty() ? "true" : "false") << endl;
    cout << "Element() : " ;
    bag.Element()->ShowInfo();
  }
  catch(const char * str)
  {
    cout << str << endl;
  }

  // 5. Push() 연산을 3번 수행하여 Bizcard 객체를 3개 추가한 후 연산 결과 확인
  cout << "\nPush() 연산을 3번 수행하여 Bizcard 객체를 3개 추가한 후 연산 결과" << endl;
  bag.Push(new Bizcard( "북극곰", "01012345678"));
  bag.Push(new Bizcard( "아보카도", "01064271234"));
  bag.Push(new Bizcard( "만지", "01075927281"));
  cout << "Size() : " << bag.Size() << endl;
  cout << "IsEmpty() : " << (bag.IsEmpty() ? "true" : "false") << endl;
  cout << "Element() : " ;
  bag.Element()->ShowInfo();

  // 6. Push() 연산을 4번 수행하여 Bizcard 객체를 총 7개 추가한 후 연산 결과 확인
  cout << "\nPush() 연산을 4번 수행하여 Bizcard 객체를 7개 추가한 후 연산 결과" << endl;
  bag.Push(new Bizcard( "시바견", "01083518234"));
  bag.Push(new Bizcard( "티라노", "01052729402"));
  bag.Push(new Bizcard( "쟈가비", "01038291029"));
  bag.Push(new Bizcard( "돌을씹", "01094826271"));
  cout << "Size() : " << bag.Size() << endl;
  cout << "IsEmpty() : " << (bag.IsEmpty() ? "true" : "false") << endl;
  cout << "Element() : " ;
  bag.Element()->ShowInfo();

  // 7. Pop() 연산을 2번 수행하여 Bizcard 객체를 2개 삭제한 후 연산 결과 확인
  cout << "\nPop() 연산을 2번 수행하여 Bizcard 객체를 2개 삭제한 후 연산 결과" << endl;
  bag.Pop();
  bag.Pop();
  cout << "Size() : " << bag.Size() << endl;
  cout << "IsEmpty() : " << (bag.IsEmpty() ? "true" : "false") << endl;
  cout << "Element() : " ;
  bag.Element()->ShowInfo();

  return 0;
}

```