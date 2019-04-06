#include <iostream>
using namespace std;

int main()
{
  int N;
  cin >> N;

  int * arr = new int[N];
  int num = 0;
  int flag = 0;

  for(int i = 0; i < N; i++)
  {
    cin >> arr[i];
  }

  for(int i = 0; i < N; i++)
  {
    flag = 0;
    if(arr[i] <= 1)
    {
      continue;
    }
    for(int j = arr[i] - 1; j > 1; j--)
    {
      if((arr[i] % j) == 0)
      {
        flag = 1;
        break;
      }
    }
    if(flag == 0)
    {
      num++;
    }
  }

  cout << num << endl;

  return 0;
}
