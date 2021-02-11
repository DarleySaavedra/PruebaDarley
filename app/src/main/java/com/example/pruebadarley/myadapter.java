package com.example.pruebadarley;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class myadapter extends FirestoreRecyclerAdapter<Paciente, myadapter.myviewholder>
{
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public myadapter(@NonNull FirestoreRecyclerOptions<Paciente> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int i, @NonNull Paciente Paciente) {
        holder.nombretext.setText(Paciente.getNombre());
        holder.edtext.setText(Paciente.getDni());
        holder.htext.setText(Paciente.getHobbie());
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.room_recycle, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder{

        TextView nombretext, edtext, htext;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            nombretext = itemView.findViewById(R.id.txtnombre); //o probar con tnombre
            edtext = itemView.findViewById(R.id.txtdni);
            htext = itemView.findViewById(R.id.txthobbie);
        }
    }


}
