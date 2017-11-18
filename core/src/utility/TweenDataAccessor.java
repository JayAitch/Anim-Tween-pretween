package utility;

import com.badlogic.gdx.graphics.Color;

import aurelienribon.tweenengine.TweenAccessor;

/**
 * Created by Jordan Harrison on 18/11/2017.
 */

public class TweenDataAccessor implements TweenAccessor<TweenData>{
    public final int TYPE_POS = 1;
    public static final int TYPE_SCALE = 2;
    public static final int TYPE_COLOUR = 3;
    public static final int TYPE_ROTATION = 4;
    public int getValues(TweenData target, int tweenTypes, float[] returnValues){
        switch(tweenTypes){
            case TYPE_POS:
                returnValues[0] = target.getXy().x;
                returnValues[1] = target.getXy().y;
                return 2;
            case TYPE_SCALE:
                returnValues[0] = target.getScale();
                return 1;
            case TYPE_COLOUR:
                returnValues[0] = target.getColour().r;
                returnValues[1] = target.getColour().g;
                returnValues[2] = target.getColour().b;
                returnValues[3] = target.getColour().a;
                return 3;
            case TYPE_ROTATION:
                returnValues[0] = target.getRotation();
                return  4;
            default:
                assert  false;
                return -1;
        }
    }
    @Override
    public void setValues(TweenData target, int tweenType,float[] newValues){
        switch(tweenType){
            case TYPE_POS:
                target.setXy(newValues[0],newValues[1]);
                break;
            case TYPE_COLOUR:
                Color c = target.getColour();
                c.set(newValues[0],newValues[1],newValues[2],newValues[3]);
                target.setColour(c);
                break;
            case TYPE_ROTATION:
                target.setRotation(newValues[0]);
            default:
                assert false;
        }
    }
}
