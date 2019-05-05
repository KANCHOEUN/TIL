# KMP Algorithm



## 스트링 패턴 매칭

#### (1) Find Function

1. 두 개의 스트링 s와 pat ( s에서 탐색할 패턴 )
2. 호출 : s.Find(pat)
3. Find 함수 반환
   - pat과 i번째 위치에서 시작하는 s의 부분 문자열이 부합될 때 인덱스 i 를 반환
   - pat이 공백이거나 s의 부분 문자열이 아닌 경우 -1 을 반환

4. s에서 위치 LengthS - LengthP 의 오른쪽은 pat과 매치될 문자가 충분하지 않으므로 **고려하지 않아도 됨**

```c++
int String::Find(String pat) {
    for(int i = 0; i < Length() - pat.Length(); i++) {
        for(int j = 0; j < pat.Length() && str[i+j] == pat.str[j]; j++) {
            if(j == pat.Length() - 1) {
                return i;
            }
        }
    }
    return -1;
}
```

시간 복잡도 : O(LengthP * LengthS)



#### (2) KMP Algorithm : Failure Function

##### Fast Find + Failure Function

```c++
int String::FastFind(String pat) {
    int posP = 0, int posS = 0;
    int lengthP = pat.Length();
    int lengthS = Length();
    
    while((posP < lengthP) && (posS < lengthS)) {
        if(pat.str[posP] == str[posS]) {
            posP++;
            posS++;
        }
        else {
            if(posP == 0) {
                posS++;
            }
            else {
                posP = pat.f[posP - 1] + 1;
            }
        }
    }
    if(posP < lengthP) {
        return -1;
    }
    else P
        return posS - lengthP;
}

void String::FailureFunction() {
    int lengthP = Length();
    f[0] = -1;
    for(int j = 1; j < lengthP; j++) {
        int i = f[j - 1];
        while((*(str + j) != *(str+i+1)) && (i >= 0)) {
            i = f[i];
        }
        if(*(str + j) == *(str + i + 1)) {
            f[j] = i + 1;
        }
        else {
            f[j] = -1;
        }
    }
}
```

시간 복잡도 : O(LengthS * LengthP)



| s    | a    | b    | a    | a    | b    | a    | a    | b    | c    | a    |
| ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| f    | -1   | -1   | 0    | 0    | 1    | 2    | 3    | 4    | -1   | 0    |

