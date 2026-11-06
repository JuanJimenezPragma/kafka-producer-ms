package co.com.nequi.apprunner;

import co.com.nequi.model.pedido.Pedido;
import co.com.nequi.usecase.pedido.PedidoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppRunner implements ApplicationRunner {
    private final PedidoUseCase pedidoUseCase;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        pedidoUseCase.sendEvent(Pedido.builder().id(4L).name("prueba4").build())
                .doFirst(() -> System.out.println("Inicio envio de eventos"))
                .doOnSuccess(s -> System.out.println("Evento enviado con exito"))
                .doOnError(e -> System.err.println("Error al enviar el evento: " + e.getMessage()))
                .doOnTerminate(() -> System.out.println("Proceso finalizado"))
                .block();
    }
}
