package com.theladders.gwt.client.place;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.theladders.gwt.client.ClientFactory;

public class AppActivityMapper implements ActivityMapper {

  private ClientFactory clientFactory;

  /**
   * AppActivityMapper associates each Place with its corresponding
   * {@link Activity}
   * 
   * @param clientFactory
   *          Factory to be passed to activities
   */
  public AppActivityMapper(ClientFactory clientFactory) {
    super();
    this.clientFactory = clientFactory;
  }

  /**
   * Map each Place to its corresponding Activity. This would be a great use for
   * GIN.
   */
  @Override
  public Activity getActivity(Place place) {
    // This is begging for GIN
    if (place instanceof HomePlace)
      return new HomeActivity((HomePlace) place, clientFactory);
//    else if (place instanceof GoodbyePlace)
//      return new GoodbyeActivity((GoodbyePlace) place, clientFactory);

    return null;
  }

}
