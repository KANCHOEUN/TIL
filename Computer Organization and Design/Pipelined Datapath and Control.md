# Pipelined Datapath and Control

##### Pipeline Register

: 스테이지와 스테이지 사이를 분리해줌

: 앞 사이클에서 생성된 정보를 감춰줌으로써 정보가 뒤엉키는 것을 방지해줌



### Load Word Instruction Stage

- 색칠된 부분 : 실제로 이 스테이지에서 일하는 부분 (  활성화된 부분 )

- Register 앞쪽 : 입력이 활성화 ( write )

  Register 뒷쪽 : 출력이 활성화 ( read )

  

#### (1) IF STAGE

![PipelinedDatapathAndControl-(1)](../Images/PipelinedDatapathAndControl-(1).JPG)

: **PC + 4** 는 당장 필요는 없지만 그대로 전달해서 **부호 확장한 offset 과 주소 계산에 필요**함

 

1. MUX 에서 주소 2개 중 하나를 선택해서 PC에 넣음

2. PC 는 그 값을 instruction memory 의 주소로 보냄
3. instruction memory 는 그 주소를 받아서 명령어를 읽어냄
4. ALU 는 PC + 4 연산을 함
5. 이 정보들을 IF/ID 파이프라인 레지스터에 저장함



#### (2) ID STAGE

![PipelinedDatapathAndControl-(2)](../Images/PipelinedDatapathAndControl-(2).JPG) 



1. Rs, Rt 필드가 연결돼서 해당되는 레지스터의 값 32 bits 가 읽혀져 나옴
2. 지금 당장은 필요 없지만 다음 clock 에서 필요한 **offset 부호 확장**

3. 레지스터의 출력이 활성화되어 Read



#### (3) EX STAGE

![PipelinedDatapathAndControl-(3)](../Images/PipelinedDatapathAndControl-(3).JPG) 

: base register 와 부호 확장한 offset 을 ALU에서 더해서 주소를 만든다.

: sw 인 경우 write 할 데이터이므로 다음 stage 에서 쓰라고 MEM 스테이지러 보내줌

: Control Signal 전혀 없으므로 무조건 branch target address **계산을 하지만**

  lw인 경우에 쓰이지는 않는다.



1. **rt 레지스터** 또는 **부호확장한 offset** 중 하나 선택함
2. 둘을 더해서 **주소를 만들어내는 ALU** 활성화됨



#### (4) MEM STAGE

![PipelinedDatapathAndControl-(4)](../Images/PipelinedDatapathAndControl-(4).JPG) 

: 주소가 데이터 메모리로 가고 memory read 제어 신호가 들어가서 데이터 메모리를 읽는다.



#### (5) WB STAGE

![PipelinedDatapathAndControl-(5)](../Images/PipelinedDatapathAndControl-(5).JPG) 

: 목적지 레지스터에 쓰는데 write 할 데이터를 선택해야 함

: register write 를 하므로 Regitser의 앞부분이 활성화 되어 있음



1. lw 인 경우 앞 clock 메모리에서 읽은 데이터를 선택해야 함
2. write data로 가고 write register 번호를 지정해주고



#### Corrected Pipeline Datapath

![PipelinedDatapathAndControl-(6)](../Images/PipelinedDatapathAndControl-(6).JPG) 

: 2번째 스테이지에서의 명령어가 결정하는 것이 아니고

  **5번째 스테이지에서의 명령어가 결정하는 것**이기 때문에

  write 할 레지스터 번호를 2번째 스테이지에서부터 쭉 가져와야 한다 !

