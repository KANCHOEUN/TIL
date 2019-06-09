#include <iostream>
#include <queue>
#include <string>
#define MAX 10000
using namespace std;
queue<int> q;

/* C++ STL Queue 로 구현 */
int main() {
  int N;
  string str;
  cin >> N;

  for(int i = 0; i < N; i++) {
    cin >> str;

    if(!str.compare("push")) {
      int num;
      cin >> num;
      q.push(num);
    } else if(!str.compare("pop")) {
      if(q.empty()) {
        cout << "-1" << endl;
      } else {
        cout << q.front() << endl;
        q.pop();
      }
    } else if(!str.compare("size")) {
      cout << q.size() << endl;
    } else if(!str.compare("empty")) {
      cout << q.empty() << endl;
    } else if(!str.compare("front")) {
      if(q.empty()) {
        cout << "-1" << endl;
      } else {
        cout << q.front() << endl;
      }
    } else if(!str.compare("back")) {
      if(q.empty()) {
        cout << "-1" << endl;
      } else {
        cout << q.back() << endl;
      }
    } else {
      cout << "Not available" << endl;
    }
  }
}
