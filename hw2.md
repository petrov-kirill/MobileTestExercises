1.	For existing native mobile autotest try to use another locator (xpath, classname, ?).
    Define these locators using Appium Inspector.
    Are there any difference with id version?

    If we use xpath or class name selector, we don't need to write package, so they are shorter than id selector.

2.	Modify existing tests to run on a real device.
    What should be changed?

    If we want to run tests on physical device, we need to change "deviceName" capability in Appium Inspector and
    of course don't forget to change it in our code.

3.	Connect a real device to Appium (describe required actions) and run tests.
    Are there any difference with run on emulator?

    To run tests on physical device we need to:
    1. plug in our device to computer via usb port.
    2. run command "adb devices" in command prompt, and make sure that our device is in the attached devices list.
    3. open appium application and start the server.
    4. in "Desired Capabilities" fill in fields: "deviceName", "platformName", "app" with required values;
    5. start session and run tests.

4.  What should be improved/changed in existing test code? Why, for what?

    First of all rename tests and give them meaningful names that will describe their behaviour.
    Then get rid of System.out.println() + Thread.sleep() it's not a good practice.
    Of course we need to add assertions to our tests.
    Change the way we look for our locators to @FindBy.
    Get rid of hard coded values. Make property file for capabilities.
