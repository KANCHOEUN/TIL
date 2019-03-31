/* 기본 버블 정렬 */

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
  for(int i = 0; i < len; i++)
  {
    for(int j = 0; j < len - ( i + 1 ); j++)
    {
      if(arr[j] > arr[j + 1])
      {
        Swap(arr[j], arr[j + 1]);
      }
    }
  }
}

int main()
{
  int len;
  cin >> len;
  int * arr = new int[len];

  for(int i = 0; i < len; i++)
  {
    cin >> arr[i];
  }

  BubbleSort(arr, len);

  for(int i = 0; i < len; i++)
  {
    cout << arr[i] << endl;
  }

  return 0;
}
