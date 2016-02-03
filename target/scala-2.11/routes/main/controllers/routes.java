
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/corbandalas/Java/workspace/msp/conf/routes
// @DATE:Wed Feb 03 12:43:59 MSK 2016

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseSwaggerController SwaggerController = new controllers.ReverseSwaggerController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReversePropertyController PropertyController = new controllers.ReversePropertyController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseSwaggerController SwaggerController = new controllers.javascript.ReverseSwaggerController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReversePropertyController PropertyController = new controllers.javascript.ReversePropertyController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
  }

}
