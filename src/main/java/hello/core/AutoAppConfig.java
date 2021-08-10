package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member",
        // hello.core.member 안에 있는 패키지들만 ComponentScan 함
        // default 는 @ComponentScan이 붙은 설정 정보 클래스의 패키지가 시작 위치가 됨
        // 때문에 패키지 위치를 지정하지 않고 설정 정보 클래스의 위치를  프로젝트 최상단에 두는 것이 제일 베스트
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 자동으로 Bean으로 등록하는데 그 중 제외 할 것을 지정해주는 것
        // 현재 AppConfig 가 Configuration 으로 잡혀 있기 때문에 Filter classes에 Configuration 지정 ( 충돌 방지 )
)
public class AutoAppConfig {

}
