package com.aaagame.module.utils;

import android.app.Activity;

import com.aaagame.module.dialog.AALoadingDialog;
import com.aaagame.module.dialog.AAShowDialog;

public class T_BluetoothUtil {
    public static void PrintText(Activity activity, AALoadingDialog progressDialog,String content) {
        T_BluetoothService bluetoothService = T_BluetoothService
                .getBluetoothService(activity);
        bluetoothService.openBluetooth(activity);
        bluetoothService.sendData = content;
        if (!bluetoothService.isOpen()) {
            AAShowDialog.showAlert(activity, "请打开蓝牙设备");
            return;
        }
        if (bluetoothService.successBluetoothDevice == null) {
            bluetoothService.searchDevices(progressDialog,
                    activity);
        } else {
            bluetoothService.print(progressDialog, activity);
        }

    }
}
