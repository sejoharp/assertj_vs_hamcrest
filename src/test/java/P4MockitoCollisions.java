import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class P4MockitoCollisions {
    private interface Service {
        Car buildCar(String type);
    }

    private class Car {
    }

    @Test
    public void testWithHamcrest() throws Exception {
        // given
        Service serviceMock = mock(Service.class);

        when(serviceMock.buildCar(org.mockito.ArgumentMatchers.any(String.class)))
                .thenReturn(new Car());

        // when
        Car van = serviceMock.buildCar("van");

        // then
        assertThat(van, org.hamcrest.Matchers.any(Car.class));

        // org.assertj.core.api.Assertions.assertThat(van).isInstanceOf(Car.class);
    }
}
