#include <iostream>
using namespace std;

// 시간 초과

int main() {
  int n;
  int count;

  while(1) {
    count = 0;
    cin >> n;
    if(n == 0){
      break;
    }

    for(int i = n + 1; i <= 2*n; i++) {
      int flag = 0;

      if(n + 1 <= 1) {
        continue;
      }
      for(int j = i - 1; j > 1; j--) {
        if((i % j) == 0) {
          flag = 1;
          break;
        }
      }

      if(flag == 0) {
        count++;
      }
    }
    cout << count << endl;
  }

  return 0;
}
