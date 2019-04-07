#include <iostream>
using namespace std;

int main()
{
  int N;
  int k = 0;

  cin >> N;

  while(1)
  {
    if(N == 1)
    {
      k = 1;
      break;
    }
    if((1 + 3*k*(k+1) < N) && (N <= 1 + 3*(k+1)*(k+2)))
    {
      k += 2;
      break;
    }
    k++;
  }

  cout << k;

  return 0;
}
