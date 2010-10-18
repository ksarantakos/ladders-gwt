package com.theladders.gwt.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * View interface. Extends IsWidget so a view impl can easily provide its
 * container widget.
 * 
 * @author drfibonacci
 */
public interface HomeView extends IsWidget {

  void setPresenter(Presenter presenter);

  public interface Presenter {
    void goTo(Place place);
  }

  void setContentView(Widget content);

  SimplePanel getDisplay();
}