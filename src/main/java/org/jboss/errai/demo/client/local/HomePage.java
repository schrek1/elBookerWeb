package org.jboss.errai.demo.client.local;

import com.google.gwt.user.client.ui.Composite;
import javax.inject.Inject;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Page(role = DefaultPage.class)
@Templated("HomePage.html#content")
public class HomePage extends Composite{

  @DataField
  @Inject
  private WorksTable portfolio;

}
