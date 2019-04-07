#include <iostream>
using namespace std;

int func(int num)
{
  int x = 100;
  int count = 0;

  if(num < 100)
  {
    count = num;
    return count;
  }
  else
  {
    while(x <= num)
    {
      if(x == 1000)
      {
        break;
      }
      
      int a = (x / 100) - ((x / 10) % 10);
      int b = ((x / 10) % 10) - (x % 10);

      if(a == b)
      {
        count++;
      }

      x++;
    }
    return count + 99;
  }
}

int main()
{
  int num;
  int count;
  cin >> num;

  count = func(num);

  cout << count;

  return 0;
}
