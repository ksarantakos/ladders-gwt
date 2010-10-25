package com.theladders.gwt.client.ui.pager;

import java.util.List;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.AbstractHasData;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionModel;
import com.theladders.gwt.client.content.ContactDatabase.ContactInfo;

public class JobTable<T> extends AbstractHasData<T> {

  
  public JobTable(ProvidesKey<T> keyProvider) {
    super(Document.get().createDivElement(), 20, keyProvider);
  }

  @Override
  protected boolean dependsOnSelection() {
    return false;
  }

  @Override
  protected Element getChildContainer() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Element getKeyboardSelectedElement() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected boolean isKeyboardNavigationSuppressed() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  protected void renderRowValues(SafeHtmlBuilder sb, List values, int start, SelectionModel selectionModel) {
    // TODO Auto-generated method stub

  }

  @Override
  protected boolean resetFocusOnCell() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  protected void setKeyboardSelected(int index, boolean selected, boolean stealFocus) {
    // TODO Auto-generated method stub

  }

  @Override
  protected void setSelected(Element elem, boolean selected) {
    // TODO Auto-generated method stub

  }

  public void addColumn(Column<ContactInfo, Boolean> checkColumn, SafeHtml fromSafeConstant) {
    // TODO Auto-generated method stub
    
  }

}
