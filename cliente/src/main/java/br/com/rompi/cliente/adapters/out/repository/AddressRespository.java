package br.com.rompi.cliente.adapters.out.repository;

import br.com.rompi.cliente.adapters.out.repository.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRespository extends JpaRepository<AddressEntity, Long> {
}
