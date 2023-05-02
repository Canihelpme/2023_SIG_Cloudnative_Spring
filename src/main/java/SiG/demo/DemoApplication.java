package SiG.demo;

import SiG.demo.Config.AppConfig;
import SiG.demo.Entity.User;
import SiG.demo.UserService.UserService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		userApp();
		userAppByBean();

	}

	public static void userApp() {
		AppConfig appConfig = new AppConfig(); //순수한 Java Appconfig 객체 생성
		UserService userService = appConfig.userService();

		userService.addUser(1L, "shin", "password", "donghyun.shin@ibm.com");

		User findUser = userService.findUser(1L);

		System.out.println("userApp 결과:");

		System.out.println("find Member = " + findUser.getUserName());
	}

	public static void userAppByBean() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		UserService userService = applicationContext.getBean("userService", UserService.class);
		userService.addUser(2L, "Kim", "password2", "kimkimkim@gmail.com");

		User findUser = userService.findUser(2L);

		System.out.println("userApp 결과:");

		System.out.println("find Member = " + findUser.getUserName());

	}

}
