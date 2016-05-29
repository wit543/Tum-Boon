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
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import xyz.wit543.wit.tumboon.R;
import xyz.wit543.wit.tumboon.adapter.UpgradeAdapter;
import xyz.wit543.wit.tumboon.model.Upgrade;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpgradeFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private RecyclerView upgradeRecyclerView;
    private UpgradeAdapter upgradeAdapter;
    private List<Upgrade> upgradeList;

    public UpgradeFragment() {
        // Required empty public constructor
    }

    public static UpgradeFragment newInstance(){
        UpgradeFragment fragment = new UpgradeFragment();
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_upgrade,container,false);

        upgradeList = new ArrayList<Upgrade>();
        upgradeList.add(new Upgrade("food",10,false));
        upgradeList.add(new Upgrade("water",10,false));
        upgradeList.add(new Upgrade("house",10,false));

        upgradeRecyclerView = (RecyclerView)rootview.findViewById(R.id.upgrade_list);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        upgradeRecyclerView.setLayoutManager(mLayoutManager);

        upgradeAdapter = new UpgradeAdapter(upgradeList);
        upgradeRecyclerView.setAdapter(upgradeAdapter);

        upgradeRecyclerView.setNestedScrollingEnabled(false);

        return rootview;
    }
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
