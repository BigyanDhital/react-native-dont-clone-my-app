package com.rnappsignaturehelper;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.rnappsignaturehelper.AppSignatureHelper;

import java.util.ArrayList;

public class RNAppSignatureHelperModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    public RNAppSignatureHelperModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNAppSignatureHelper";
    }

    @ReactMethod
    public void getAppSignatures(Promise promise) {
        try {
            AppSignatureHelper mAppSignatureHelper = new AppSignatureHelper(reactContext);
            ArrayList < String > list = mAppSignatureHelper.getAppSignatures();
            String[] stringArray = list.toArray(new String[0]);
            WritableArray promiseArray = Arguments.createArray();
            for (int i = 0; i < stringArray.length; i++) {
                promiseArray.pushString(stringArray[i]);
            }
            promise.resolve(promiseArray);
        } catch (Error e) {
            promise.reject(e);
        }
    }
    @ReactMethod
    public void getFilesDirPath(Promise promise) {
        try {
            String path = reactContext.getFilesDir().getPath();
            promise.resolve(path);          
        } catch (Error e) {
            promise.reject(e);
        }
    }
}