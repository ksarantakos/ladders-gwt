package com.theladders.gwt.client.place;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.theladders.gwt.client.ClientFactory;
import com.theladders.gwt.client.ui.HomeView;

public class HomeActivity extends AbstractActivity implements HomeView.Listener {
  // Used to obtain views, eventBus, placeController
  // Alternatively, could be injected via GIN
  private ClientFactory clientFactory;
  // Name that will be appended to "Hello,"
  private String name;

  public interface HelloListener {
    void goTo(Place place);
  }

  public HomeActivity(HomePlace place, ClientFactory clientFactory) {
    this.name = place.getHelloName();
    this.clientFactory = clientFactory;
  }

  @Override
  public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
    HomeView homeView = clientFactory.getHomeView();
    homeView.setListener(this);
    containerWidget.setWidget(homeView.asWidget());
  }

  /**
   * Ask user before stopping this activity
   */
  @Override
  public String mayStop() {
    return "Are you sure you want to leave this page?";
  }

  @Override
  public void goTo(Place place) {
    clientFactory.getPlaceController().goTo(place);
  }

}