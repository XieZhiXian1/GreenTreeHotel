package com.jerry.greentreehotel.module.home.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/4/28 0028.
 */
public class ViewPageAdvertisement {


    /**
     * result : 0
     * message : 接口通信成功！
     * responseData : {"bannerList":[{"bannerId":1290,"description":"","bannerUrl":"http://appbanner.greentree.cn/Public/uploadfile/content/2016/02/20160222040140697.jpg"},{"bannerId":1293,"description":"","bannerUrl":"http://appbanner.greentree.cn/Public/uploadfile/content/2016/02/20160229011500572.jpg"},{"bannerId":1297,"description":"","bannerUrl":"http://appbanner.greentree.cn/Public/uploadfile/content/2016/03/20160307015949408.jpg"},{"bannerId":1298,"description":"","bannerUrl":"http://appbanner.greentree.cn/Public/uploadfile/content/2016/04/20160407031707625.jpg"},{"bannerId":1304,"description":"","bannerUrl":"http://appbanner.greentree.cn/Public/uploadfile/content/2016/04/20160422044700307.jpg"},{"bannerId":1305,"description":"http://m.998.com/ActivityInfo/MayDay/MayDay.html","bannerUrl":"http://appbanner.greentree.cn/Public/uploadfile/content/2016/04/20160426050341878.jpg"}]}
     */

    private String result;
    private String message;
    private ResponseDataBean responseData;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseDataBean getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseDataBean responseData) {
        this.responseData = responseData;
    }

    public static class ResponseDataBean {
        /**
         * bannerId : 1290
         * description :
         * bannerUrl : http://appbanner.greentree.cn/Public/uploadfile/content/2016/02/20160222040140697.jpg
         */

        private List<BannerListBean> bannerList;

        public List<BannerListBean> getBannerList() {
            return bannerList;
        }

        public void setBannerList(List<BannerListBean> bannerList) {
            this.bannerList = bannerList;
        }

        public static class BannerListBean {
            private int bannerId;
            private String description;
            private String bannerUrl;

            public int getBannerId() {
                return bannerId;
            }

            public void setBannerId(int bannerId) {
                this.bannerId = bannerId;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getBannerUrl() {
                return bannerUrl;
            }

            public void setBannerUrl(String bannerUrl) {
                this.bannerUrl = bannerUrl;
            }
        }
    }
}
