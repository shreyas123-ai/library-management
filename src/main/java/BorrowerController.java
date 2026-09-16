package com.example.library;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/borrowers")
public class BorrowerController {

    private final BorrowerRepository borrowerRepository;

    public BorrowerController(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    @GetMapping
    public List<Borrower> getAllBorrowers() {
        return borrowerRepository.findAll();
    }

    @PostMapping
    public Borrower createBorrower(@RequestBody Borrower borrower) {
        return borrowerRepository.save(borrower);
    }

    @GetMapping("/{id}")
    public Borrower getBorrowerById(@PathVariable Long id) {
        return borrowerRepository.findById(id).orElseThrow();
    }
}