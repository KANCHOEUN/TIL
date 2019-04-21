# Multiplication

Multiplicand : 피승수

Multiplier : 승수



Product의 길이 = ( Multiplicand 의 길이 ) + ( Multiplier 의 길이 )



2진수의 곱하기는 **논리 AND 연산**과 같다.

| **0** | **X** | **0** | **=** | **0** |
| :---: | :---: | :---: | :---: | :---: |
| **0** | **X** | **1** | **=** | **0** |
| **1** | **X** | **0** | **=** | **0** |
| **1** | **X** | **1** | **=** | **1** |



**<span style="color:RoyalBlue">부호 없는</span>** 2's complement number의 곱하기 계산에만 해당하는 알고리즘



처음 Product에

1. **왼쪽 4 bits** 에는 **0**으로 채워지고

2. **오른쪽 4 bits** 에는 **Multiplier**로 채워진다.

( ∵ Multiplier를 따로 둘 필요 없이 Product의 오른쪽 부분에 두면 효율적이다. )

계산을 할 때에 왼쪽 4 bits만 계산하고 오른쪽 부분은 계산하지 않는다.



## Refined Version Algorithm

#### Flowchart

![Multiplication-(2)](../Images/Multiplication-(2).JPG) 





#### Example : Multiply 0010_two X 0011_two

![Multiplication-(3)](../Images/Multiplication-(3).JPG)  



## Booth's Algorithm

**<span style="color:RoyalBlue">부호 있는</span>** 2's complement number의 곱하기 알고리즘이다.

전 알고리즘은 30 = 16 + 8 + 4 + 2 와 같은 방식이라면

Booth 알고리즘은 30 = 32 - 2 와 같은 방식이다.



Product의 **마지막 2 bits** 씩 동시에 보는데

2 bits 마다 다음과 같은 연산을 한다.

1. **00**, **11** : No Operation
2. **01** : **Addition**
3. **10** : **Subtraction**



n bits 는 연산을 n 번 해야 하는데 2 bits 씩 보면 연산을 n - 1 번 밖에 하지 않는다.

따라서 **마지막에 0**을 하나 넣고 시작한다 !



##### <span style="color:FireBrick">Arithmetic</span> Shift Right

1. **부호가 0** ( **양수** ) 이면 끝에 **0**을 집어넣고
2. **부호가 1** ( **음수** ) 이면 끝에 **1**을 집어넣는다 !



#### Flowchart

![Multiplication-(4)](../Images/Multiplication-(4).JPG) 



#### Example : Multiply 0010_two X 1101_two

![Multiplication-(5)](../Images/Multiplication-(5).JPG)  



[ 출처 ] 컴퓨터 구조 및 설계 5th Edition, David A.Patterson / John L. Hennssy 지음

개인적으로 공부하며 정리한 것