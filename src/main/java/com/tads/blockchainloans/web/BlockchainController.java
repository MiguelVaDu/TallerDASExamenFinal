package com.tads.blockchainloans.web;

import com.tads.blockchainloans.model.Block;
import com.tads.blockchainloans.service.BlockchainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/blocks")
public class BlockchainController {
    @Autowired private BlockchainService service;

    @GetMapping
    public String list(Model model) {
        List<Block> blocks = service.listBlocks();
        model.addAttribute("blocks", blocks);
        return "blocks/list";
    }

    @GetMapping("/new")
    public String form(Model m) {
        m.addAttribute("loan", new LoanForm());
        return "blocks/new";
    }

    @PostMapping
    public String create(@ModelAttribute LoanForm loan) {
        service.createBlock(
                loan.getCompanyName(),
                loan.getAmount(),
                loan.getInterestRate(),
                loan.getDueDate()
        );
        return "redirect:/blocks";
    }

    @GetMapping("/validate")
    public String validate(Model m) {
        m.addAttribute("valid", service.validateChain());
        return "blocks/validate";
    }
}

