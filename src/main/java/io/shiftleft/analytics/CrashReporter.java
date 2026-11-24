package io.shiftleft.analytics;

import io.sentry.Sentry;

public class CrashReporter {

    public void report(Exception e, String userId, String email) {
        Sentry.setExtra("userId", userId);
        Sentry.setExtra("email", email);
        Sentry.captureException(e);
    }
}
