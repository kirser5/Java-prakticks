package com.example.NotCursedWork.Controllers;

import com.example.NotCursedWork.models.Client;
import com.example.NotCursedWork.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class CController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/ClientDB")
    public String ClientAController(Model model){
        Iterable<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "ClientDB";
    }
    @PostMapping("/ClientDB/{id}/remove")
    public String ClientDelete(@PathVariable(value = "id") long id, Model model){
        Client client = clientRepository.findById(id).orElseThrow();
        clientRepository.delete(client);
        return "redirect:/ClientDB";
    }
    @GetMapping("/ClientDB/add")
    public String ClientAddController(Model model){
        return "ClientDB-add";
    }

    @PostMapping("/ClientDB/add")
    public String ClientAController(@RequestParam String CName, @RequestParam String CSurname, @RequestParam String CTelephone, @RequestParam String Alpha, @RequestParam String Beta, Model model){
        Client client = new Client(CName, CSurname, CTelephone, Alpha, Beta);
        clientRepository.save(client);
        return "redirect:/ClientDB";
    }
    @GetMapping("/ClientDB/{id}/edit")
    public String EditClientController(@PathVariable(value = "id") long id, Model model){
        if(!clientRepository.existsById(id)){
            return "redirect:/index";
        }
        Optional<Client> client = clientRepository.findById(id);
        ArrayList<Client> res = new ArrayList<>();
        client.ifPresent(res::add);
        model.addAttribute("client", res);
        return "ClientDB-edit";
    }
}