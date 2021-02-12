package com.example.pruebadarley;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebadarley.Retrofit.Model.Posts;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class myadapter extends FirebaseRecyclerAdapter<Paciente, myadapter.myviewholder>
{
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public myadapter(@NonNull FirebaseRecyclerOptions<Paciente> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull Paciente paciente) {
        holder.name.setText("" + paciente.getNombre());
        holder.course.setText("" + paciente.getDni());
        holder.email.setText("" + paciente.getHobbie());
    }


    /*
        @Override
        protected void onBindViewHolder(@NonNull myviewholder holder, int i, @NonNull Paciente Paciente) {
            holder.nombretext.setText(Paciente.getNombre());
            holder.edtext.setText(Paciente.getDni());
            holder.htext.setText(Paciente.getHobbie());
        }
    */
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }


    public class myviewholder extends RecyclerView.ViewHolder{

        //TextView nombretext, edtext, htext;
        TextView name,course,email;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
/*
            nombretext = itemView.findViewById(R.id.txtnombre); //o probar con tnombre
            edtext = itemView.findViewById(R.id.txtdni);
            htext = itemView.findViewById(R.id.txthobbie);

 */
            name=(TextView)itemView.findViewById(R.id.nametext);
            course=(TextView)itemView.findViewById(R.id.coursetext);
            email=(TextView)itemView.findViewById(R.id.emailtext);
        }
    }


}
