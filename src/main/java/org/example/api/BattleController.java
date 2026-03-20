package org.example.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class BattleController {

    @Autowired
    private Logic logic;

    Random rand = new Random();

    @GetMapping("/battle")
    public String battle(Model model) {
        model.addAttribute("player", logic.player);
        model.addAttribute("opponent", logic.opponent);

        return "battle";
    }

    @PostMapping("/attack")
    public String attack(Model model, @RequestParam int moveIndex) {
        logic.attack(logic.player, logic.opponent, moveIndex);
        model.addAttribute("opponent", logic.opponent);

        model.addAttribute("hitTarget", "opponent");

        int enemyMoveIndex = rand.nextInt(0, logic.opponent.getAbilities().length);

        logic.attack(logic.opponent, logic.player, enemyMoveIndex);
        model.addAttribute("player", logic.player);

        model.addAttribute("hitTarget", "player");

        return "battle";
    }
}
