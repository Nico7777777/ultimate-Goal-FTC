package org.firstinspires.ftc.robotcontroller.internal;

import android.Manifest;
import android.os.Bundle;
import com.qualcomm.ftcrobotcontroller.R;
import org.firstinspires.ftc.robotcore.internal.system.Misc;
import org.firstinspires.ftc.robotcore.internal.system.PermissionValidatorActivity;
import java.util.ArrayList;
import java.util.List;

public class PermissionValidatorWrapper extends PermissionValidatorActivity {

    private final String TAG = "PermissionValidatorWrapper";

    protected List<String> robotControllerPermissions = new ArrayList<String>() {{
        add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        add(Manifest.permission.READ_EXTERNAL_STORAGE);
        add(Manifest.permission.CAMERA);
        add(Manifest.permission.ACCESS_COARSE_LOCATION);
        add(Manifest.permission.ACCESS_FINE_LOCATION);
        add(Manifest.permission.READ_PHONE_STATE);
    }};

    private final static Class startApplication = FtcRobotControllerActivity.class;

    public String mapPermissionToExplanation(final String permission) {
        if (permission.equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            return Misc.formatForUser(R.string.permRcWriteExternalStorageExplain);
        } else if (permission.equals(Manifest.permission.READ_EXTERNAL_STORAGE)) {
            return Misc.formatForUser(R.string.permRcReadExternalStorageExplain);
        } else if (permission.equals(Manifest.permission.CAMERA)) {
            return Misc.formatForUser(R.string.permRcCameraExplain);
        } else if (permission.equals(Manifest.permission.ACCESS_COARSE_LOCATION)) {
            return Misc.formatForUser(R.string.permAccessLocationExplain);
        } else if (permission.equals(Manifest.permission.ACCESS_FINE_LOCATION)) {
            return Misc.formatForUser(R.string.permAccessLocationExplain);
        } else if (permission.equals(Manifest.permission.READ_PHONE_STATE)) {
            return Misc.formatForUser(R.string.permReadPhoneState);
        }
        return Misc.formatForUser(R.string.permGenericExplain);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        permissions = robotControllerPermissions;
    }

    protected Class onStartApplication()
    {
        FtcRobotControllerActivity.setPermissionsValidated();
        return startApplication;
    }
}
