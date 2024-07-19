package org.example.test;

public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;

    private static ChocolateBoiler cb;

    /**
     * 초콜릿 보일러가 비어있을 때만 작동.
     */
    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    // synchronized 키워드로 한 스레드가 메서드 사용을 끝내기 전까지
    // 다른 스레드는 공유 자원에 접근 못하고 대기.
    // -> 인스턴스 생성이 겹치지 않음(인스턴스 생성 동기화 문제 해결)
    // 다만, 인스턴스를 생성한 후에는 synchronized 불필요.
    public static synchronized ChocolateBoiler getInstance() {
        if (cb == null) {
            cb = new ChocolateBoiler();
        }

        return cb;
    }

    /**
     * 보일러에 우유와 초콜릿을 혼합한 재료 넣음.
     */
    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    /**
     * 보일러가 차있고 아직 끓지 않는 상태에서만
     * 재료를 다 끓이면 boiled 플래그를 true로 변경.
     */
    public void drain() {
        if (!isEmpty() && isBoiled()) {
            // 끓일 재료를 다음 단계로 넘김
            empty = true;
        }
    }

    /**
     * 재료를 끓임
     */
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
