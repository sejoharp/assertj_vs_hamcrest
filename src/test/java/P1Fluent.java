import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class P1Fluent {
    @Test
    public void test() {
        // assertJ
        Assertions.assertThat("testString").isEqualTo("testString");
        Assertions.assertThat("testString").contains("test");

        // hamcrest
        MatcherAssert.assertThat("testString", equalTo("testString"));
        MatcherAssert.assertThat("testString", containsString("test"));
    }
}
