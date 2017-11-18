package utility;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

/**
 * Created by Jordan Harrison on 18/11/2017.
 */

public class UniversalResource {
    //common objects
    public TweenManager tweenManager;
    //singleton things
    private static UniversalResource instance;
    public static UniversalResource getInstance(){
        if(instance == null){
            instance = new UniversalResource();
        }
        return instance;
    }

    private UniversalResource(){configure();}

    public void configure(){
        Tween.setCombinedAttributesLimit(4);
        tweenManager = new TweenManager();
        Tween.registerAccessor(utility.TweenData.class, new utility.TweenDataAccessor());
    }
}
