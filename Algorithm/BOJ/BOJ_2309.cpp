#include <iostream>
#include <algorithm>
#define N 9
using namespace std;

// 맞왜틀 !!!!!!??????

int main() {
  int * dwarf = new int[9];
  int sum = 0;

  for(int i = 0; i < 9; i++) {
    cin >> dwarf[i];
    sum += dwarf[i];
  }

  for(int i = 0; i < N; i++) {
    for(int j = i + 1; j < N; j++) {
      if(sum - (dwarf[i] + dwarf[j]) == 100) {
        dwarf[i] = -1;
        dwarf[j] = -1;
        sort(dwarf, dwarf + N);
        break;
      }
    }
  }

  for(int i = 2; i < N; i++) {
    cout << dwarf[i] << endl;
  }

  return 0;
}
