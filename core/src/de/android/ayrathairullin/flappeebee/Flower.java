package de.android.ayrathairullin.flappeebee;


import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Flower {
    private static final float COLLISION_RECTANGLE_WIDTH = 13;
    private static final float COLLISION_RECTANGLE_HEIGHT = 447;
    private static final float COLLISION_CIRCLE_RADIUS = 33;
    private static final float MAX_SPEED_PER_SECOND = 3; // TODO 100
    public static final float WIDTH = COLLISION_CIRCLE_RADIUS * 2;
    private static final float HEIGHT_OFFSET = - 400;
    private static final float DISTANCE_BETWEEN_FLOOR_AND_CELLING = 225;

    private final Circle floorCollisionCircle, cellingCollisionCircle;
    private final Rectangle floorCollisionRectangle, cellingCollisionRectangle;
    private float x = 0, y = 0;
    private boolean pointClaimed = false;

    public Flower() {
        this.y = MathUtils.random(HEIGHT_OFFSET);
        this.floorCollisionRectangle = new Rectangle(x, y,
                COLLISION_RECTANGLE_WIDTH, COLLISION_RECTANGLE_HEIGHT);
        this.floorCollisionCircle = new Circle(x + floorCollisionRectangle.width / 2,
                y + floorCollisionRectangle.height,
                COLLISION_CIRCLE_RADIUS);

        this.cellingCollisionRectangle = new Rectangle(x, floorCollisionCircle.y + DISTANCE_BETWEEN_FLOOR_AND_CELLING,
                COLLISION_RECTANGLE_WIDTH, COLLISION_RECTANGLE_HEIGHT);
        this.cellingCollisionCircle = new Circle(x + cellingCollisionRectangle.width / 2,
                cellingCollisionRectangle.y, COLLISION_CIRCLE_RADIUS);
    }

    public void setPosition(float x) {
        this.x = x;
        updateCollisionCircle();
        updateCollisionRectangle();
    }

    private void updateCollisionCircle() {
        floorCollisionCircle.setX(x + floorCollisionRectangle.width / 2);
        cellingCollisionCircle.setX(x + cellingCollisionRectangle.width / 2);
    }

    private void updateCollisionRectangle() {
        floorCollisionRectangle.setX(x);
        cellingCollisionRectangle.setX(x);
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        shapeRenderer.circle(floorCollisionCircle.x, floorCollisionCircle.y, floorCollisionCircle.radius);
        shapeRenderer.rect(floorCollisionRectangle.x, floorCollisionRectangle.y, floorCollisionRectangle.width,
                floorCollisionRectangle.height);

        shapeRenderer.circle(cellingCollisionCircle.x, cellingCollisionCircle.y, cellingCollisionCircle.radius);
        shapeRenderer.rect(cellingCollisionRectangle.x, cellingCollisionRectangle.y, cellingCollisionRectangle.width,
                cellingCollisionRectangle.height);
    }

    public void update(float delta) {
        setPosition(x - (MAX_SPEED_PER_SECOND + delta));
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean isFlappeeColliding(Flappee flappee) {
        Circle flappeeCollisionCircle = flappee.getCollisionCircle();
        return Intersector.overlaps(flappeeCollisionCircle, cellingCollisionCircle) ||
                Intersector.overlaps(flappeeCollisionCircle, floorCollisionCircle) ||
                Intersector.overlaps(flappeeCollisionCircle, cellingCollisionRectangle) ||
                Intersector.overlaps(flappeeCollisionCircle, floorCollisionRectangle);
    }

    public boolean isPointClaimed() {
        return pointClaimed;
    }

    public void markPointClaimed() {
        pointClaimed = true;
    }
}
