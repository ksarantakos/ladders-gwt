package com.theladders.gwt.client.place;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * PlaceHistoryMapper interface is used to attach all places which the 
 * PlaceHistoryHandler should be aware of. This is done via the @WithTokenizers
 * annotation or by extending PlaceHistoryMapperWithFactory and creating a 
 * separate TokenizerFactory.
 */
@WithTokenizers({HelloPlace.Tokenizer.class, GoodbyePlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper
{
}
