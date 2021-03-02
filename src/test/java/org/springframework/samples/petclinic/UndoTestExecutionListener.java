package org.springframework.samples.petclinic;

import io.undo.lr.UndoLR;
import org.springframework.test.context.TestExecutionListener;
import org.springframework.test.context.TestContext;

public class UndoTestExecutionListener implements TestExecutionListener {

	public void afterTestMethod(TestContext testContext) throws Exception {
		if (testContext.getTestException() != null) {
			String testName = testContext.getTestMethod().getName();
			System.out.printf("UndoRunListener - test failed: %s\n", testName);
			UndoLR.save(testName + ".undo");
		}
		UndoLR.stop();
	};

	public void beforeTestClass(TestContext testContext) throws Exception {
	};

	public void prepareTestInstance(TestContext testContext) throws Exception {
	};

	public void beforeTestMethod(TestContext testContext) throws Exception {
		UndoLR.setEventLogSize(1000 * 1000 * 1000);
		UndoLR.start();
	};

	public void afterTestClass(TestContext testContext) throws Exception {
	}

}
