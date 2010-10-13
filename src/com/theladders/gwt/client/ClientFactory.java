package com.theladders.gwt.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.theladders.gwt.client.ui.GoodbyeView;
import com.theladders.gwt.client.ui.HomeView;

public interface ClientFactory {
  EventBus getEventBus();

  PlaceController getPlaceController();

  HomeView getHomeView();

  GoodbyeView getGoodbyeView();
}
