#include <iostream>
using namespace std;

int main()
{
  int num;
  int tmp1, tmp2;
  int count = 0;

  cin >> num;
  tmp1 = num;

  while(1)
  {
    tmp2 = (tmp1 / 10) + (tmp1 % 10);
    tmp1 = (tmp1 % 10) * 10 + (tmp2 % 10);
    count++;

    if(tmp1 == num)
    {
      cout << count;
      break;
    }
  }

  return 0;
}
