package com.example.changeicon.util;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import com.example.changeicon.Constants;

import java.util.List;


public class IconUtil {
    public static void setIcon(Context context,String enabledActivity){
        PackageManager packageManager = context.getPackageManager();

        packageManager.setComponentEnabledSetting(
                new ComponentName(context, Constants.ACTIVITY_ALIAS_Main1),
                Constants.ACTIVITY_ALIAS_Main1.equals(enabledActivity)?PackageManager.COMPONENT_ENABLED_STATE_ENABLED
                        :PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
        packageManager.setComponentEnabledSetting(
                new ComponentName(context, Constants.ACTIVITY_ALIAS_Main2),
                Constants.ACTIVITY_ALIAS_Main2.equals(enabledActivity)?PackageManager.COMPONENT_ENABLED_STATE_ENABLED
                        :PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
        ActivityManager am = (ActivityManager)context
                .getSystemService(Context.ACTIVITY_SERVICE);
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        List<ResolveInfo> resolves = packageManager.queryIntentActivities(intent,0);
        for (ResolveInfo res:resolves){
            if (res.activityInfo != null){
                am.killBackgroundProcesses(res.activityInfo.packageName);
            }
        }
    }
}
