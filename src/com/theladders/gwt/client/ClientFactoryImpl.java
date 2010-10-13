package com.theladders.gwt.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.theladders.gwt.client.ui.HomeView;
import com.theladders.gwt.client.ui.HomeViewImpl;

public class ClientFactoryImpl implements ClientFactory {
  private static final EventBus eventBus = new SimpleEventBus();
  private static final PlaceController placeController = new PlaceController(eventBus);
  private static final HomeView homeView = new HomeViewImpl();
  @Override
  public EventBus getEventBus() {
    return eventBus;
  }

  @Override
  public HomeView getHomeView() {
    return homeView;
  }

  @Override
  public PlaceController getPlaceController() {
    return placeController;
  }

}
