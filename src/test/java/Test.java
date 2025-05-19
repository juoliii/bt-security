import com.bitian.security.annotation.EnableCors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author admin
 */

@SpringBootApplication(scanBasePackages = "com.test")
@EnableCors
public class Test {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Test.class, args);
    }
}
