import org.assertj.core.api.AbstractAssert;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.TypeSafeMatcher;
import org.testng.annotations.Test;

import java.util.Objects;

public class P5CustomAssertions {
    class Car {
        private final int doors;

        Car(int doors) {
            this.doors = doors;
        }

        int getDoors() {
            return doors;
        }
    }

    // hamcrest
    private static Matcher<Car> hasDoors(int doors) {
        return new TypeSafeMatcher<Car>() {
            @Override
            protected boolean matchesSafely(Car car) {
                return Objects.equals(doors, car.getDoors());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("number of doors: ")
                        .appendValue(doors);
            }

            @Override
            public void describeMismatchSafely(Car car, Description mismatchDescription) {
                mismatchDescription.appendText("was ").appendValue(
                        car.getDoors());
            }
        };
    }

    @Test
    public void testWithHamcrest() {
        Car vw = new Car(4);

        MatcherAssert.assertThat(vw, hasDoors(3));
    }

    // assertJ
    static class CarAssert extends AbstractAssert<CarAssert, Car> {

        static CarAssert assertThat(Car actual) {
            return new CarAssert(actual);
        }

        private CarAssert(Car actual) {
            super(actual, CarAssert.class);
        }

        CarAssert hasDoors(int doors) {
            isNotNull();
            if (actual.getDoors() != doors) {
                failWithMessage("Expected number of doors %d but was %d", doors, actual.getDoors());
            }
            return this;
        }

    }

    @Test
    public void testWithAssertJ() {
        Car vw = new Car(4);

        CarAssert.assertThat(vw).hasDoors(3);
    }
}
