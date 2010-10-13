package com.theladders.gwt.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class WelcomeViewImpl extends Composite implements WelcomeView {

  private static WelcomeViewImplUiBinder uiBinder = GWT.create(WelcomeViewImplUiBinder.class);

  interface WelcomeViewImplUiBinder extends UiBinder<Widget, WelcomeViewImpl> {
  }

  @UiField
  Button button;

  public WelcomeViewImpl() {
    initWidget(uiBinder.createAndBindUi(this));
    button.setText("Welcome");
  }

  @UiHandler("button")
  void onClick(ClickEvent e) {
    Window.alert("Hello!");
  }

  public void setText(String text) {
    button.setText(text);
  }

  public String getText() {
    return button.getText();
  }

}
