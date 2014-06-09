package com.carlos.duallayoutapp.duallayoutapp.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carlos.duallayoutapp.duallayoutapp.R;
import com.carlos.duallayoutapp.duallayoutapp.util.CountryContent;

/**
 * Created by Carlos Jr on 09/06/2014.
 */
public class DetailsFragment extends Fragment {
    /**
     * Create a new instance of DetailsFragment, initialized to
     * show the text at 'index'.
     */

    enum FLAG{
        BRAZIL(R.drawable.brazil),GERMANY(R.drawable.germany),SPAIN(R.drawable.spain),ITALY(R.drawable.italy),FRANCE(R.drawable.france);

        private int countryFlag;

        FLAG(int param){
            this.countryFlag = param;
        }

        public int getCountryFlagResource(){
            return this.countryFlag;
        }

        public static FLAG fromInteger(int x) {
            switch(x) {
                case 0:
                    return BRAZIL;
                case 1:
                    return GERMANY;
                case 2:
                    return SPAIN;
                case 3:
                    return ITALY;
                case 4:
                    return FRANCE;

            }
            return null;
        }
    }

    public static DetailsFragment newInstance(int index) {
        DetailsFragment f = new DetailsFragment();

        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);

        return f;
    }

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            // We have different layouts, and in one of them this
            // fragment's containing frame doesn't exist.  The fragment
            // may still be created from its saved state, but there is
            // no reason to try to create its view hierarchy because it
            // won't be displayed.  Note this is not needed -- we could
            // just run the code below, where we would create and return
            // the view hierarchy; it would just never be used.
            return null;
        }

        TextView text = new TextView(getActivity());
        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                4, getActivity().getResources().getDisplayMetrics());
        text.setPadding(padding, padding, padding, padding);

        text.setText(CountryContent.SAMPLE_DESCRIPTION[getShownIndex()]);
        FLAG detailsFlag = FLAG.fromInteger(getShownIndex());
        Drawable img = getResources().getDrawable(detailsFlag.getCountryFlagResource());
        img.setBounds( 0, 0, 60, 60 );
        text.setCompoundDrawables(null, img, null, null );
        text.setMovementMethod(new ScrollingMovementMethod());
        return text;
    }
}
