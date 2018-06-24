package thealexhoar.longjoke

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.intentName
import java.util.*

class CancelAndStopIntentHandler : RequestHandler {

    override fun canHandle(input: HandlerInput?): Boolean {
        return when (input) {
            null -> false
                else -> input.matches(intentName("AMAZON.StopIntent").or(intentName("AMAZON.CancelIntent")))
        }
    }

    override fun handle(input: HandlerInput?): Optional<Response> {
        val speechText = "Hello world"
        return when (input) {
            null -> Optional.empty()
            else -> input.responseBuilder
                .withSpeech("Goodbye")
                .withSimpleCard("LongestJoke", "Goodbye")
                .build()
        }
    }

}