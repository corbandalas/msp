package services;

import dto.customer.CustomerPaylikeCreditCardDeposit;
import org.apache.commons.jcs.JCS;
import org.apache.commons.jcs.access.CacheAccess;
import org.apache.commons.jcs.engine.control.CompositeCacheManager;
import play.Logger;

/**
 * Cache manager provider
 *
 * @author corbandalas - created 09.10.2018
 * @since 0.7.0
 */


public class CacheProvider {

    private CacheAccess<String, Object> defaultCache;


    private static CacheProvider cacheProvider;

    private CacheProvider() {
        Logger.info("///// Loading Cache Provider");

        CompositeCacheManager compositeCacheManager = CompositeCacheManager.getInstance();

        compositeCacheManager.configure();

        defaultCache = JCS.getInstance("default");
    }


    public Object getObject(String key) {
        return defaultCache.get(key);
    }

    public void putObject(String key, Object value) {
        defaultCache.put(key, value);
    }


//    public CustomerPaylikeCreditCardPurchaseCacheObject getPayLikePurchaseCacheObject(String key) {
//        return payLikePurchaseCache.get(key);
//    }
//
//    public CustomerPaylikeCreditCardDepositCacheObject getPayLikeDepositCacheObject(String key) {
//        return payLikeDepositCache.get(key);
//    }


//    public void putToken(String key, Token token) {
//        tokenCache.put(key, token);
//    }

//    public void putPaylikePurchaseCacheObject(String key, CustomerPaylikeCreditCardPurchaseCacheObject customerPaylikeCreditCardPurchaseCacheObject) {
//        payLikePurchaseCache.put(key, customerPaylikeCreditCardPurchaseCacheObject);
//    }

//    public void putPaylikeDepositCacheObject(String key, CustomerPaylikeCreditCardDepositCacheObject customerPaylikeCreditCardDepositCacheObject) {
//        payLikeDepositCache.put(key, customerPaylikeCreditCardDepositCacheObject);
//    }

//    public void removePaylikePurchaseCacheObject(String key) {
//        payLikePurchaseCache.remove(key);
//    }

    public void remove(String key) {
        defaultCache.remove(key);
    }

    public static CacheProvider getInstance() {
        if (cacheProvider == null) {
            cacheProvider = new CacheProvider();
        }

        return cacheProvider;
    }

}
