package com.lugew.winsmcloud.core.exception;

/**
 * @author 夏露桂
 * @since 2021/1/11 17:49
 */
public interface Logger {
    void trace(String message, Object... arguments);

    void debug(String message, Object... arguments);

    void info(String message, Object... arguments);

    void warn(String message, Object... arguments);

    void error(String message, Object... arguments);
}
