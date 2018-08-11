package com.mokii.sun.mokiidiary.support.util;

import android.content.Context;
import android.content.Intent;

public class activityUtil {

    public static void startActivity(Context packageContext, Class<?> startActivity){
        Intent intent =  new Intent(packageContext,startActivity);;
        packageContext.startActivity(intent);
    }
}
