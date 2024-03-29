package com.abyan.pesanmakanan.fragments;

import android.content.Context;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.abyan.pesanmakanan.R;
import com.abyan.pesanmakanan.util.Pesan;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MenuPesanFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class MenuPesanFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    RadioButton Teh, Jeruk, Milo, Pecel, Geprek, Nasgor;
    int ma;
    int mi;
    int jumlah1;
    int jumlah2;
    int meja;

    public MenuPesanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_pesan, container, false);
        final RadioGroup makananGroup = view.findViewById(R.id.GroupMakanan);
        final RadioGroup minumanGroup = view.findViewById(R.id.GroupMinuman);
        final EditText namaText  = view.findViewById(R.id.TextNama);
        final EditText jumlah1Text  = view.findViewById(R.id.outJumlah1);
        final EditText jumlah2Text  = view.findViewById(R.id.outJumlah2);
        final EditText mejaText = view.findViewById(R.id.outMeja);


        Button pesanMkButton = view.findViewById(R.id.buttonPesanMk);
        pesanMkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    String namaString = namaText.getText().toString();
                    String jumlah1String = jumlah1Text.getText().toString();
                    String jumlah2String = jumlah2Text.getText().toString();
                    String mejaString = mejaText.getText().toString();
                    int checkedId = makananGroup.getCheckedRadioButtonId();
                    View radioId= makananGroup.findViewById(checkedId);
                    int idxId = makananGroup.indexOfChild(radioId);
                    if ((idxId != -1) && !TextUtils.isEmpty(namaString)) {
                        jumlah1 = Integer.parseInt(jumlah1String);
                        switch (idxId){
                            case 0:ma=0;
                            break;
                            case 1:ma=1;
                            break;
                            case 2:ma=2;
                            break;
                        }
                    }
                    int checkedId1 = minumanGroup.getCheckedRadioButtonId();
                    View radioId1=minumanGroup.findViewById(checkedId1);
                    int idxId1 =minumanGroup.indexOfChild(radioId1);
                    if((idxId1 != -1) && !TextUtils.isEmpty(namaString)){
                        jumlah2 = Integer.parseInt(jumlah2String);
                        switch (idxId1 ){
                            case 0:mi=0;
                                break;
                            case 1:mi=1;
                                break;
                            case 2:mi=2;
                                break;
                        }
                    }
                    else {
                        Toast.makeText(getActivity(), "Ketik Pesanan Anda!!!", Toast.LENGTH_SHORT).show();
                    }
                    mListener.onPesanButtonClicked(namaString,idxId, idxId1, Integer.parseInt(jumlah1String), Integer.parseInt(jumlah2String), Integer.parseInt(mejaString));
                }

            }
        });
//        return inflater.inflate(R.layout.fragment_menu_pesan, container, false);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

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
//        void onFragmentInteraction(Uri uri);
        void onPesanButtonClicked(String nama,  int makanan, int minuman, int jumlah1, int jumlah2, int meja);
    }
}
