package co.com.nequi.config;

import co.com.nequi.model.events.gateways.EventsGateway;
import co.com.nequi.usecase.pedido.PedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.nequi.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {

        @Bean
        public PedidoUseCase pedidoUseCase(EventsGateway eventsGateway){
                return new PedidoUseCase(eventsGateway);
        }

}
