package com.android.custom.carlib.entity;

import java.util.List;

/**
 * @ProjectName: CarIDRead
 * @Package: com.android.custom.carlib.entity
 * @ClassName: CarReadEntity
 * @Author: 1984629668@qq.com
 * @CreateDate: 2020/12/22 14:37
 */
public class CarReadEntity {

    /**
     * config_str : {\"multi_crop\":true}
     * plates : [{"detail":"冀AA617A,0.99753#冀AA617A,0.997782#冀AA617A,0.999783#冀AA617A,0.999999","prob":0.9975295662879944,"roi":{"h":35,"w":90,"x":17,"y":21},"txt":"冀AA617A","cls_name":"新能源车","cls_prob":0.999987}]
     * success : true
     */

    private String config_str;
    private boolean success;
    private List<PlatesBean> plates;

    public String getConfig_str() {
        return config_str;
    }

    public void setConfig_str(String config_str) {
        this.config_str = config_str;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<PlatesBean> getPlates() {
        return plates;
    }

    public void setPlates(List<PlatesBean> plates) {
        this.plates = plates;
    }

    public static class PlatesBean {
        /**
         * detail : 冀AA617A,0.99753#冀AA617A,0.997782#冀AA617A,0.999783#冀AA617A,0.999999
         * prob : 0.9975295662879944
         * roi : {"h":35,"w":90,"x":17,"y":21}
         * txt : 冀AA617A
         * cls_name : 新能源车
         * cls_prob : 0.999987
         */

        private String detail;
        private double prob;
        private RoiBean roi;
        private String txt;
        private String cls_name;
        private double cls_prob;

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public double getProb() {
            return prob;
        }

        public void setProb(double prob) {
            this.prob = prob;
        }

        public RoiBean getRoi() {
            return roi;
        }

        public void setRoi(RoiBean roi) {
            this.roi = roi;
        }

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }

        public String getCls_name() {
            return cls_name;
        }

        public void setCls_name(String cls_name) {
            this.cls_name = cls_name;
        }

        public double getCls_prob() {
            return cls_prob;
        }

        public void setCls_prob(double cls_prob) {
            this.cls_prob = cls_prob;
        }

        public static class RoiBean {
            /**
             * h : 35
             * w : 90
             * x : 17
             * y : 21
             */

            private int h;
            private int w;
            private int x;
            private int y;

            public int getH() {
                return h;
            }

            public void setH(int h) {
                this.h = h;
            }

            public int getW() {
                return w;
            }

            public void setW(int w) {
                this.w = w;
            }

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }
        }
    }
}
