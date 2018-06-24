package thealexhoar.longjoke

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.intentName
import java.util.*

class JokeIntentHandler : RequestHandler {

    override fun canHandle(input: HandlerInput?): Boolean {
        return when (input) {
            null -> false
            else -> input.matches(intentName("TellJokeIntent").or(intentName("AMAZON.YesIntent")))
        }
    }

    var isUserSure = false
    override fun handle(input: HandlerInput?): Optional<Response> {
        val speechText = THE_JOKE
        val confirmText = "Are you sure you want to hear the joke?"

        return when (input) {
            null -> Optional.empty()
            else -> {
                when (isUserSure) {
                    true -> input.responseBuilder
                        .withSpeech(speechText)
                        .withSimpleCard("LongestJoke", speechText)
                        .build()
                    false -> {
                        isUserSure = true
                        input.responseBuilder
                            .withSpeech(confirmText)
                            .withSimpleCard("LongestJoke", confirmText)
                            .withReprompt(speechText)
                            .build()
                    }
                }
            }
        }
    }
}