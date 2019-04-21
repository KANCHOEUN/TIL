# Division

MIPS 의 division 에는 다음과 같이 두 가지 알고리즘이 있다.

두 알고리즘 모두 **<span style="color:RoyalBlue">부호 없는 정수</span>**의 division 이다.

1. Restoring Division
2. Non-restoring Division



Dividend : 피제수

Divisor : 제수

Quotient : 몫

Remainder : 나머지



#### Signed Division ( 부호 있는 정수의 나눗셈 )

피제수, 제수 모두 **양수로 바꾸고** 부호 없는 정수의 division 을 적용시킨 후

1. **몫의 부호**는 피제수 ( dividend ) 와 제수 ( divisor ) 의 부호가 같으면 양수

   ​							  					     다르면 음수 : 2's complement 를 취해준다.

2. **나머지의 부호**는 항상 **피제수의 부호**와 같다.



## Restoring Version Algorithm

몫을 저장하는 레지스터 Quotient가 사라진 Improved Version 이다.



1. **Shift Rem Left**
2. **Rem = Rem - Div**

3. 앞의 결과에 따라

   - **Rem < 0** : +Div, R_0
   - **Rem ≥ 0** : R_0 = 1

   **부호가 -** 면 **몫이 0**이 되고 다음 계산을 위해, 즉 빼기 전의 값으로 바꾸어 놓기 위해 **divisor를 다시 더한다**.

   **부호가 +** 면 **몫이 1**이 된다.



결과로 Remainder half 의

1. 왼쪽 : 나머지, remainder
2. 오른쪽 : 몫, quotient



#### Flowchart

![Division-(1)](../Images/Division-(1).JPG)  



#### Example : Divide 0000 0111_two by 0010_two

![Division-(2)](../Images/Division-(2).JPG) 





## Non-restoring Version Algorithm

더하기든 빼기든 한 번만 하자 !

Restoring division 방식이 ( rem - div + div ) X 2 - div 라면

Non-restoring division 방식은 ( rem - div ) X 2 + div 이다.



1. **Shift Rem Left**
2. 1번의 결과가
   - **Rem < 0** : Rem = Rem **-** Div
   - **Rem ≥ 0** : Rem = Rem **+** Div
3. 2번의 결과가
   - **Rem < 0** : R_0 = **0**
   - **Rem ≥ 0** : R_0 = **1**

   **<span style="color:FireBrick">주의</span>** : 몫이 짝수일 때, 즉 몫의 마지막 bit가 0일 때,

​	      제일 마지막 연산의 결과의 나머지가 음수인 경우,

​	      원상복구 restoration 한 번 해야 한다 ! → Rem := Rem + Div



#### Flowchart



![Division-(3)](C:\Users\kanch\Desktop\TIL\Images\Division-(3).JPG) 



#### Example : Divide 00001 10001 ( = 49 ) / 00101 ( = 5 ) 

![Division-(4)](../Images/Division-(4).JPG)



[ 출처 ] 컴퓨터 구조 및 설계 5th Edition, David A.Patterson / John L. Hennssy 지음

개인적으로 공부하며 정리한 것