package com.example.wwwweek56.controllers;

import com.example.wwwweek56.models.Address;
import com.example.wwwweek56.models.Candidate;
import com.example.wwwweek56.repositories.AddressRepository;
import com.example.wwwweek56.repositories.CandidateRepository;
import com.neovisionaries.i18n.CountryCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/candidates")
public class CandidateController {

    private final CandidateRepository candidateRepository;
    private final AddressRepository addressRepository;

    public CandidateController(CandidateRepository candidateRepository, AddressRepository addressRepository) {
        this.candidateRepository = candidateRepository;
        this.addressRepository = addressRepository;
    }

    @GetMapping("")
    public String getCandidateList(Model model) {
        List<Candidate> candidates = candidateRepository.findAll();
        model.addAttribute("candidates", candidates);
        return "candidates/candidate";
    }

    @GetMapping("/page")
    public String getCandidateListPage(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

        int curPage = page.orElse(1);
        int pageSize = size.orElse(7);

        Pageable pageable = PageRequest.of(curPage - 1, pageSize, Sort.by(Sort.Direction.ASC, "id"));

        Page<Candidate> candidatesPage = candidateRepository.findAll(pageable);
        model.addAttribute("candidates_page", candidatesPage.getContent());

        List<Integer> totalPage = IntStream.rangeClosed(1, candidatesPage.getTotalPages()).boxed().collect(Collectors.toList());

        model.addAttribute("totalPage", totalPage);
        model.addAttribute("curPage", curPage);
        return "candidates/page";
    }

    @PostMapping("/update")
    public String updateCandidate(@RequestParam("fullName") String fullName, @RequestParam("id") long id, @RequestParam("idAdd") long idAdd, @RequestParam("email") String email, @RequestParam("dob") LocalDate dob, @RequestParam("phone") String phone, @RequestParam("address") String addressCode) {
        Address address = addressRepository.findById(idAdd).orElse(new Address());
        address.setCountry(CountryCode.getByCode(addressCode));
        addressRepository.save(address);

        Candidate candidate = new Candidate(id, dob, email, fullName, phone, address, List.of(), List.of());
        candidateRepository.save(candidate);

        return "redirect:/candidates/page";
    }

    @GetMapping("/form-add")
    public String getAddForm(Model model) {
        List<CountryCode> listCountryCodes = List.of(CountryCode.values());
        model.addAttribute("listCountryCodes", listCountryCodes);
        return "candidates/add";
    }

    @GetMapping("/form-update/{id}")
    public String getUpdateForm(Model model, @PathVariable("id") long id) {
        Candidate candidate = candidateRepository.findById(id).orElse(null);
        if (candidate == null) {
            return "candidates/page";
        }

        model.addAttribute("candidate", candidate);

        List<CountryCode> listCountryCodes = List.of(CountryCode.values());
        model.addAttribute("listCountryCodes", listCountryCodes);

        return "candidates/update";
    }

    @PostMapping("/delete/{id}")
    public String deleteCandidate(@PathVariable("id") long id) {
        candidateRepository.deleteById(id);
        return "redirect:/candidates/page";
    }

    @PostMapping("/add")
    public String addCandidate(@RequestParam("fullName") String fullName, @RequestParam("email") String email, @RequestParam("dob") LocalDate dob, @RequestParam("phone") String phone, @RequestParam("address") String addressCode) {
        Address address = new Address(CountryCode.getByCode(addressCode));
        addressRepository.save(address);

        Candidate candidate = new Candidate(dob, email, fullName, phone, address, List.of(), List.of());
        candidateRepository.save(candidate);

        return "redirect:/candidates/page";
    }

}
