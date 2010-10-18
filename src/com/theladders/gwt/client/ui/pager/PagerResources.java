package com.theladders.gwt.client.ui.pager;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.SimplePager.Resources;

public interface PagerResources extends Resources {

  @Source("ForwardArrow.gif")
  @Override
  public ImageResource simplePagerNextPage();

  @Source("BackwardArrow.gif")
  @Override
  public ImageResource simplePagerPreviousPage();

  @Source("BackwardArrow.gif")
  @Override
  public ImageResource simplePagerFirstPage();

  @Source("BackwardArrow.gif")
  @Override
  public ImageResource simplePagerFirstPageDisabled();

  @Source("ForwardArrow.gif")
  @Override
  public ImageResource simplePagerLastPage();
  
  @Source("BackwardArrow.gif")
  @Override
  public ImageResource simplePagerPreviousPageDisabled();
}
