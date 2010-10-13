package com.theladders.gwt.client.place;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public abstract class ActivityPlace<T extends Activity> extends Place {
  protected abstract Place getPlace(String token);

  protected abstract String getToken(Place place);

  // Called by ActivityPlaceActivityMapper
  protected abstract T getActivity();

  public static class Tokenizer implements PlaceTokenizer<ActivityPlace> {
    @Override
    public String getToken(ActivityPlace place) {
      return getToken(place);
    }

    @Override
    public ActivityPlace getPlace(String token) {
      return getPlace(token);
    }
  }
}
