#include <iostream>
#define MAX 9
using namespace std;

int arr[MAX];

int main()
{
  int max = 0;
  int idx = 0;

  for(int i = 0; i < MAX; i++)
  {
    cin >> arr[i];
    if(arr[i] > max)
    {
      max = arr[i];
      idx = i;
    }
  }

  cout << arr[idx] << endl;
  cout << idx + 1;

  return 0;
}
