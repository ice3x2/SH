package kr.re.dev.androidLib.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Activity나 Fragment 가 갖고 있는 생명주기가 따로 필요 없고,
 * 뷰들의 간단한 동작들을 다루고 싶을 때 사용할 수 있다.
 * Fragment 보다 좀 더 작은 개념이며, iOS 의 ViewController 와 비슷하다.
 *
 * @author ice3x2
 *
 */
public class ViewController {
    private View mView;
    private Context mContext;

    public View findViewById(int res) {
        if(getView() == null) return null;
        return getView().findViewById(res);
    }

    public View getView() {
        return mView;
    }

    public String getString(int resId) {
        if(getContext() == null) return null;
        else return getContext().getString(resId);
    }

    public Drawable getDrawable(int resId) {
        if(getContext() == null) return null;
        else return getContext().getResources().getDrawable(resId);
    }

    public Context getContext() {
        return mContext;
    }

    public ViewController(Context context, View view) {
        mContext = context;
        mView =  view;
    }

    public ViewController(Context context, int res) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContext = context;
        mView =  inflater.inflate(res, null, false);
    }

    public ViewController(Context context, int res, ViewGroup root) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContext = context;
        mView =  inflater.inflate(res,root);
    }




}