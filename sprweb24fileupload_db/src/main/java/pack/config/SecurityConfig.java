package pack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 스프링의 설정을 위한 클래스
@EnableWebSecurity // Spring Security 기능을 활성화
// 보안설정 자동화, 인증 및 권한 부여, 비밀번호 암호화, CSRF 보호, 기본 로그인 폼 제공, user라는 기본 사용자 계정 생성...

public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> 
		requests.requestMatchers("/").permitAll().anyRequest().authenticated()) // 루트경로는 모두 허용. 그 외는 인증 필요
		.formLogin((form) -> form.loginPage("/login").permitAll())
		.logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/")
				.invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll())
				.csrf((csrf) -> csrf.disable()); // csrf 보호는 테스트이므로 비활성화
		
		return http.build();
	}
	
	@Bean
	// 사용자 세부 정보를 관리하는 서비스 정의 
	public UserDetailsService userDetailsService() {
		UserDetails user = User.builder().username("user").password(passwordEncoder().encode("password"))
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
		// 메모리 내 사용자 세부 정보 관리자를 생성 후 반환
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		// BCrypt는 암호화 해시 함수로 현재 사용 중인 강력한 해시 메커니즘 중 하나
		// 해시 : 입력 데이터를 고정된 길이의 고윳값(해시값)으로 변환한 결과
		return new BCryptPasswordEncoder();
	}
}
