package vn.edu.ntu.taidanh.sinhvien;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.ntu.taidanh.sinhvien.controller.IController;
import vn.edu.ntu.taidanh.sinhvien.model.SinhVien;

public class ListSVFragment extends Fragment {
    NavController navController;
    IController IController;
    RecyclerView rcvSinhVien;
    List<SinhVien> listSinhVien;
    SinhVienAdapter adapter;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listsv, container, false);
         rcvSinhVien = view.findViewById(R.id.rcvSinhVien);
        rcvSinhVien.setLayoutManager(new LinearLayoutManager(getActivity()));
        addView();
        return view;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        navController = NavHostFragment.findNavController(this);
        ((MainActivity)getActivity()).navController = navController;
        IController= ((MainActivity) getActivity()).IController;
    }
    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void addView(){
        IController = ((MainActivity)getActivity()).IController;
        listSinhVien= IController.getAllSinhVien();
        adapter = new SinhVienAdapter(listSinhVien);
        rcvSinhVien.setAdapter(adapter);
    }
    private  class SinhVienViewHolder extends RecyclerView.ViewHolder{
        TextView txtMaSV, txtTen, txtGender, txtDate, txtDiemHkI, txtDiemHkII;
        SinhVien sv;
        public SinhVienViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtMaSV = itemView.findViewById(R.id.txtMaSV);
            txtTen = itemView.findViewById(R.id.txtTen);
            txtGender = itemView.findViewById(R.id.txtGender);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtDiemHkI = itemView.findViewById(R.id.txtDiemHkI);
            txtDiemHkII= itemView.findViewById(R.id.txtDiemHkII);

        }
        public void Bind(SinhVien sv){
            txtMaSV.setText(sv.getMaSV());
            txtTen.setText(sv.getTen());
            txtGender.setText(sv.getGioiTinh());
            txtDate.setText(sv.getNgaySinh());
            txtDiemHkI.setText(sv.getDiemHkI());
            txtDiemHkII.setText(sv.getDiemHkII());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    IController = ((MainActivity) getActivity()).IController;
                    if( IController.remove(txtTen.getText().toString())){
                        Toast.makeText(getActivity(),"xóa thành công", Toast.LENGTH_LONG).show();
                        addView();
                    }
                }
            });
        }
    }
    private class SinhVienAdapter extends RecyclerView.Adapter<SinhVienViewHolder> {
        List<SinhVien> listSinhVien;

        public SinhVienAdapter(List<SinhVien> listSinhVien) {
            this.listSinhVien = listSinhVien;
        }

        @NonNull
        @Override
        public SinhVienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.sinhvien, parent, false);
            return new SinhVienViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull SinhVienViewHolder holder, int position) {
            holder.Bind(listSinhVien.get(position));
        }

        @Override
        public int getItemCount() {
            return listSinhVien.size();
        }
    }

}
