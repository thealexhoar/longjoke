package thealexhoar.longjoke

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.intentName
import java.util.*

class HelloWorldIntentHandler : RequestHandler {

    override fun canHandle(input: HandlerInput?): Boolean {
        return when (input) {
            null -> false
            else -> input.matches(intentName("HelloWorldIntent"))
        }
    }

    var count = 1
    override fun handle(input: HandlerInput?): Optional<Response> {
        val speechText = "Hello world " + count++
        return when (input) {
            null -> Optional.empty()
            else -> input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard("LongestJoke", speechText)
                .withReprompt("Hello world " + count)
                .build()
        }
    }
}