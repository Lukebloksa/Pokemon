package org.example.api;

import org.example.data.Move;
import org.example.data.Pokemon;
import org.example.data.Type;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

@Service
public class Logic {
    // Pikachu and pikachu abilities
    Move thunderbolt = new Move("Thunderbolt", Type.ELECTRIC, 15, 2.0);
    Move quickAttack = new Move("Quick Attack", Type.NORMAL, 25, 1.2);
    Move voltTackle = new Move("Volt Tackle", Type.ELECTRIC, 20, 1.6);
    Move niggaShock = new Move("Nigga Shock", Type.ELECTRIC, 5, 10.5);
    Move[] pikachusAbilties = new Move[] {quickAttack, thunderbolt, voltTackle, niggaShock};

    LinkedList<String> evolutions = new LinkedList<>(List.of("Pichu", "Pikachu", "Raichu"));

    Pokemon pikachu = new Pokemon("/pikachu.jpg" , 25, "Pikachu", EnumSet.of(Type.ELECTRIC), pikachusAbilties, 60, 350, 370, EnumSet.of(Type.GROUND), evolutions, 1);

    // Charmander and abilities
    Move tackle = new Move("Tackle", Type.NORMAL, 25, 1.1);
    Move slash = new Move("Slash", Type.NORMAL, 25, 1.2);
    Move flamethrower = new Move("Flamethrower", Type.ELECTRIC, 15, 1.7);
    Move fireFang = new Move("Fire Fang", Type.ELECTRIC, 15, 1.4);
    Move[] charmanderAbilties = new Move[] {tackle, slash, flamethrower, fireFang};

    LinkedList<String> evolutions2 = new LinkedList<>(List.of("Charmander", "Charmelion", "Charizard"));

    Pokemon charmander = new Pokemon("/charmander.jpg", 6, "Charmander", EnumSet.of(Type.FIRE), charmanderAbilties, 80, 140, 200, EnumSet.of(Type.GROUND, Type.WATER), evolutions2, 0);

    List<Pokemon> pokemons = new LinkedList<>(List.of(charmander, pikachu));

    Pokemon player;
    Pokemon opponent;

    public Pokemon attack(Pokemon player, Pokemon opponent, int moveIndex) {
        double dmg = (player.getDmg() * player.getAbilities()[moveIndex].getDmgAmplifier())/opponent.getDefense();
        opponent.setHp((int) (opponent.getHp()-dmg));

        player.getAbilities()[moveIndex].setPp(player.getAbilities()[moveIndex].getPp()-1);

        if (opponent.getHp() <= 0) {
            opponent.setHp(0);
        }
        return opponent;
    };

    public boolean isGameOver(Pokemon player, Pokemon opponent) {
        if (opponent.getHp() <= 0 || player.getHp() <= 0) {
            win(player, opponent);
            lose(player, opponent);
        }
        return false;
    }

    public boolean win(Pokemon player, Pokemon opponent) {
        return opponent.getHp() <= 0 && player.getHp() > 0;
    }

    public boolean lose(Pokemon player, Pokemon opponent) {
        return opponent.getHp() > 0 && player.getHp() <= 0;
    }
}