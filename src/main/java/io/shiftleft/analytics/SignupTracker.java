package io.shiftleft.analytics;

import com.mixpanel.mixpanelapi.MessageBuilder;
import com.mixpanel.mixpanelapi.MixpanelAPI;
import org.json.JSONObject;

public class SignupTracker {

    private final MixpanelAPI mixpanel = new MixpanelAPI();
    private final MessageBuilder builder = new MessageBuilder("project-token");

    public void trackSignup(String customerId, String email, String phoneNumber) {
        JSONObject props = new JSONObject();
        props.put("plan", "free");
        props.put("email", email.trim());
        JSONObject event = builder.event(customerId, "Signup", props);
        mixpanel.deliver(event);
    }
}
