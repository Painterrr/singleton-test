# Singleton-test
싱글톤 구현 프로젝트

<br>

## 프로젝트 목적
멀티 스레드 환경에서 싱글톤 패턴을 사용하며 일어날 수 있는 동기화 문제를 다루기 위한 프로젝트.

<br>

## 기간
2024.07

<br>

## 키워드
- `Synchronized`
- `volatile`
- `DCL`
- `enum`

<br>

## 참고
### 헤드퍼스트 디자인 패턴 Chapter 05: Singleton Pattern (p.205~226)

<br>
<br>

## 프로젝트 수행 결과
### 코드1: class - synchronized, volatile, DCL
```
package org.example.test;  
  
public class ChocolateBoiler {  
    private boolean empty;  
    private boolean boiled;  
  
    private volatile static ChocolateBoiler cb;  
      
    private ChocolateBoiler() {  
        empty = true;  
        boiled = false;  
    }  
  
    public static ChocolateBoiler getInstance() {  
        if (cb == null) {  
            synchronized ((ChocolateBoiler.class)) {  
                if (cb == null) {  
                    cb = new ChocolateBoiler();  
                }  
            }  
        }  
  
        return cb;  
    }  
  
  
    public void fill() {  
        if (isEmpty()) {  
            empty = false;  
            boiled = false;  
        }  
    }  
  
    public void drain() {  
        if (!isEmpty() && isBoiled()) {  
			empty = true;  
        }  
    }  
  
    public void boil() {  
        if (!isEmpty() && !isBoiled()) {  
            boiled = true;  
        }  
    }  
  
    public boolean isEmpty() {  
        return empty;  
    }  
  
    public boolean isBoiled() {  
        return boiled;  
    }  
}
```
<br>

### 코드2: enum
```
package org.example.test;  
  
public enum ChocolateBoilerEnum {  
	INSTANCE;  
  
    private boolean empty;  
    private boolean boiled;  
  
    ChocolateBoilerEnum() {  
        empty = true;  
        boiled = false;  
    }  
  
    public void fill() {  
        if (isEmpty()) {  
            empty = false;  
            boiled = false;  
        }  
    }  
  
    public void drain() {  
        if (!isEmpty() && isBoiled()) {  
            empty = true;  
        }  
    }  
  
    public void boil() {  
        if (!isEmpty() && !isBoiled()) {  
            boiled = true;  
        }  
    }  
  
    public boolean isEmpty() {  
        return empty;  
    }  
  
    public boolean isBoiled() {  
        return boiled;  
    }  
}
```
<br>
<br>

## 역량강화
1. `synchronized`<br>
싱글톤 패턴에서는 스레드 간 하나의 객체 공유해야 함. <br>
객체 필요할 때마다 synchronized 키워드로 코드 블록에 락 걸어서 객체 유일성 보장.

- 장점: 원자성 및 가시성 보장으로 여러 스레드가 동시에 객체 생성 못함.
- 단점: 성능 저하 발생 가능. 특히 동기화된 코드 블록이 자주 호출되거나 오래 실행될 때 더 두드러짐.

<br>
<br>

2.` volatile`<br>
객체 생성 후 스레드 간 공유 데이터 문제 해결하는 방법. <br>
자바의 스레드는 각자 캐시 저장소 보유. <br>
필요할 때마다 캐시에서 값 읽어옴. <br>
싱글톤에서는 각 스레드가 공유 자원 값을 정확히 알아야 해서 volatile로 주 메모리 값을 직접 읽도록 함.

- 장점: 가시성 문제 해결. volatile 키워드는 변수 값을 주 메모리에 즉시 기록하고, 주 메모리에서 직접 읽도록 보장.
- 단점: 원자성 보장 안 됨. volatile은 변수의 읽기/쓰기 연산이 원자적임을 보장하지만, 복합 연산(예: count++)은 원자성 보장 못함.

<br>
<br>

3. `DCL (Double-Checked Locking)`<br>
객체 생성 로직에서 동기화 전후로 객체 생성 체크함.

