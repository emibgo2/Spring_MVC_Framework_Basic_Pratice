package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
//        implements InitializingBean, DisposableBean

    // 인터페이스 초기화, 종료는 스프링 전용 인터페이스의 의존하고 여러 단점이 있기 때문에 현재는 잘 사용하지 않음
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url =" + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: "+url);
    }
   // ↓ @PostConstruct, @PreDestroy -> 가장 권장되는 Bean 초기화, 소멸 메소드 작성 방법
    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }


//    인터페이스를 이용한 초기화, 소멸
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        // 빈 생성(?) 될 때 실행되는 메소드
//        connect();
//        call("초기화 연결 메시지");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        // 빈 종료 될 때 실행되는 메소드
//        System.out.println("close: " + url);
//    }


}
