package c.mars.dialogs;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import javax.xml.transform.Templates;

import timber.log.Timber;

/**
 * Created by Constantine Mars on 4/29/15.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class AlertDialogFragment extends DialogFragment{
    private TextView txt;

    public AlertDialogFragment(TextView txt) {
        this.txt = txt;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String ok = "ok";
        final String cancel = "cancel";

        return new AlertDialog.Builder(getActivity())
                .setMessage("message")
                .setTitle("title")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(ok, (dialog, which) -> {
                    txt.setText(ok);
                    Timber.d(ok);
                })
                .setNegativeButton(cancel, (d, w) -> {
                    txt.setText(cancel);
                    Timber.d(cancel);
                })
                .create();
    }
}
