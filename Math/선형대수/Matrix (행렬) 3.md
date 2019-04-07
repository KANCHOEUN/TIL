# Matrix 행렬 (3)



## Determinant

![Matrix3-(6)](C:\Users\kanch\Documents\TIL\Images\Matrix3-(6).JPG) 

-  정사각행렬에서만 정의됨
-  *절댓값이 아님을 주의*  음의 값을 갖기도 한다.
- ![Matrix3-(7)](C:\Users\kanch\Documents\TIL\Images\Matrix3-(7).JPG) 



1. Minor ( **소행렬식** )

   : 행렬 A의 제 i 행, j 열을 제외하고 얻은 행렬식

   

2. Cofactor ( **여인수** )

   ![Matrix3-(8)](C:\Users\kanch\Documents\TIL\Images\Matrix3-(8).JPG) ( M 행렬은 Minor 소행렬식을 의미 ) 

   : 위의 A_{ij} 를 행렬 A 의 여인수라 한다.

   : Cofator Expansion ( 여인수 전개 )



3. Adjoint Matirx ( **수반 행렬** )

   ![Matrix3-(9)](C:\Users\kanch\Documents\TIL\Images\Matrix3-(9).JPG) 

   : Cofactor Matrix 의 전치 행렬 



- Det 의 어떤 행(열)에 상수 k를 곱한 Det 는 원래의 Det 의 k 배이다.

- n X n 행렬 A의 한 행(열)의 성분이 모두 0이면 det A = 0 이다.
- Det 의 두 행(열)을 서로 바꾼 Det 은 원래의 Det 에 -1을 곱한 것과 같다.



## 연립 방정식 AX = B 의 X 값 구하기



1. Augmented Matrix



2. 좌변과 우변에 A의 역행렬 곱하기

   : 연립 일차 방정식의 해를 연립 일차 방정식의 **계수 행렬 (A) 의 가역성**에 따라 조사할 수 있다.

   : 연립 일차 방정식의 **n X n 계수행렬 A가 가역**이고 **n X 1 상수 행렬 B** 일 때, AX = B ( 단, B ≠ 0) 는

     **오직 한 개의 해**![Matrix3-(2)](C:\Users\kanch\Documents\TIL\Images\Matrix3-(2).JPG)를 갖는다.

   

3. Cramar 공식

   ![Matrix3-(11)](C:\Users\kanch\Documents\TIL\Images\Matrix3-(11).JPG) 



## A의 역행렬 구하기



1. 기본 변형을 이용

​    ![Matrix3-(1)](C:\Users\kanch\Documents\TIL\Images\Matrix3-(1).JPG) 

​       : 가역인 정사각행렬 A의 왼쪽에 기본 행렬을 유한 번 곱하면 단위 행렬이 된다.

​       : 행렬 A에 기본 변형을 그 횟수만큼 유한히 실행하면 단위 행렬이 된다는 것과 같다.



2. 역행렬 공식 사용

   ![Matrix3-(10)](C:\Users\kanch\Documents\TIL\Images\Matrix3-(10).JPG) 

   