#include <cstdio>

int main(){
   int N, sum = 0;

   scanf("%d\n", &N);

   char a[N];

   for(int i = 0 ; i < N; i ++)
   {
     scanf("%c", (a+i));
     a[i] -= '0';
     sum += a[i];
   }

  printf("%d", sum);

  return 0;
}
