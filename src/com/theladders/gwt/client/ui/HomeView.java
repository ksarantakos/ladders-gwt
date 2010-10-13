package com.theladders.gwt.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * View interface. Extends IsWidget so a view impl can easily provide its
 * container widget.
 * 
 * @author drfibonacci
 */
public interface HomeView extends IsWidget {

  void setListener(Listener listener);

  public interface Listener {
    void goTo(Place place);
  }
}