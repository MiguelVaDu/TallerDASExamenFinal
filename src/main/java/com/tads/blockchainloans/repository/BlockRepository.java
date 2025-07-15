package com.tads.blockchainloans.repository;


import com.tads.blockchainloans.model.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface BlockRepository extends JpaRepository<Block, Long> {
    Optional<Block> findTopByOrderByIdDesc();
    List<Block> findAllByOrderByTimestampAsc();
}

