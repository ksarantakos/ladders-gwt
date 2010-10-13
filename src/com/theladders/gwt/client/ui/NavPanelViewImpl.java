package com.theladders.gwt.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class NavPanelViewImpl extends Composite implements NavPanelView {

  private static NavPanelViewImplUiBinder uiBinder = GWT.create(NavPanelViewImplUiBinder.class);

  interface NavPanelViewImplUiBinder extends UiBinder<Widget, NavPanelViewImpl> {
  }


  @UiField
  Button button;

  public NavPanelViewImpl() {
    initWidget(uiBinder.createAndBindUi(this));
    button.setText("NavPanel");
  }

  @UiHandler("button")
  void onClick(ClickEvent e) {
    Window.alert("Hello from Nav Panel");
  }

  public void setText(String text) {
    button.setText(text);
  }

  public String getText() {
    return button.getText();
  }

}
