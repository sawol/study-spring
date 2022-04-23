package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // 기존에 만들었던 설정 파일인 AppConfig 파일을 필터링 해달라는 의미 -> 같이 등록되면 수동 등록가 다를바가 없음으로
        basePackages = "hello.core.member",     // 이 위치 아래에 있는 컴포넌트만 찾는다
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        )
public class AutoAppConfig {

}
