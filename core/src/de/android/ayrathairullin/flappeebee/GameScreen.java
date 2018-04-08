package de.android.ayrathairullin.flappeebee;


import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen extends ScreenAdapter {
    private static final float WORLD_WIDTH = 480;
    private static final float WORLD_HEIGHT = 640;

    private FlappeeBeeGame game;
    private ShapeRenderer renderer;
    private Viewport viewport;
    private OrthographicCamera camera;
    private SpriteBatch batch;

    public GameScreen(FlappeeBeeGame game) {
        this.game = game;
    }
}
