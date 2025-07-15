package com.tads.blockchainloans.service;

import com.tads.blockchainloans.model.Block;
import com.tads.blockchainloans.repository.BlockRepository;
import com.tads.blockchainloans.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlockchainService {
    @Autowired private BlockRepository repo;

    public Block createBlock(String company, BigDecimal amount, Double rate, LocalDate due) {
        String prevHash = repo.findTopByOrderByIdDesc()
                .map(Block::getCurrentHash)
                .orElse("0".repeat(64));

        Block b = new Block();
        b.setTimestamp(LocalDateTime.now());
        b.setPreviousHash(prevHash);
        b.setCompanyName(company);
        b.setAmount(amount);
        b.setInterestRate(rate);
        b.setDueDate(due);

        String data = b.getTimestamp() + prevHash
                + company + amount + rate + due;
        b.setCurrentHash(HashUtil.sha256(data));

        return repo.save(b);
    }

    public boolean validateChain() {
        List<Block> chain = repo.findAllByOrderByTimestampAsc();
        for (int i = 1; i < chain.size(); i++) {
            if (!chain.get(i).getPreviousHash().equals(chain.get(i-1).getCurrentHash())) {
                return false;
            }
        }
        return true;
    }

    public List<Block> listBlocks() {
        return repo.findAllByOrderByTimestampAsc();
    }
}
