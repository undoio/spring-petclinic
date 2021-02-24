package org.springframework.samples.petclinic;

import org.springframework.test.context.TestExecutionListener;
import org.springframework.test.context.TestContext;

public class UndoTestExecutionListener implements TestExecutionListener {

	public void afterTestMethod(TestContext testContext) throws Exception {
		if (testContext.getTestException() != null) {
			String testName = testContext.getTestMethod().getName();
			System.out.printf("UndoRunListener - test failed: %s\n", testName);
			System.setProperty("io.undo.output", testName);
			System.setProperty("io.undo.failed", "true");
		}
	};

	public void beforeTestClass(TestContext testContext) throws Exception {
	};

	public void prepareTestInstance(TestContext testContext) throws Exception {
	};

	public void beforeTestMethod(TestContext testContext) throws Exception {
	};

	public void afterTestClass(TestContext testContext) throws Exception {
	}

}
