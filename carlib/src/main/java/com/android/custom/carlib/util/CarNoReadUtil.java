package com.android.custom.carlib.util;

import android.util.Log;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import com.tencentcloudapi.ocr.v20181119.models.LicensePlateOCRRequest;
import com.tencentcloudapi.ocr.v20181119.models.LicensePlateOCRResponse;

/**
 * @ProjectName: CarIDRead
 * @Package: com.android.custom.carlib.util
 * @ClassName: CarNoReadUtil
 * @Author: 1984629668@qq.com
 * @CreateDate: 2020/12/22 14:36
 */
public class CarNoReadUtil {
    private static final String TAG = "CarNoReadUtil";

    public static void read(String base64, OnCarReadListener carReadListener) {
        Log.e(TAG, "read: 进来了");
        try {
            Credential cred = new Credential("AKIDb8B8HIuiAScgrtAbJpMoBNNPEm9kKcnm", "zwmZR9f0sRD4kEcs1zlQuCJExUwHRRG8");
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("ocr.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            OcrClient client = new OcrClient(cred, "ap-beijing", clientProfile);
            LicensePlateOCRRequest req = new LicensePlateOCRRequest();
            req.setImageUrl("http://10.0.0.254:8077/upload/2020/11/11/1326371709767913472.jpg");
            LicensePlateOCRResponse resp = client.LicensePlateOCR(req);
            Log.e(TAG, "read: " + LicensePlateOCRResponse.toJsonString(resp));
            if (carReadListener != null) {
                carReadListener.success(LicensePlateOCRResponse.toJsonString(resp));
            }
        } catch (TencentCloudSDKException e) {
            Log.e(TAG, "read: " + e.toString());
            if (carReadListener != null) {
                carReadListener.error(e.toString());
            }
        }
    }

    public interface OnCarReadListener {
        void success(String result);

        void error(String msg);
    }
}
