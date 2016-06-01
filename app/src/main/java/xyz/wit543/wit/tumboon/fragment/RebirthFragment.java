package xyz.wit543.wit.tumboon.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import xyz.wit543.wit.tumboon.R;
import xyz.wit543.wit.tumboon.model.Game;
import xyz.wit543.wit.tumboon.model.util.BoonUnitTranformer;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RebirthFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RebirthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RebirthFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private Button rebirthButton;
    private TextView discipleView;
    private TextView discipleMultiply;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public RebirthFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static RebirthFragment newInstance(String param1, String param2) {

        RebirthFragment fragment = new RebirthFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tranfrom, container, false);

        discipleView = (TextView)view.findViewById(R.id.current_disciple);
        rebirthButton = (Button)view.findViewById(R.id.rebirth_button);
        discipleMultiply = (TextView)view.findViewById(R.id.current_disciple_multiply);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Confirm");
        builder.setMessage("เมื่อเจ้าจุติเจ้าจะสูญเสียของบริจาคและการอัพเกรททั้งหมด\nคุณแน่ใจแล้วใช่หรือไม่");
        builder.setPositiveButton("ข้าต้องการเกิดใหม่", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Game.getInstance().rebirth();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("อย่านะ!!!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        final AlertDialog alert = builder.create();

        rebirthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.show();
            }
        });
        this.setDisciple();
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

    public void setDisciple(){
        this.discipleView.setText("สาวกปัจจุบัน: "+Game.getInstance().getDisciple());
        this.discipleMultiply.setText("อัตราคูณจากสาวก: "+ BoonUnitTranformer.getReadableValue(Game.getInstance().calculateDiscipleMultiply()) + " เท่า");
    }
}
