package org.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class SelectorController {
    @Autowired
    private Logic logic;

    Random rand = new Random();

    @GetMapping("/getPokemons")
    public String getPokemons(Model model) {
        model.addAttribute("roster",logic.pokemons);
        return "pokemonSelector";
    }

    @PostMapping("/start-battle")
    public String startBattle(Model model, @RequestParam int selectedIndex) {
        int enemyPokemon = rand.nextInt(0, logic.pokemons.size());

        logic.player = logic.pokemons.get(selectedIndex);
        logic.opponent = logic.pokemons.get(enemyPokemon);

        return "redirect:/battle";
    }

    @PostMapping("/heal")
    public String heal(Model model, @RequestParam int selectedIndex) {
        logic.healPokemon(logic.pokemons, selectedIndex);
        model.addAttribute("roster", logic.pokemons);
        return "pokemonSelector";
    }
}