- 장점: 필요할 때만 동기화 수행하므로 synchronized 블록보다 성능 더 좋음. 가시성 문제 해결.
- 단점: 구현이 다소 복잡할 수 있고, 잘못 사용하면 예상치 못한 동기화 문제 발생 가능.

<br>
<br>

4. `enum`<br>
enum을 사용해 싱글톤 구현.<br>
(자바의 enum은 클래스 로딩 시점에 단 한 번만 인스턴스화됨)<br>
-> 별도 동기화 코드 필요 없음.

- 장점: 
	- 자동 스레드 안전성
		- 자바의 enum은 클래스 로딩 시점에 단 한 번만 인스턴스화됨. 별도 동기화 코드 필요 없음.
	- 직렬화 안전성
		- enum 사용하면 직렬화와 역직렬화 과정에서도 싱글톤 특성 유지됨. 별도 readResolve 메서드 구현할 필요 없음.
- 단점: enum 타입 아닌 기존 클래스의 경우 enum으로 전환하기 어려울 수 있음.

<br>
<br>

## 요약
상황에 적합한 방법 사용.<br>
간단한 상태 플래그나 단일 변수 변경은 volatile로 충분할 수 있지만, 복잡한 동기화 필요한 경우 synchronized 사용이 더 적절함. <br>
DCL은 성능과 동기화 균형 맞출 때 유용. <br>
enum은 가장 간단하고 안전한 싱글톤 구현 방법 중 하나.

<br>

## 추가 공부: JMM
### Java Memory Model

자바 프로그램의 멀티스레딩 동작을 정의하는 메모리 모델. <br>
-> 여러 스레드가 어떻게 변수에 접근하고 읽고 쓰는지 규정. <br>
JMM이 없으면 멀티스레드 프로그램의 동작을 예측하기 어려움.

<br>

### 주요 개념

1.  **가시성**: 한 스레드에서 변경한 변수의 값이 다른 스레드에 언제 보이는지 정의.
2.  **원자성**: 연산이 더 이상 쪼개지지 않는 단위. 중간에 끼어들기 불가능함. 예: `count++` 연산은 원자적이지 않음.
3.  **재정렬**: 컴파일러와 CPU가 성능 최적화를 위해 명령어 순서를 재배치하는 것. (JMM은 재정렬로 인한 문제 해결) -> 공부 필요.

<br>

### `volatile`과 JMM

`volatile` 키워드는 변수의 가시성을 보장함. `volatile` 변수는 다음과 같은 특징이 있음:

1.  **가시성**: 한 스레드가 `volatile` 변수의 값을 변경하면, 그 변경 사항이 즉시 다른 스레드에게 보임. 즉, `volatile` 변수의 값은 주 메모리에서 직접 읽고 씀.
2.  **재정렬 방지**: `volatile` 변수에 접근하는 코드의 순서는 재정렬되지 않음. 즉, `volatile` 변수 앞뒤의 명령어 순서가 바뀌지 않음.

<br>

### `volatile`의 한계

-   **원자성 미보장**: `volatile`은 가시성만 보장하고 원자성을 보장하지 않음. 예를 들어, `volatile int count`에 대해 `count++`는 여전히 원자적이지 않음.
-   **복합 연산에 적합하지 않음**: `volatile`은 단순한 읽기/쓰기 연산에는 적합하지만, 복합 연산에는 적합하지 않음. 복합 연산은 `synchronized`를 사용해야 함.

<br>

### 예제

```
public class VolatileExample {
    private volatile boolean flag = true;

    public void writer() {
        flag = false;  // 다른 스레드에서 이 변경 사항을 즉시 볼 수 있음
    }

    public void reader() {
        if (!flag) {
        }
    }
} 
```

위 코드에서 `flag`는 `volatile`로 선언되어 있어서 <br>
한 스레드가 `flag`를 변경하면 다른 스레드가 즉시 그 변경 감지.

<br>

JMM과 `volatile`을 이해하면 멀티스레드 프로그램의 동작을 더 잘 예측하고 동기화 문제를 다룰 수 있음.
