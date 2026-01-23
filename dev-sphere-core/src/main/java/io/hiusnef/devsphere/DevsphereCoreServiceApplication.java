package io.hiusnef.devsphere;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.resilience.annotation.EnableResilientMethods;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@EnableResilientMethods
@RequiredArgsConstructor
public class DevsphereCoreServiceApplication {

	private static final Logger logger = LogManager.getLogger(DevsphereCoreServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DevsphereCoreServiceApplication.class);
		logApplicationStartup(app.run(args).getEnvironment());
	}

	private static void logApplicationStartup(Environment env) {
		String protocol = Optional.ofNullable(env.getProperty("server.ssl.key-store")).map(key -> "https")
				.orElse("http");
		String applicationName = env.getProperty("spring.application.name");
		String serverPort = env.getProperty("server.port");
		String contextPath = Optional.ofNullable(env.getProperty("server.servlet.context-path"))
				.filter(path -> !path.isBlank())
				.orElse("/");
		String hostAddress = "localhost";
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException _) {
			logger.warn("The host name could not be determined, using `localhost` as fallback");
		}
		logger.info(
				MarkerManager.getMarker("CRLF_SAFE"),
				"""
				
					----------------------------------------------------------
					\tApplication '{}' is running! Access URLs:
					\tLocal: \t\t{}://localhost:{}{}
					\tExternal: \t{}://{}:{}{}
					\tProfile(s): \t{}
					----------------------------------------------------------""",
				applicationName,
				protocol,
				serverPort,
				contextPath,
				protocol,
				hostAddress,
				serverPort,
				contextPath,
				env.getActiveProfiles().length == 0 ? env.getDefaultProfiles() : env.getActiveProfiles());
	}
}
