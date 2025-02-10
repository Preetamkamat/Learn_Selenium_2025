package qa.com.testng;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest {

    @Test(timeOut = 1, expectedExceptions = NumberFormatException.class)
    public void infiniteLoop() {
        int i = 1;
        while (i == 1) {
            System.out.println(i);
        }
    }
}
