package co.com.nequi.model.events.gateways;

import reactor.core.publisher.Mono;

public interface EventsGateway {
    Mono<Void> emit(Object event);
    Mono<Void> notify(Object event);
}
