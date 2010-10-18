package com.theladders.gwt.client.place;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.theladders.gwt.client.place.ActivityPlace.Tokenizer;

/**
 * This is temporary until I get the story on the assertion in
 * AbstractPlaceHistoryHandler#register
 * 
 * @author drfibonacci
 * 
 */
public class TokenizerFactory {
  public final Tokenizer mainTokenizer = new ActivityPlace.Tokenizer();

  public PlaceTokenizer<ActivityPlace<? extends Activity>> getTokenizer() {
    return mainTokenizer;
  }
}
