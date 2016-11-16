package Screens;

import Menu.GamGame1;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ScrSongOne extends InputAdapter implements Screen {

    GamGame1 game;
    private SpriteBatch batch;
    private Texture img1, img2, img3, img4;
    private Sprite sprite1, sprite2, sprite3, sprite4;
    private boolean S, p = true, isExit, k, t, pause = false, isDone, isKeyChange;
    private BitmapFont font;
    private Circle circ;
    ShapeRenderer shapeRenderer;
    private Rectangle recTL, recTR, recBL, recBR;
    float XMid, YMid, good = 0, eff = 0, _good, _eff;
    int j = 0, count = 0, max = 150, nWhere = 0, nCount = 0;
    ArrayList<Integer> rand = new ArrayList<Integer>();
    private String[] ars = null;

    public ScrSongOne(GamGame1 _game) {
        this.game = _game;
    }

    @Override
    public void show() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        XMid = Gdx.graphics.getWidth() / 2;
        YMid = Gdx.graphics.getHeight() / 2;
        font = new BitmapFont();
        batch = new SpriteBatch();
        sprite1 = new Sprite(new Texture("Red.png"));//BL
        sprite2 = new Sprite(new Texture("Blue.png"));//BR
        sprite3 = new Sprite(new Texture("green.jpg"));//TL
        sprite4 = new Sprite(new Texture("black.jpg"));//TR
        shapeRenderer = new ShapeRenderer();
        circ = new Circle(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 150);
        sprite1.setSize(w / 2, h / 2);
        sprite2.setSize(w / 2, h / 2);
        sprite3.setSize(w / 2, h / 2);
        sprite4.setSize(w / 2, h / 2);
        recTL = new Rectangle(0, h / 2, w / 2, h / 2);
        recTR = new Rectangle(w / 2, h / 2, w / 2, h / 2);
        recBL = new Rectangle(0, 0, w / 2, h / 2);
        recBR = new Rectangle(w / 2, 0, w / 2, h / 2);
        sprite3.setPosition(recTL.x, recTL.y);
        sprite4.setPosition(recTR.x, recTR.y);
        sprite1.setPosition(recBL.x, recBL.y);
        sprite2.setPosition(recBR.x, recBR.y);
        Gdx.input.setInputProcessor(this);
        nWhere = ThreadLocalRandom.current().nextInt(0, 3 + 1);
        while (rand.size() < 4) {
            int newnum = ThreadLocalRandom.current().nextInt(0, 3 + 1);
            if (!rand.contains(newnum)) {
                rand.add(newnum);
            }
        }
        System.out.println(rand);
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        nCount++;
        if (nCount == 5) {
            isKeyChange = false;
            nCount = 0;
        }
        if (!isDone) {
            if (isKeyChange) {
                rand.clear();
                while (rand.size() < 4) {
                    int newnum = ThreadLocalRandom.current().nextInt(0, 3 + 1);
                    if (!rand.contains(newnum)) {
                        rand.add(newnum);
                    }
                } //index 0 = TL, 1 = TR, 2 = BL, 3 = BR
                //colour 0 = Green(s3), 1 = Red(s1), 2 = Blue(s2), 3 = Black(s4) 
                if (rand.get(0) == 0) { //if the arraylist has 0 at 0, TL = green
                    sprite3.setPosition(recTL.x, recTL.y);
                } else if (rand.get(0) == 1) {
                    sprite1.setPosition(recTL.x, recTL.y);
                } else if (rand.get(0) == 2) {
                    sprite2.setPosition(recTL.x, recTL.y);
                } else if (rand.get(0) == 3) {
                    sprite4.setPosition(recTL.x, recTL.y);
                } else if (rand.get(1) == 0) {
                    sprite3.setPosition(recTR.x, recTR.y);
                } else if (rand.get(1) == 1) {
                    sprite1.setPosition(recTR.x, recTR.y);
                } else if (rand.get(1) == 2) {
                    sprite2.setPosition(recTR.x, recTR.y);
                } else if (rand.get(1) == 3) {
                    sprite4.setPosition(recTR.x, recTR.y);
                } else if (rand.get(2) == 0) {
                    sprite3.setPosition(recBL.x, recBL.y);
                } else if (rand.get(2) == 1) {
                    sprite1.setPosition(recBL.x, recBL.y);
                } else if (rand.get(2) == 2) {
                    sprite2.setPosition(recBL.x, recBL.y);
                } else if (rand.get(2) == 3) {
                    sprite4.setPosition(recBL.x, recBL.y);
                } else if (rand.get(3) == 0) {
                    sprite3.setPosition(recBR.x, recBR.y);
                } else if (rand.get(3) == 1) {
                    sprite1.setPosition(recBR.x, recBR.y);
                } else if (rand.get(3) == 2) {
                    sprite2.setPosition(recBR.x, recBR.y);
                } else if (rand.get(3) == 3) {
                    sprite4.setPosition(recBR.x, recBR.y);
                }
            }
            shapeRenderer.begin(ShapeType.Filled);
            batch.begin();
            sprite1.draw(batch);
            sprite2.draw(batch);
            sprite3.draw(batch);
            sprite4.draw(batch);
            if (nWhere == 0) { //TL
                if (rand.get(0) == 0) { //TL GREEN
                    shapeRenderer.setColor(Color.GREEN);
                } else if (rand.get(0) == 1) {
                    shapeRenderer.setColor(Color.RED);
                } else if (rand.get(0) == 2) {
                    shapeRenderer.setColor(Color.BLUE);
                } else if (rand.get(0) == 3) {
                    shapeRenderer.setColor(Color.BLACK);
                }
            } else if (nWhere == 1) {
                if (rand.get(1) == 0) { //TR GREEN
                    shapeRenderer.setColor(Color.GREEN);
                } else if (rand.get(1) == 1) {
                    shapeRenderer.setColor(Color.RED);
                } else if (rand.get(1) == 2) {
                    shapeRenderer.setColor(Color.BLUE);
                } else if (rand.get(1) == 3) {
                    shapeRenderer.setColor(Color.BLACK);
                }
            } else if (nWhere == 2) {
                if (rand.get(2) == 0) { //BL GREEN
                    shapeRenderer.setColor(Color.GREEN);
                } else if (rand.get(2) == 1) {
                    shapeRenderer.setColor(Color.RED);
                } else if (rand.get(2) == 2) {
                    shapeRenderer.setColor(Color.BLUE);
                } else if (rand.get(2) == 3) {
                    shapeRenderer.setColor(Color.BLACK);
                }
            } else if (nWhere == 3) {
                if (rand.get(3) == 0) { //BR GREEN
                    shapeRenderer.setColor(Color.GREEN);
                } else if (rand.get(3) == 1) {
                    shapeRenderer.setColor(Color.RED);
                } else if (rand.get(3) == 2) {
                    shapeRenderer.setColor(Color.BLUE);
                } else if (rand.get(3) == 3) {
                    shapeRenderer.setColor(Color.BLACK);
                }
            }
//            if (j < 5) {
//                max = 150;
//            } else if (j >= 5 && j < 9) {
//                max = 100;
//            } else if (j >= 9 && j < 13) {
//                max = 71;
//            } else {
//                max = 43;
//            }
            font.draw(batch, String.valueOf(j), 200, YMid * 2);
            font.draw(batch, String.valueOf(good), 250, YMid * 2);
            font.draw(batch, String.valueOf(eff) + "%", 300, YMid * 2);
            font.draw(batch, String.valueOf(count) + " / " + String.valueOf(max), 425, YMid * 2);
            batch.end();
            shapeRenderer.circle(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 150);
            shapeRenderer.end();
//            if (!t) {
//                count++;
//            } else if (t) {
//                count = 0;
//            }
//            if (count == max) {
//                count = 0;
//                j++;
//            }
        } else {
            Gdx.gl.glClearColor(0, 0, 0, 1);
            p = false;
            game.nScreen = 1;
            game.updateState();
            dispose();
            batch.begin();
            font.draw(batch, "You clicked correctly " + String.valueOf(good) + " times out of " + String.valueOf(j), 250, YMid + 100);
            font.draw(batch, "Your efficiency was " + String.valueOf(eff) + "%", 250, YMid);
            font.draw(batch, "Press Escape to Exit", 250, YMid - 200);
            batch.end();
            if (isExit) {
                Gdx.app.exit();
            }
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        S = false;
        k = false;
        if (p) {
            if (button == Buttons.LEFT && recTL.contains(screenX, screenY)
                    && nWhere == 0 && !circ.contains(screenX, screenY)) {
                S = true;
            }
            if (button == Buttons.LEFT && recTR.contains(screenX, screenY)
                    && nWhere == 1 && !circ.contains(screenX, screenY)) {
                S = true;
            }
            if (button == Buttons.LEFT && recBL.contains(screenX, screenY)
                    && nWhere == 2 && !circ.contains(screenX, screenY)) {
                S = true;
            }
            if (button == Buttons.LEFT && recBR.contains(screenX, screenY)
                    && nWhere == 3 && !circ.contains(screenX, screenY)) {
                S = true;
            }
            if (!circ.contains(screenX, screenY)) {
                k = true;
            }
            if (S && k) {
                j++;
                good++;
                eff = (good / j) * 100;
            } else if (!S && k) {
                j++;
                eff = (good / j) * 100;
            }
        }
        nWhere = ThreadLocalRandom.current().nextInt(0, 3 + 1);
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ESCAPE) {
            isExit = true;
        } else if (keycode == Input.Keys.SPACE) {
            isDone = true;
        } else if (keycode == Input.Keys.ENTER) {
            isKeyChange = true;
        }
        return false;
    }
}