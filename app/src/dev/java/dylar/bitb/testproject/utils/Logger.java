package dylar.bitb.testproject.utils;

import android.util.Log;

public class Logger {

    private Logger() {
    }

    public static void error(String message) {
        Log.e(getCallingClass(), message);
    }

    public static void debug(String message) {
        Log.d(getCallingClass(), message);
    }

    public static void info(String message) {
        Log.i(getCallingClass(), message);
    }

    public static void verbose(String message) {
        Log.v(getCallingClass(), message);
    }

    public static void warn(String message) {
        Log.w(getCallingClass(), message);
    }

    public static void wtf(String message) {
        Log.wtf(getCallingClass(), message);
    }

    private static String getCallingClass() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElements.length; i++) {
            if (stackTraceElements[i].getClassName().equals(Logger.class.getCanonicalName())) {
                try {
                    String[] split = stackTraceElements[i + 2].getClassName().split("\\.");
                    String className = split[split.length - 1];

                    if (className.contains("$")) {
                        className = className.split("\\$")[0];
                    }

                    return "(" + className + ".java:" + stackTraceElements[i + 2].getLineNumber() + ")";
                } catch (Exception e) {
                    return Logger.class.getSimpleName();
                }
            }
        }
        return Logger.class.getSimpleName();
    }
}
