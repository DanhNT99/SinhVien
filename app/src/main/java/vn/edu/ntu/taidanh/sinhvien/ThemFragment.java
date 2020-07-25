package vn.edu.ntu.taidanh.sinhvien;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import vn.edu.ntu.taidanh.sinhvien.controller.IController;
import vn.edu.ntu.taidanh.sinhvien.model.SinhVien;

import static android.widget.Toast.LENGTH_SHORT;

public class ThemFragment extends Fragment {
    NavController navController;
    private TextView mTextView;
    private EditText mEdtMaSV;
    private TextView mTextView2;
    private EditText mEdtTen;
    private TextView mTextView3;
    private RadioButton mRdbFemale;
    private RadioButton mRdbMale;
    private RadioGroup mRdgGender;
    private TextView mTextView4;
    private EditText mEdtDate;
    private ImageView mImvLich;
    private TextView mTextView6;
    private TextView mTextView5;
    private EditText mEdtDiemHkI;
    private TextView mTextView10;
    private EditText mEdtDiemHkII;
    private Button mBtnThem;
    private Button mBtnXem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_themsv, container, false);
        addView(view);
        addEvent();
        return view;
    }

    public void addView(View view) {
        mEdtMaSV = view.findViewById(R.id.edtMaSV);
        mTextView2 = view.findViewById(R.id.textView2);
        mEdtTen = view.findViewById(R.id.edtTen);
        mTextView3 = view.findViewById(R.id.textView3);
        mRdbFemale = view.findViewById(R.id.rdbFemale);
        mRdbMale = view.findViewById(R.id.rdbMale);
        mRdgGender = view.findViewById(R.id.rdgGender);
        mTextView4 = view.findViewById(R.id.textView4);
        mEdtDate = view.findViewById(R.id.edtDate);
        mImvLich = view.findViewById(R.id.imvLich);
        mTextView6 = view.findViewById(R.id.textView6);
        mTextView5 = view.findViewById(R.id.textView5);
        mEdtDiemHkI = view.findViewById(R.id.edtDiemHkI);
        mTextView10 = view.findViewById(R.id.textView10);
        mEdtDiemHkII = view.findViewById(R.id.edtDiemHkII);
        mBtnThem = view.findViewById(R.id.btnThem);
        mBtnXem = view.findViewById(R.id.btnXem);
    }
    public void addEvent(){
        mImvLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int ngay = calendar.get(Calendar.DATE);
                int thang = calendar.get(Calendar.MONTH);
                int nam = calendar.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(ThemFragment.this.getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                        calendar.set(year, month, date);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        mEdtDate.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                },nam, thang, ngay);
                datePickerDialog.show();
            }
        });
        mBtnThem.setOnClickListener(new View.OnClickListener() {
            SinhVien sv;
            List<SinhVien> listThongTin;
            IController IController;
            @Override
            public void onClick(View v) {
                String gioiTinh = "";
                switch (mRdgGender.getCheckedRadioButtonId()) {
                    case R.id.rdbMale: gioiTinh = mRdbMale.getText().toString();break;
                    case R.id.rdbFemale: gioiTinh = mRdbFemale.getText().toString();break;
                }
                sv = new SinhVien(mEdtMaSV.getText().toString(), mEdtTen.getText().toString(),gioiTinh,
                        mEdtDate.getText().toString(),mEdtDiemHkI.getText().toString()
                        ,mEdtDiemHkII.getText().toString());
                // Thêm quan trọng
                IController = ((MainActivity) getActivity()).IController;
                IController.add(sv);
                Toast.makeText(getActivity(), "Thêm thành công", LENGTH_SHORT).show();
            }
        });
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btnXem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThemFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}
