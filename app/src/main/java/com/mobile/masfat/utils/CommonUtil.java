package com.mobile.masfat.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.masfat.R;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;



public class CommonUtil {

    static Toast toast = null;

    private static String country = null;
    public static AlertDialog chooserDialog = null;
    public static Bitmap rotate(Bitmap bitmap, int degree) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        Matrix mtx = new Matrix();
        mtx.postRotate(degree);

        return Bitmap.createBitmap(bitmap, 0, 0, w, h, mtx, true);
    }

    public static String getBase64Pic(String picturePath, Bitmap newPictureBitmap) {
        String encodedBitmap = null;
        if (newPictureBitmap != null) {
            String extension = picturePath.substring(picturePath.lastIndexOf(".") + 1);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpeg")) {
                newPictureBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
            } else if (extension.equalsIgnoreCase("png")) {
                newPictureBitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream);
            } else {
                newPictureBitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            encodedBitmap = Base64.encodeToString(byteArray, Base64.DEFAULT);
        }
        return encodedBitmap;
    }

    public static String getRealPathFromURI(Uri contentURI, Activity activityRef) {
        String result;
        Cursor cursor = activityRef.getContentResolver().query(contentURI,
                null, null, null, null);
        if (cursor == null) {
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor
                    .getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        System.out.println("path here:" + result);
        return result;
    }

    public static void printLog(String tag, String msg) {

        Log.v(tag + " :", msg);
    }


    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height
                    / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        final float totalPixels = width * height;
        final float totalReqPixelsCap = reqWidth * reqHeight * 2;
        while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {
            inSampleSize++;
        }

        return inSampleSize;
    }

    public static ProgressDialog getDialog(Activity activityRef, String title, String message) {
        ProgressDialog dialog = new ProgressDialog(activityRef);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        return dialog;

    }

    public static void hideKeyboard(View keyBoardView, Activity activityRef) {
        if (keyBoardView != null) {
            InputMethodManager imm = (InputMethodManager) activityRef.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(keyBoardView.getApplicationWindowToken(), 0);
        }
    }

    public static void toastMethod(Context activity, String Message) {
        Toast.makeText(activity,Message,Toast.LENGTH_SHORT).show();
    }

    public static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public static boolean isValidText(String string){
        if (TextUtils.isEmpty(string)){
            return false;
        }else {
            return true;
        }
    }


    public static Dialog getFilterDialog(Activity activityRef, int layout) {
        Dialog dialog = new Dialog(activityRef);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(layout);
        return dialog;

    }

    public static Dialog getFilterDataDialog(Activity activityRef, int layout) {
        Dialog dialog = new Dialog(activityRef);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(layout);
        return dialog;

    }

    public static String getSessionId(String userId) {
        if (userId != null && userId != "") {
            return System.currentTimeMillis() + userId;
        }
        return "";
    }

    public static String RomanNumerals(int Int) {
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
        roman_numerals.put("M", 1000);
        roman_numerals.put("CM", 900);
        roman_numerals.put("D", 500);
        roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        String res = "";
        for (Map.Entry<String, Integer> entry : roman_numerals.entrySet()) {
            int matches = Int / entry.getValue();
            res += repeat(entry.getKey(), matches);
            Int = Int % entry.getValue();
        }
        return res;
    }

    public static String repeat(String s, int n) {
        if (s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static long dateDiffInDays(String date, String pattern) {
        Date d1 = null;
        Date d2 = null;
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Calendar cal = Calendar.getInstance();
        String currentDate = format.format(cal.getTime());
        System.out.println(currentDate);
        try {
            d1 = format.parse(date);
            d2 = format.parse(currentDate);
            long diff = d1.getTime() - d2.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            long diffHours = diff / (60 * 60 * 1000);
            System.out.println(diffDays + " days, " + diffHours + " hours");
            if (diffHours > 0) {
                diffDays = diffDays + 1;
            }
            return diffDays;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String getDayDifference(String fromDate, String toDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            Date Created_convertedDate = null, Expire_CovertedDate = null, todayWithZeroTime = null;
            try {
                Created_convertedDate = dateFormat.parse(fromDate);
                Expire_CovertedDate = dateFormat.parse(toDate);
                Date today = new Date();
                todayWithZeroTime = dateFormat.parse(dateFormat.format(today));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int c_year = 0, c_month = 0, c_day = 0;
            if (Created_convertedDate.after(todayWithZeroTime)) {
                Calendar c_cal = Calendar.getInstance();
                c_cal.setTime(Created_convertedDate);
                c_year = c_cal.get(Calendar.YEAR);
                c_month = c_cal.get(Calendar.MONTH);
                c_day = c_cal.get(Calendar.DAY_OF_MONTH);
            } else {
                Calendar c_cal = Calendar.getInstance();
                c_cal.setTime(todayWithZeroTime);
                c_year = c_cal.get(Calendar.YEAR);
                c_month = c_cal.get(Calendar.MONTH);
                c_day = c_cal.get(Calendar.DAY_OF_MONTH);
            }
            Calendar e_cal = Calendar.getInstance();
            e_cal.setTime(Expire_CovertedDate);
            int e_year = e_cal.get(Calendar.YEAR);
            int e_month = e_cal.get(Calendar.MONTH);
            int e_day = e_cal.get(Calendar.DAY_OF_MONTH);
            Calendar date1 = Calendar.getInstance();
            Calendar date2 = Calendar.getInstance();
            date1.clear();
            date1.set(c_year, c_month, c_day);
            date2.clear();
            date2.set(e_year, e_month, e_day);
            long diff = date2.getTimeInMillis() - date1.getTimeInMillis();
            float dayCount = (float) diff / (24 * 60 * 60 * 1000);
            return ("" + ((int) dayCount + 1) + " Day(s)");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String dateDiffOfDates(String date1, String date2, String pattern) {
        Date d1 = null;
        Date d2 = null;
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            d1 = format.parse(date1);
            d2 = format.parse(date2);
            long diff = d1.getTime() - d2.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            long diffHours = diff / (60 * 60 * 1000);
            System.out.println(diffDays + " days, " + diffHours + " hours");
            if (diffHours > 0) {
                diffDays = diffDays + 1;
            }
            return String.valueOf(diffDays);
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    public static String getCurrentDate(String dateFormat) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }

    public static String getNextDate(String dateFormat, int day) {
        String dt = getCurrentDate("yyyy-MM-dd");  // Start date
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(dt));
            c.add(Calendar.DATE, day);  // number of days to add
            SimpleDateFormat sdf1 = new SimpleDateFormat(dateFormat);
            dt = sdf1.format(c.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dt;
    }


    public static RecyclerView.LayoutManager getVerticalRecyclerManager(Activity activity) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity, RecyclerView.VERTICAL, false);
        return layoutManager;
    }

    public static RecyclerView.LayoutManager getHorizontalRecyclerManager(Activity activity) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false);
        return layoutManager;
    }

    public static GridLayoutManager getGridRecyclerManager(Activity activity, int column) {
        GridLayoutManager layoutManager = new GridLayoutManager(activity, column);
        return layoutManager;
    }

    public static String getFormattedDate(String inPutDate, String inputFormatDate, String outPutFormatDate) {
        String outputDateStr = "";
        try {
            DateFormat inputFormat = new SimpleDateFormat(inputFormatDate);
            DateFormat outputFormat = new SimpleDateFormat(outPutFormatDate);
            Date date = inputFormat.parse(inPutDate);
            outputDateStr = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return outputDateStr;
    }

    public static String getFormattedDateNew(String inPutDate, String inputFormatDate, String outPutFormatDate) {
        String outputDateStr = "";
        try {
            DateFormat inputFormat = new SimpleDateFormat(inputFormatDate);
            DateFormat outputFormat = new SimpleDateFormat(outPutFormatDate);
            Date date = inputFormat.parse(inPutDate);
            outputDateStr = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return outputDateStr;
    }

    public static String getPerfectTime(String time) {
        String perfectTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat sdfs = new SimpleDateFormat("hh:mm a");
        Date dt;
        try {
            dt = sdf.parse(time);
            perfectTime = sdfs.format(dt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return perfectTime;
    }

    public static String capitalize(String line) {
        if (line != null && line.length() > 0) {
            return Character.toUpperCase(line.charAt(0)) + line.substring(1);
        } else {
            return line;
        }
    }


    public static void doColorSpanForFirstString(String firstString, String lastString, TextView txtSpan, int colour) {

        String changeString = (firstString != null ? firstString : "");

        String totalString = changeString + lastString;
        Spannable spanText = new SpannableString(totalString);
        spanText.setSpan(new ForegroundColorSpan(colour), 0, changeString.length(), 0);
        txtSpan.setText(spanText);
    }

    public static void downloadFile(String url, Activity activity) {
        DownloadManager downloadmanager = (DownloadManager) activity.getSystemService(Context.DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setVisibleInDownloadsUi(true);
        request.setDescription("Downloading File");
        Long reference = downloadmanager.enqueue(request);

    }

    public static String getRealPathFromURIPath(Uri contentURI, Activity activityRef) {
        Cursor cursor = activityRef.getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) {
            return contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(idx);
        }
    }

    public static String timeDifference(String toTime, String fromTime) throws ParseException {
        String diff = "";
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        Date Date1 = format.parse(toTime);
        Date Date2 = format.parse(fromTime);
        long mills = Date1.getTime() - Date2.getTime();
        int Hours = (int) (mills / (1000 * 60 * 60));
        int Mins = (int) (mills / (1000 * 60)) % 60;
        diff = Hours + ":" + Mins + ":" + "00";
        return diff;
    }

    public static boolean isAppInstalled(Context context, String packageName) {
        try {
            context.getPackageManager().getApplicationInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static boolean isSuccessResponse(String message){
        if (message.equalsIgnoreCase("Success") && !TextUtils.isEmpty(message)){
            return true;
        }else {
            return false;
        }
    }

    public static void setImageWithPicasso(final Context activityRef, final ImageView imageView, final String path) {
        if (path != null && path.length() > 0) {
            Log.v("Path", "Path " + path);
            try {
                ViewTreeObserver vto = imageView.getViewTreeObserver();
                vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        try {
                            imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                            Picasso.with(activityRef)
                                    .load(path)
                                    .noFade()
                                    .into(imageView);
                            return true;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return false;
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void setPictureWithCache(Context activityRef, ImageView imageView, String path) {
        Picasso.with(activityRef)
                .load(path)
                .noFade()
                .into(imageView);

    }

}
