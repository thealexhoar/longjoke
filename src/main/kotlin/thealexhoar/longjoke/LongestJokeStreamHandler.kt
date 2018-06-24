package thealexhoar.longjoke

import com.amazon.ask.SkillStreamHandler
import com.amazon.ask.Skills

class LongestJokeStreamHandler : SkillStreamHandler(
    Skills
        .standard()
        .addRequestHandlers(
            CancelAndStopIntentHandler(),
            ExplanationIntentHandler(),
            HelloWorldIntentHandler(),
            HelpIntentHandler(),
            JokeIntentHandler(),
            LaunchRequestHandler(),
            SessionEndedRequestHandler()
        )
        .build()
)