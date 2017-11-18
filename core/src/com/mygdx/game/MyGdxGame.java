package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import Actors.AnimatedSprite;

public class MyGdxGame extends ApplicationAdapter {
	static final Color BACKGROUND_COLOUR = new Color(0f,0f,0f,1f);
	static final float WORLD_TO_SCREEN = 1.0f/100.0f;
	static final float SCENE_WIDTH = 1280f;
	static final float SCENE_HEIGHT = 720f;

	OrthographicCamera camera;
	Viewport view;
	SpriteBatch batch;
	AnimatedSprite spike_1,spike_2;
	float animationTime;
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		view = new ExtendViewport(800,600,camera);
		batch = new SpriteBatch();
		//textures used to size
		Texture small = new Texture(Gdx.files.internal("SpikeAnim/smallSize.png"));
		Texture medium = new Texture(Gdx.files.internal("SpikeAnim/mediumSize.png"));
		//create 2 new AnimatedSprite
		spike_1 = new AnimatedSprite("SpikeAnim/spike_anim.atlas",small, Animation.PlayMode.LOOP);
		spike_2 = new AnimatedSprite("SpikeAnim/spike_anim.atlas",medium, Animation.PlayMode.LOOP_REVERSED);
		//position sprites
		spike_1.setPosition((SCENE_WIDTH/2)-small.getWidth(),(SCENE_HEIGHT/2)-small.getHeight());
		spike_2.setPosition((SCENE_WIDTH/3)+medium.getWidth(),(SCENE_HEIGHT/2)-medium.getHeight());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(BACKGROUND_COLOUR.r,BACKGROUND_COLOUR.g,BACKGROUND_COLOUR.b,BACKGROUND_COLOUR.a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//update animtime
		animationTime += Gdx.graphics.getDeltaTime();
		batch.begin();
		//update
		spike_1.update(animationTime);
		spike_2.update(animationTime);
		//draw
		spike_1.draw(batch);
		spike_2.draw(batch);
		batch.end();
	}
	@Override
	public void resize(int width, int height) {
		view.update(width,height,true);
		batch.setProjectionMatrix(camera.combined);
	}
	@Override
	public void dispose () {
		batch.dispose();
	}
}
