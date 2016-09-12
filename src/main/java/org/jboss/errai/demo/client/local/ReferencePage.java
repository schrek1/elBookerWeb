package org.jboss.errai.demo.client.local;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import javax.annotation.PostConstruct;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Page
@Templated("ReferencePage.html#content")
public class ReferencePage extends Composite{

  @PostConstruct
  public void init(){
    Window.scrollTo(0, 0);
  }

}
