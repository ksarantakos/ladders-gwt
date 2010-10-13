package com.theladders.gwt.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.theladders.gwt.client.ui.GoodbyeView;
import com.theladders.gwt.client.ui.GoodbyeViewImpl;
import com.theladders.gwt.client.ui.HomeView;
import com.theladders.gwt.client.ui.HomeViewImpl;

public class ClientFactoryImpl implements ClientFactory {
  private static final EventBus eventBus = new SimpleEventBus();
  private static final PlaceController placeController = new PlaceController(eventBus);
  private static final HomeView homeView = new HomeViewImpl();
  private static final GoodbyeView goodbyeView = new GoodbyeViewImpl();

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

  @Override
  public GoodbyeView getGoodbyeView() {
    return goodbyeView;
  }

}
