package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import Menu.GamGame1;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScrMainMenu extends InputAdapter implements Screen {

    GamGame1 game;
    private SpriteBatch batch;
    private boolean isSong, isExit;
    private BitmapFont font;
    private String SongChoice = "Song One";

    public ScrMainMenu(GamGame1 _game) {
        game = _game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(this);
        font = new BitmapFont();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        font.setColor(Color.RED);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        font.draw(batch, "Press Enter to Play Selected Song", Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        font.draw(batch, "Press Escape to Exit", Gdx.graphics.getWidth() / 2, 375);
        font.draw(batch, "Press 1 to select Song One", Gdx.graphics.getWidth() / 2, 150);
        font.draw(batch, SongChoice, Gdx.graphics.getWidth() / 2, 200);
        batch.end();
        if (isSong && SongChoice.equals("Song One")) {
            game.nScreen = 1;
            game.updateState();
            dispose();
        } else if (isSong && SongChoice.equals("Song Two")) {
            game.nScreen = 3;
            game.updateState();
            dispose();
        } else if (isSong && SongChoice.equals("Song Three")) {
            game.nScreen = 4;
            game.updateState();
            dispose();
        } else if (isExit) {
            Gdx.app.exit();
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ENTER) {
            isSong = true;
        } else if (keycode == Input.Keys.ESCAPE) {
            isExit = true;
        } else if (keycode == Input.Keys.NUM_1 || keycode == Input.Keys.NUMPAD_1) {
            SongChoice = "Song One";
        } else if (keycode == Input.Keys.NUM_2 || keycode == Input.Keys.NUMPAD_2) {
            SongChoice = "Song Two";
        } else if (keycode == Input.Keys.NUM_3 || keycode == Input.Keys.NUMPAD_3) {
            SongChoice = "Song Three";
        }
        return false;
    }
}