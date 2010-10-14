package com.theladders.gwt.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class WelcomePlace extends Place {

  private String person;

  public WelcomePlace(String person) {
    this.person = person;
  }

  public String getPerson() {
    return person;
  }

  public static class Tokenizer implements PlaceTokenizer<WelcomePlace> {
    @Override
    public String getToken(WelcomePlace place) {
      return place.getPerson();
    }

    @Override
    public WelcomePlace getPlace(String token) {
      return new WelcomePlace(token);
    }
  }
}
