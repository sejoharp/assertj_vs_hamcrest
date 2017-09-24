import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.hamcrest.CoreMatchers.equalTo;

public class P3ExceptionTesting {
    @Test
    public void testWithHamcrest() {
        try {
            throwException();
        } catch (RuntimeException e) {
            MatcherAssert.assertThat(e.getMessage(), equalTo("boom!"));
        }
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testWithTestng() {
        throwException();
    }

    @Test
    public void testWithAssertJ() {
        Throwable thrown = catchThrowable(() -> throwException());

        Assertions.assertThat(thrown)
                .hasMessageContaining("boom");
    }

    private static void throwException() throws RuntimeException {
        throw new RuntimeException("boom!");
    }
}
