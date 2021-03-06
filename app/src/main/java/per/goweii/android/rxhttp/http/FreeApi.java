package per.goweii.android.rxhttp.http;

import io.reactivex.Observable;
import per.goweii.android.rxhttp.bean.RecommendPoetryBean;
import per.goweii.android.rxhttp.bean.SinglePoetryBean;
import per.goweii.android.rxhttp.bean.WeatherBean;
import per.goweii.rxhttp.request.Api;
import per.goweii.rxhttp.request.base.BaseBean;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * @author Cuizhen
 * @date 2018/10/13
 */
public class FreeApi extends Api {

    public static Service api() {
        return Api.api(Service.class);
    }

    public interface Service {
        /**
         * 随机单句诗词推荐
         */
        @Headers({Header.CACHE_CONTROL_AGE + ":" + 0})
        @GET("singlePoetry")
        Observable<ResponseBean<SinglePoetryBean>> singlePoetry();

        /**
         * 随机一首诗词推荐
         */
        @Headers({Header.CACHE_CONTROL_AGE + ":" + 0})
        @GET("recommendPoetry")
        Observable<ResponseBean<RecommendPoetryBean>> recommendPoetry();

        /**
         * 获取天气
         */
        @Headers({Header.BASE_URL_REDIRECT + ":" + Config.BASE_URL_OTHER_NAME})
        @GET("weatherApi?")
        Observable<ResponseBean<WeatherBean>> weather(@Query("city") String city);

        /**
         * 错误地址
         */
        @Headers({Header.BASE_URL_REDIRECT + ":" + Config.BASE_URL_ERROR_NAME})
        @GET("weatherApi?")
        Observable<ResponseBean<BaseBean>> errorHost();
    }
}
