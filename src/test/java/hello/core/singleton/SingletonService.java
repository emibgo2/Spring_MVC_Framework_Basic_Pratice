package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    // JVM이 실행될때 자동적으로 static영역에 new로 등록하고 자기 자신을 참조값으로 가짐

    public static SingletonService getInstance() {
        return instance;
    }
    // SingletonService 객체가 필요하면 오직 getInstance 메서드를 통해서만 조회 가능 ( 항상 같은 인스턴스를 반환 )

    private SingletonService() {
        // 다른 곳에서 못만들도록 생성자를 private 선언
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
