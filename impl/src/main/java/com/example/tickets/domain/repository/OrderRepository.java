package com.example.tickets.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.tickets.domain.model.OrderEntity;
import com.example.tickets.domain.model.OrderEntityStatus;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

	List<OrderEntity> findAll();

	Optional<OrderEntity> findFirstByStatusEquals(OrderEntityStatus status);

	@Modifying
	@Query("UPDATE orders a SET a.status = :newStatus WHERE a.id = :appId")
	void changeStatus(@Param("appId") long appId, @Param("newStatus") OrderEntityStatus newStatus);

}
