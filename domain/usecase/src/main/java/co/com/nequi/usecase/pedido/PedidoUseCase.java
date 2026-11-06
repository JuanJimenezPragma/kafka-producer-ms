package co.com.nequi.usecase.pedido;

import co.com.nequi.model.events.gateways.EventsGateway;
import co.com.nequi.model.pedido.Pedido;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PedidoUseCase {
    private final EventsGateway eventsGateway;

    public Mono<Void> sendEvent(Pedido pedido){
        return eventsGateway.emit(pedido);
    }
}
