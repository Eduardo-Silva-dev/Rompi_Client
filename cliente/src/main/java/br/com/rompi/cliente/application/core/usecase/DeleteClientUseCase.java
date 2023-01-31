package br.com.rompi.cliente.application.core.usecase;

import br.com.rompi.cliente.application.ports.in.DeleteClientInputPort;
import br.com.rompi.cliente.application.ports.in.FindClientByIdInputPort;
import br.com.rompi.cliente.application.ports.out.DeleteClientOutputPort;

public class DeleteClientUseCase implements DeleteClientInputPort {

    private final FindClientByIdInputPort findClienByIdtInputPort;
    private final DeleteClientOutputPort deleteClientOutputPort;

    public DeleteClientUseCase(FindClientByIdInputPort findClienByIdtInputPort, DeleteClientOutputPort deleteClientOutputPort) {
        this.findClienByIdtInputPort = findClienByIdtInputPort;
        this.deleteClientOutputPort = deleteClientOutputPort;
    }

    @Override
    public void execute (long id){
        findClienByIdtInputPort.execute(id);
        deleteClientOutputPort.execute(id);
    }

}
