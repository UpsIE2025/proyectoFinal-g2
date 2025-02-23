package edu.ups.ms_cuentas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import net.devh.boot.grpc.server.config.GrpcServerProperties;

@SpringBootApplication
@EnableConfigurationProperties({
  GrpcServerProperties.class
})
public class MsCuentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCuentasApplication.class, args);
    System.out.println("MS Cuenta corriendo con gRPC en el puerto 9090 .....");
	}

}
