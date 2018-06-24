package thealexhoar.longjoke

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.LaunchRequest
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.requestType
import java.util.*

class LaunchRequestHandler : RequestHandler {

    override fun canHandle(input: HandlerInput?): Boolean {
        return when (input) {
            null -> false
            else -> input.matches(requestType(LaunchRequest::class.java))
        }
    }

    override fun handle(input: HandlerInput?): Optional<Response> {
        val speechText = "Welcome to the Amazon Alexa skills kit, you may say hello"
        return when (input) {
            null -> Optional.empty()
            else -> input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard("LongestJoke", speechText)
                .withReprompt(speechText)
                .build()
        }
    }
}