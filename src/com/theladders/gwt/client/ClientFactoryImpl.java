package com.theladders.gwt.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.theladders.gwt.client.ui.BrowseJobsView;
import com.theladders.gwt.client.ui.BrowseJobsViewImpl;
import com.theladders.gwt.client.ui.HomeView;
import com.theladders.gwt.client.ui.HomeViewImpl;
import com.theladders.gwt.client.ui.WelcomeView;
import com.theladders.gwt.client.ui.WelcomeViewImpl;

public class ClientFactoryImpl implements ClientFactory {
  private static final EventBus eventBus = new SimpleEventBus();
  private static final PlaceController placeController = new PlaceController(eventBus);
  private static final HomeView homeView = new HomeViewImpl();
  private static final BrowseJobsView browseJobsView = new BrowseJobsViewImpl();
  private static final WelcomeView welcomeView = new WelcomeViewImpl();

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
  public BrowseJobsView getBrowseJobsView() {
    return browseJobsView;
  }

  @Override
  public WelcomeView getWelcomeView() {
    return welcomeView;
  }

}
