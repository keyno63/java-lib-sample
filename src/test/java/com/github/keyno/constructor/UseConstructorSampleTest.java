package com.github.keyno.constructor;

import com.github.keyno.constructor.UseConstructorSample.ConstructorSample;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class UseConstructorSampleTest {

    @Test
    final void test() {
        final String value1 = "value1";
        final String value2 = "value2";
        final String expected = "mockedValue";
        try(MockedConstruction<ConstructorSample> mocked = mockConstruction(ConstructorSample.class)) {
            ConstructorSample mockedInstance = new ConstructorSample(value1);
            doReturn(expected).when(mockedInstance).method(value2);

            String actual = mockedInstance.method(value2);
            assertThat(actual).isEqualTo(expected);
        }
        assertThat(new ConstructorSample(value1).method(value2)).isEqualTo("field=[value1], method=[value2]");
    }

    @Test
    final void test1() {
        final String expected = "mockedValue";
        try(MockedConstruction<ConstructorSample> mocked = mockConstruction(ConstructorSample.class,
                (mock, ctx) -> doReturn(expected).when(mock).method(anyString()))
        ) {
            UseConstructorSample target = new UseConstructorSample();
            String actual = target.useMethod("1", "2");
            assertThat(actual).isEqualTo(expected);
        }
    }
}