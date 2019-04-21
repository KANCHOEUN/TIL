# Floating Point

1. 정수 : 부호를 바꿀 때, 2의 보수를 이용
2. 실수 : 부호를 바꿀 때, 부호 비트만 바꾼다 !



## 실수의 2진수 표현

![FloatingPoint-(1)](../Images/FloatingPoint-(1).JPG) 

![FloatingPoint-(2)](../Images/FloatingPoint-(2).JPG) 



(1) Sign ( 부호 ) : 1 bit

(2) Exponent ( 지수 ) : 8 bits

(3) Fraction, Significand ( 소수 부분 ) : 23 bits



##### IEEE 754의 Exponent Biases

1. single precision : 127
2. double precision : 1023



##   10진수 to 2진수 / 16진수

![FloatingPoint-(3)](../Images/FloatingPoint-(3).JPG) 



##   2진수 to 10진수

![FloatingPoint-(4)](../Images/FloatingPoint-(4).JPG) 



[ 출처 ] 컴퓨터 구조 및 설계 5th Edition, David A.Patterson / John L. Hennssy 지음

개인적으로 공부하며 정리한 것