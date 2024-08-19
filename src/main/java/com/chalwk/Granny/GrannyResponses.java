/* Copyright (c) 2024, JDA-Blank-Template. Jericho Crosby <jericho.crosby227@gmail.com> */
package com.chalwk.Granny;

import com.chalwk.enums.ResponseType;

import java.util.*;

public class GrannyResponses {

    private static final Map<ResponseType, List<String>> grannyResponses = new HashMap<>();

    static {
        List<String> swearWordResponses = new ArrayList<>();
        swearWordResponses.add("My dear, let's keep our words as lovely as you are.");
        swearWordResponses.add("Remember, language is like a flower garden – let's keep it beautiful.");
        swearWordResponses.add("Now, now, let's be careful with our language, sweetie.");
        swearWordResponses.add("A gentle tongue is a powerful tool – let's use it wisely, shall we?");
        swearWordResponses.add("Oh, my dear, your words are like music to my ears, but let's keep them sweet and melodic.");
        swearWordResponses.add("Your words can be a beacon of light – let them shine with kindness.");

        List<String> spamResponses = new ArrayList<>();
        spamResponses.add("Quality over quantity, my dear – let's focus on meaningful conversations.");
        spamResponses.add("A few well-thought-out words can speak volumes – let's avoid too much noise.");
        spamResponses.add("Keep the channel clear for all to enjoy – less is sometimes more, darling.");
        spamResponses.add("Let's cherish the art of meaningful communication, dear.");
        spamResponses.add("Every message counts – let's make sure they're worthwhile.");
        spamResponses.add("Remember, it's not the number of messages, but the content that matters.");

        List<String> lordsNameInVain = new ArrayList<>();
        lordsNameInVain.add("That language is not appropriate, young man. Watch your tongue!");
        lordsNameInVain.add("You ought to show more respect, especially when it comes to using the lord's name.");
        lordsNameInVain.add("I didn't raise you to speak like that! Please refrain from using such language in my presence.");
        lordsNameInVain.add( "I'm shocked and disappointed to hear you use the lord's name in vain. Please apologize immediately.");
        lordsNameInVain.add("I can't believe my ears! Such blasphemy is not tolerated in this house.");
        lordsNameInVain.add("Using the lord's name in vain is a grave offense. I hope you understand the seriousness of your words.");

        grannyResponses.put(ResponseType.SWEAR_WORD, swearWordResponses);
        grannyResponses.put(ResponseType.SPAM, spamResponses);
        grannyResponses.put(ResponseType.LORDS_NAME, lordsNameInVain);

        for (List<String> responses : grannyResponses.values()) {
            Collections.shuffle(responses);
        }
    }

    public static String getRandomGrannyResponse(ResponseType type) {
        Random random = new Random();
        List<String> responsesForType = grannyResponses.get(type);
        return responsesForType.get(random.nextInt(responsesForType.size()));
    }
}
