package org.jboss.errai.demo.client.local.pageStruct;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import org.jboss.errai.demo.client.local.ContactPage;
import org.jboss.errai.demo.client.local.HomePage;
import org.jboss.errai.demo.client.local.PortfolioPage;
import org.jboss.errai.demo.client.local.ReferencePage;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.nav.client.local.TransitionAnchor;
import org.jboss.errai.ui.shared.TemplateWidget;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Templated("TopBar.html#topBar")
@ApplicationScoped
public class TopBar extends Composite{

  @Inject
  private Navigation nav;



  @Inject
  @DataField
  private TransitionAnchor<HomePage> home;

  @Inject
  @DataField
  private TransitionAnchor<PortfolioPage> portfolio;

  @Inject
  @DataField
  private TransitionAnchor<ReferencePage> reference;

  @Inject
  @DataField
  private TransitionAnchor<ContactPage> contact;

  public TopBar(){
    //handler pro prirazovani/odebirani class menu itemum
    History.addValueChangeHandler(new ValueChangeHandler<String>(){
      @Override
      public void onValueChange(ValueChangeEvent<String> event){
        TemplateWidget tw = (TemplateWidget)TopBar.this.getWidget();
        if(TopBar.this.nav.getCurrentPage() != null){
          for(Widget widget : tw){
            if(widget instanceof TransitionAnchor){
              TransitionAnchor ta = (TransitionAnchor)widget;
              Element parent = ta.getElement().getParentElement();
              if(ta.toPageType().getSimpleName().equals(TopBar.this.nav.getCurrentPage().name())){
                parent.addClassName("active");
              }else{
                parent.removeClassName("active");
              }
            }
          }
        }
      }
    });
  }

}
