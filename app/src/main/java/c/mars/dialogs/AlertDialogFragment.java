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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
                .setPositiveButton(ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txt.setText(ok);
                                Timber.d(ok);
                                System.gc();
                            }
                        }
                )
                .setNeutralButton("load", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        long sz = 4*1024*1024; //4MB
                        txt.setText("load: + "+sz+"*"+Byte.SIZE);
                        List<Byte> l = new LinkedList<Byte>();
                        Timber.d("empty sz: "+l.size());
                        byte b;
                        for (long i = 0; i < sz; i++) {
                            b = (byte) i;
                            l.add(b);
                            if (i % 10000 == 0) {
                                Timber.d("" + i + ": " + b + " sz:"+l.size());
                            }
                        }
                        txt.setText("load completed. sz:"+l.size()/(1024*Byte.SIZE)+"KB");
                    }
                })
                .setNegativeButton(cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Integer n = null;
                                Timber.d("crash now");

                                Timber.d(n.toString());

                                txt.setText(cancel);
                                Timber.d(cancel);
                            }
                        }
                )
                .create();
    }
}
