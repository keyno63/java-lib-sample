package com.github.keyno.statics;


import com.github.keyno.statics.libs.StaticSample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;

@SuppressWarnings("NonAsciiCharacters")
class UseStaticSampleTest {

    private UseStaticSample target;
    private static final String INIT_VALUE = "value";

    @BeforeEach
    void setUp() {
        target = new UseStaticSample(INIT_VALUE);
    }

    @Test
    final void test() {
        final String argValue = "someValue";
        final String expected = String.format("Arg value is equal, value =[%s]", argValue);

        try(MockedStatic<StaticSample> mocked = mockStatic(StaticSample.class)) {
            mocked.when(() -> StaticSample.isEqual(anyString(), anyString()))
                    .thenReturn(true);

            String actual = target.function(argValue);

            assertThat(actual).isEqualTo(expected);
        }
    }

    @Test
    void test2() {
        try(MockedStatic<StaticSample> mocked = mockStatic(StaticSample.class)) {
            mocked.when(() -> StaticSample.value1())
                    .thenReturn("anyString");

            mocked.when(StaticSample::value1)
                    .thenReturn("anyString");

        }
    }
}

