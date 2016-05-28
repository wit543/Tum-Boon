package xyz.wit543.wit.tumboon.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.wit543.wit.tumboon.R;
import xyz.wit543.wit.tumboon.adapter.LayerAdapter;
import xyz.wit543.wit.tumboon.adapter.LayerManagerAdapter;
import xyz.wit543.wit.tumboon.model.Game;
import xyz.wit543.wit.tumboon.model.Layer;


public class LayerFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    private RecyclerView layerRecycleView;
    private LayerManagerAdapter layerManagerAdapter;

    public LayerFragment() {
        // Required empty public constructor
    }


    public static LayerFragment newInstance() {
        LayerFragment fragment = new LayerFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Game game = Game.getInstance();
        layerManagerAdapter = new LayerManagerAdapter(game.getLayerManagers());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_layer, container, false);

        layerRecycleView = (RecyclerView) view.findViewById(R.id.layer_recycle_view);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layerRecycleView.setLayoutManager(mLayoutManager);

//        layerRecycleView.setAdapter(new LayerAdapter(game.getLayers()));
        layerRecycleView.setAdapter(layerManagerAdapter);
        layerRecycleView.setNestedScrollingEnabled(false);

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

    public void update(){
        layerManagerAdapter.notifyDataSetChanged();
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
