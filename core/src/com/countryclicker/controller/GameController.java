package com.countryclicker.controller;

import com.countryclicker.model.Human;
import com.countryclicker.model.World;

/**
 * Created by Илья on 06.05.2016.
 */
public class GameController {
    private World world;


    public GameController(World world) {
        this.world = world;
    }

    public void update(float delta) {
        world.update(delta);
    }

    public void humanClicked() {
        world.getHuman().state = Human.State.KICKED;
        world.updateMoney(world.getHuman().getMoneyPerClick());
    }


    public World getWorld() {
        return world;
    }
}
