#include <iostream>
#include <string>
using namespace std;

void Swap(int &a, int &b)
{
	int tmp = a;
	a = b;
	b = tmp;
}

void BubbleSort(int *(&arr), int len)
{
	for (int i = 0; i < len - 1; i++)
	{
		for (int j = 1; j < len - i; j++)
		{
			if (arr[j] > arr[j - 1])
			{
				Swap(arr[j], arr[j - 1]);
			}
		}
	}
}

int main()
{
	string str;
	cin >> str;
	int len = str.length();
	int * arr = new int[len];

	for (int i = 0; i < len; i++)
	{
		arr[i] = str[i] - '0';
	}

	BubbleSort(arr, len);

	for (int j = 0; j < len; j++)
	{
		cout << arr[j];
	}

  delete []arr;
	return 0;
}
