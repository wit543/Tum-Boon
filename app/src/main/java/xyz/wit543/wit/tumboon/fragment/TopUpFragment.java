package xyz.wit543.wit.tumboon.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import xyz.wit543.wit.tumboon.R;
import xyz.wit543.wit.tumboon.model.Game;
import xyz.wit543.wit.tumboon.model.Multiplier;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TopUpFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TopUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopUpFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView currentMultiplier;
    private TextView currentMultiplierValue;
    private TextView remainingTime;
    private Button randomButton;
    private ImageView miraclePic;
    private TextView miracleDetail;

    private OnFragmentInteractionListener mListener;

    public TopUpFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TopUpFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TopUpFragment newInstance(String param1, String param2) {
        TopUpFragment fragment = new TopUpFragment();
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
        View view = inflater.inflate(R.layout.fragment_top_up, container, false);
        // Inflate the layout for this fragment
        final Game game = Game.getInstance();

        randomButton = (Button)view.findViewById(R.id.random_button);
        currentMultiplier = (TextView) view.findViewById(R.id.current_multiplier);
        currentMultiplierValue = (TextView) view.findViewById(R.id.current_multiplier_value);
        remainingTime = (TextView) view.findViewById(R.id.remaining_time);
        miraclePic = (ImageView) view.findViewById(R.id.miracle_pic);
        miracleDetail = (TextView) view.findViewById(R.id.miracle_detail);

        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(game.canBuyMultiplier())
                    game.buyMultiplier();
                else {
                    Toast.makeText(getActivity(), "ต้องการผู้งมงาย 1000 คน",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }

    public void update(){
        Game game = Game.getInstance();
        Multiplier multiplier = game.getCurrentMultiplier();
        if(remainingTime!=null && currentMultiplier!=null){
            if(multiplier!=null){
                remainingTime.setText("ระยะเวลาที่เหลือ: "+multiplier.getRemainingTime());
                currentMultiplier.setText("อภินิหารปัจจุบัน: "+multiplier.getName());
                currentMultiplierValue.setText("อัตราคูณปัจจุบัน: "+multiplier.getMultiply() + " เท่า");
                miraclePic.setImageResource(multiplier.getMultiplierPic());
                miracleDetail.setText(multiplier.getMultiplierDetail());
            }else{
                remainingTime.setText("ระยะเวลาที่เหลือ: "+"ไม่มีอภินิหาร");
                currentMultiplier.setText("อภินิหารปัจจุบัน: "+"ไม่มีอภินิหาร");
                currentMultiplierValue.setText("อัตราคูณปัจจุบัน: "+"ไม่มีอภินิหาร");
                miraclePic.setImageResource(R.drawable.multi4);
                miracleDetail.setText("ไม่มีอภินิหาร");
            }
        }
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
