/* 버블 정렬 변형 */

#include <iostream>
using namespace std;

void Swap(int &a, int &b)
{
  int tmp = a;
  a = b;
  b = tmp;
}

void BubbleSort(int *(&arr), int len)
{
  int flag;

  for(int i = 0; i < len; i++)
  {
    flag = 0;
    for(int j = 0; j < len - ( i + 1 ); j++)
    {
      if(arr[j] > arr[j + 1])
      {
        Swap(arr[j], arr[j + 1]);
        for(int i = 0; i < len; i++)
        {
          cout << arr[i] << " ";
        }
        cout << "\n";
        flag = 1;
      }
    }
    if(flag == 0)
    {
      return;
    }
  }
}

int main()
{
  int * arr = new int[5];

  for(int i = 0; i < 5; i++)
  {
    cin >> arr[i];
  }

  BubbleSort(arr, 5);

  return 0;
}
