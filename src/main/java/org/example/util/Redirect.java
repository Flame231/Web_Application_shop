package org.example.util;

import javax.servlet.RequestDispatcher;

@FunctionalInterface
public interface Redirect {
    String path(RequestDispatcher dispatcher);
}
