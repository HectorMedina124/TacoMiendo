package com.example.tacomiendo;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tacomiendo.clases.SeccionesAdapters;
import com.example.tacomiendo.clases.Utilidades;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link contFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link contFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class contFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    View vista;
    private AppBarLayout appbar;
    private TabLayout pestanas;
    private ViewPager viewPager;

    private OnFragmentInteractionListener mListener;

    public contFrag() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static contFrag newInstance(String param1, String param2) {
        contFrag fragment = new contFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista=inflater.inflate(R.layout.fragment_cont,container,false);

        if(Utilidades.rotacionB==0) {
            View parent= (View) container.getParent();
            if (appbar == null) {
                appbar = (AppBarLayout)parent.findViewById(R.id.appBar);
                pestanas = new TabLayout(getActivity());
                appbar.addView(pestanas);
                pestanas.setTabTextColors(Color.parseColor("#FFFFFF"),Color.parseColor("#FFFFFF"));
                viewPager = vista.findViewById(R.id.idView);
                llenarView(viewPager);
                viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                    }
                });
                pestanas.setupWithViewPager(viewPager);
            }
            pestanas.setTabGravity(TabLayout.GRAVITY_FILL);

        }
        else{
            Utilidades.rotacionB=1;
        }
        return vista;
    }

    @Override
    public void onDestroyView() {
        if(Utilidades.rotacionB==0) {
            super.onDestroyView();
            appbar.removeView(pestanas);
            appbar=null;
            pestanas=null;
            viewPager=null;
        }




    }

    private void llenarView(final ViewPager viewPager) {
        System.out.println("Entro a crear");
        SeccionesAdapters adapters=new SeccionesAdapters(getFragmentManager());
        adapters.addFragment(new PerfilFrag(),"Perfil");
        adapters.addFragment(new DireccionesFrag(),"Direcciones");
        adapters.addFragment(new TarjetasFrag(),"Tarjetas");
        viewPager.setAdapter(adapters);

    }
}
