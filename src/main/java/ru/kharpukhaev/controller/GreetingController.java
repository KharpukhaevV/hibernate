package ru.kharpukhaev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kharpukhaev.entity.Client;
import ru.kharpukhaev.entity.Passport;
import ru.kharpukhaev.entity.Transfer;
import ru.kharpukhaev.repository.ClientRepository;
import ru.kharpukhaev.repository.PassportRepository;
import ru.kharpukhaev.repository.TransferRepository;

import java.util.Optional;

@Controller
public class GreetingController {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PassportRepository passportRepository;

    @Autowired
    TransferRepository transferRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping
    public String index(Model model) {

        model.addAttribute("clients", clientRepository.findAll());
        return "index";
    }

    @PostMapping
    public String add(@RequestParam String firstname,
                      @RequestParam String lastname,
                      @RequestParam String serial,
                      @RequestParam String number) {

        Passport passport = new Passport(firstname, lastname, serial, number);

        Client client = new Client(firstname + " " + lastname, passport);
        passport.setClient(client);

        passportRepository.save(passport);
        clientRepository.save(client);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("client", clientRepository.findById(id).get());
        model.addAttribute("transfers", transferRepository.findAll());
        return "show";
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam String accountNumber, @RequestParam long transferSum, Model model) {
        Client client = (Client) model.getAttribute("client");
        Transfer transfer = new Transfer(client, accountNumber, transferSum);
        transferRepository.save(transfer);
        return "redirect:/";
    }

}