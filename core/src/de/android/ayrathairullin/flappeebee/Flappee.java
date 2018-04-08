package de.android.ayrathairullin.flappeebee;


import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;

public class Flappee {
    private static final float COLLISION_RADIUS = 24;
    private final Circle collisionCircle;

    private float x = 0;
    private float y = 0;

    public Flappee() {
        collisionCircle = new Circle(x, y, COLLISION_RADIUS);
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        shapeRenderer.circle(collisionCircle.x, collisionCircle.y, collisionCircle.radius);
    }
}
