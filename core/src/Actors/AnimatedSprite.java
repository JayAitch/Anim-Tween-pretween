package Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import java.util.Comparator;

/**
 * Created by Jordan Harrison on 18/11/2017.
 */

public class AnimatedSprite extends Sprite{
    private Animation animation;
    private TextureAtlas atlas;
    private float FRAME_DURATION = 1.0f/30.0f;
    public AnimatedSprite(String atlasString, Texture size, Animation.PlayMode loopType){
        super(size);
        atlas = new TextureAtlas(Gdx.files.internal(atlasString));
        //load amim
        Array<TextureAtlas.AtlasRegion> regions = new Array<TextureAtlas.AtlasRegion>(atlas.getRegions());
        regions.sort(new RegionComparator());
        animation = new Animation(FRAME_DURATION, regions, loopType);

    }

    public void update(float deltaTime){
        //update
        this.setRegion((TextureRegion) animation.getKeyFrame(deltaTime));
    }
    private static class RegionComparator implements Comparator<TextureAtlas.AtlasRegion> {
    public int compare(TextureAtlas.AtlasRegion region1, TextureAtlas.AtlasRegion region2){
        return region1.name.compareTo(region2.name);
    }
    }
}
