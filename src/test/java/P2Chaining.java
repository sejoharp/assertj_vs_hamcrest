import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class P2Chaining {
    @Test
    public void test() {
        // assertJ
        Assertions.assertThat(asList("a", "b"))
                .contains("a")
                .hasSize(2);

        // hamcrest
        List<String> actual = asList("a", "b");
        MatcherAssert.assertThat(actual, hasItem("a"));
        MatcherAssert.assertThat(actual, hasSize(2));
    }
}
