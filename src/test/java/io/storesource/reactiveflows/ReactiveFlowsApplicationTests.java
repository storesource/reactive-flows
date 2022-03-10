package io.storesource.reactiveflows;

import io.storesource.reactiveflows.service.ReactiveChainVerificationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

@SpringBootTest
class ReactiveFlowsApplicationTests {

	@Autowired
	private ReactiveChainVerificationService service;

	@Test
	void contextLoads() {
	}

	@Test
	void verifyChainLink(){
		StepVerifier.create(service.runReactiveChain())
				.expectNext("6")
				.verifyComplete();
	}

}
