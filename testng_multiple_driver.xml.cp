<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite" parallel="tests" thread-count="2">
	<test name="testOnChrome">
		<parameter name="driverType" value="chrome"></parameter>
		<classes>
			<class name="com.tranquyet.execution.TestSetExecution" />
		</classes>
	</test> <!-- Test -->
	<test name="testOnEdge">
		<parameter name="driverType" value="edge"></parameter>
		<classes>
			<class name="com.tranquyet.execution.TestSheet" />
		</classes>
	</test> <!-- Test -->
</suite> <!-- Suite -->
