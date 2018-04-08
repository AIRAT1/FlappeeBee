package de.android.ayrathairullin.flappeebee;

import com.badlogic.gdx.Game;

public class FlappeeBeeGame extends Game {
	@Override
	public void create() {
		setScreen(new GameScreen(this));
	}
}
