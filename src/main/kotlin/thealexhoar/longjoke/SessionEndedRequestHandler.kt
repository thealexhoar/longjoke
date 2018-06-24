package thealexhoar.longjoke

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.model.SessionEndedRequest
import com.amazon.ask.request.Predicates
import com.amazon.ask.request.Predicates.requestType
import java.util.*

class SessionEndedRequestHandler : RequestHandler {

    override fun canHandle(input: HandlerInput?): Boolean {
        return when (input) {
            null -> false
            else -> input.matches(requestType(SessionEndedRequest::class.java))
        }
    }

    override fun handle(input: HandlerInput?): Optional<Response> {
        // cleanup logic goes here
        return when (input) {
            null -> Optional.empty()
            else -> input.responseBuilder.build()
        }
    }
}