
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/corbandalas/Java/workspace/msp/conf/routes
// @DATE:Wed Feb 03 12:43:59 MSK 2016

package pl.matisoft.swagger;

import router.RoutesPrefix;

public class routes {
  
  public static final pl.matisoft.swagger.ReverseApiHelpController ApiHelpController = new pl.matisoft.swagger.ReverseApiHelpController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final pl.matisoft.swagger.javascript.ReverseApiHelpController ApiHelpController = new pl.matisoft.swagger.javascript.ReverseApiHelpController(RoutesPrefix.byNamePrefix());
  }

}
