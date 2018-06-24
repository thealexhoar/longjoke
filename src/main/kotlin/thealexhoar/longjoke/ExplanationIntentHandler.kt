package thealexhoar.longjoke

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates
import java.util.*

class ExplanationIntentHandler : RequestHandler {

    override fun canHandle(input: HandlerInput?): Boolean {
        return when (input) {
            null -> false
            else -> input.matches(Predicates.intentName("ExplainJokeIntent"))
        }
    }

    override fun handle(input: HandlerInput?): Optional<Response> {
        val speechText = THE_EXPLANATION
        return when (input) {
            null -> Optional.empty()
            else -> input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard("LongestJoke", speechText)
                .build()
        }
    }
}