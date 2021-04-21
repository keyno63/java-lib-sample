package com.github.keyno.filter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.Cookie;

import static org.assertj.core.api.Assertions.assertThat;

class HeaderFilterTest {

    MockHttpServletRequest servletRequest;

    MockHttpServletResponse servletResponse;

    HeaderFilter target;

    @BeforeEach
    void setUp() {
        servletRequest = new MockHttpServletRequest();
        servletResponse = new MockHttpServletResponse();
        target = new HeaderFilter();
    }

    @Test
    void cookieTest() throws Exception {
        var cookieValue = "B";

        var cookie = new Cookie(HeaderFilter.TARGET_COOKIE_NAME, cookieValue);
        servletRequest.setCookies(cookie);
        MockFilterChain mockChain = new MockFilterChain();
        target.doFilter(servletRequest, servletResponse, mockChain);

        assertThat(mockChain.getRequest()).isEqualTo(servletRequest);
        var v = mockChain.getRequest();
        assertThat(v).isNotNull();
        var vv = (Cookie) v.getAttribute(HeaderFilter.ATTR_NAME_VALUE);
        assertThat(vv).isNotNull();
        assertThat(vv.getValue()).isEqualTo(cookieValue);
    }

    @Test
    void noCookieTest() throws Exception {

        MockFilterChain mockChain = new MockFilterChain();
        target.doFilter(servletRequest, servletResponse, mockChain);

        assertThat(mockChain.getRequest()).isEqualTo(servletRequest);
        var v = mockChain.getRequest();
        assertThat(v).isNotNull();
        var vv = (Cookie) v.getAttribute(HeaderFilter.ATTR_NAME_VALUE);
        assertThat(vv).isNull();
    }
}