package com.example.tacomiendo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tacomiendo.adapters.CustomAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link bebFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link bebFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class bebFrag extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    GridView gridView;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String[] bebidas={"Cafe","Jugo Natural","Vino tinto"};
    int[] bebidasId={R.drawable.cafe,R.drawable.jugo_natural,R.drawable.vino_tinto};
    String[] precios={"$15.00","$17.00","$30.00"};



    // TODO: Rename and change types of parameters


    private OnFragmentInteractionListener mListener;

    public bebFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment bebFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static bebFrag newInstance(String param1, String param2) {
        bebFrag fragment = new bebFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_beb, container, false);
        gridView= view.findViewById(R.id.gridview);
        CustomAdapter customAdapater= new CustomAdapter(bebidas,bebidasId,getLayoutInflater(),precios);
        gridView.setAdapter(customAdapater);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

   /* public class CustomAdapater extends BaseAdapter {

        @Override
        public int getCount() {
            return bebidasId.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1=getLayoutInflater().inflate(R.layout.row_data,null);
            TextView name=view1.findViewById(R.id.comida);
            ImageView image=view1.findViewById(R.id.images);
            name.setText(bebidas[position]);
            image.setImageResource(bebidasId[position]);
            return view1;
        }
    }*/
}
