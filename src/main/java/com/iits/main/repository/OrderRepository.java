package com.iits.main.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.iits.main.entity.Orders;
 

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long>{

}
