package io.shiftleft.analytics;

import io.sentry.Sentry;

/** Reports crashes. */
public class CrashReporter {

    public void report(Exception e, String userId, String email) {
        Sentry.setExtra("userId", userId);
        Sentry.getCurrentScope().setContexts("contact", java.util.Map.of("addr", email));
        Sentry.captureException(e);
    }
}
