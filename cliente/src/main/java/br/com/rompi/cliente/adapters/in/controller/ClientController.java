package br.com.rompi.cliente.adapters.in.controller;

import br.com.rompi.cliente.adapters.in.controller.mapper.ClientMapper;
import br.com.rompi.cliente.adapters.in.controller.request.ClientRequest;
import br.com.rompi.cliente.adapters.in.controller.response.ClientResponse;
import br.com.rompi.cliente.application.core.domain.Client;
import br.com.rompi.cliente.application.ports.in.*;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final InsertClientInputPort insertClientInputPort;
    private final FindClientByIdInputPort findClienByIdtInputPort;
    private final FindClientAllInputPort findClientAllInputPort;
    private final DeleteClientInputPort deleteClientInputPort;
    private final UpdateClientInputPort updateClientInputPort;
    private final ClientMapper clientMapper;

    @GetMapping
    public ResponseEntity<List<?>> findAllClients(){
        List<Client> listClient = findClientAllInputPort.execute();
        List<ClientResponse> listResponse = listClient.stream().map(client ->
                        toLinks(clientMapper.toClientResponse(client)))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listResponse);
    }

    @GetMapping("/{idClients}")
    public ResponseEntity<ClientResponse> findClientsById(@PathVariable Long idClients) {
        Optional<Client> client = findClienByIdtInputPort.execute(idClients);
        if (client.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ClientResponse clientResponse = clientMapper.toClientResponse(client.get());
        return ResponseEntity.ok().body(toLinks(clientResponse));
    }

    @PostMapping
    public ResponseEntity<ClientResponse> insertClients(@Valid @RequestBody ClientRequest clientRequest) {
        Client client = clientMapper.toClient(clientRequest);
        insertClientInputPort.execute(client, clientRequest.getCep());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idClients}")
    public ResponseEntity<ClientResponse> updateClients(@PathVariable Long idClients, @RequestBody ClientRequest clientRequest){
        Optional<Client> client = findClienByIdtInputPort.execute(idClients);
        if (client.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Client clientUpdate = clientMapper.toClient(clientRequest);
        clientUpdate.setId(idClients);
        updateClientInputPort.execute(clientUpdate, clientRequest.getCep());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{idClients}")
    public ResponseEntity<Void> deleteClients(@PathVariable Long idClients){
        Optional<Client> client = findClienByIdtInputPort.execute(idClients);
        if (client.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        deleteClientInputPort.execute(idClients);
        return ResponseEntity.noContent().build();
    }

    private ClientResponse toLinks(ClientResponse clientResponse){

        clientResponse.add(linkTo(methodOn(ClientController.class)
                .findClientsById(clientResponse.getId())).withSelfRel());

        clientResponse.add(linkTo(methodOn(ClientController.class)
                .findAllClients()).withRel("Lista de Clientes"));

        clientResponse.add(linkTo(methodOn(ClientController.class)
                .updateClients(clientResponse.getId(), new ClientRequest())).withRel("Update"));

        clientResponse.add(linkTo(methodOn(ClientController.class)
                .deleteClients(clientResponse.getId())).withRel("Delete"));

        return clientResponse;
    }
}
