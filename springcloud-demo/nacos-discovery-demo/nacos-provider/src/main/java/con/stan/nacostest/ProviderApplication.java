package con.stan.nacostest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @RestController
    class EchoController {

        @GetMapping("/echo/{string}")
        public String echo(@PathVariable String string) {
            System.out.println("收到请求参数： " + string);
            return "Hello Nacos Discovery " + string;
        }

        @GetMapping("/demo/list")
        public String demo() {
            return "-----demo/list----";
        }

        @GetMapping("/demo/p")
        public Object demo2() {
            System.out.println(System.getProperties().toString());
            return System.getProperties();
        }
    }
}

