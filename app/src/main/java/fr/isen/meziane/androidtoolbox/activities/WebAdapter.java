package fr.isen.meziane.androidtoolbox.activities;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import fr.isen.meziane.androidtoolbox.R;
import fr.isen.meziane.androidtoolbox.model.CircleTransform;
import fr.isen.meziane.androidtoolbox.model.Results;

import java.util.ArrayList;

public class WebAdapter extends RecyclerView.Adapter<WebAdapter.MyViewHolder> {
    public ArrayList<Results> mDataUser;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextViewName;
        public TextView mTextViewAdress;
        public TextView mTextViewMail;
        public ImageView mImageViewLogo;
        public MyViewHolder(ConstraintLayout v) {
            super(v);
            mTextViewName = v.findViewById(R.id.name);
            mTextViewAdress = v.findViewById(R.id.adress);
            mTextViewMail = v.findViewById(R.id.mail);
            mImageViewLogo = v.findViewById(R.id.imageView4);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public WebAdapter(java.util.ArrayList<Results> myDataset) {
        mDataUser = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public WebAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view

        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.web_adpter_view, parent, false);
        //...
        WebAdapter.MyViewHolder vh = new WebAdapter.MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(WebAdapter.MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        String output = mDataUser.get(position).getName().getFirst().substring(0, 1).toUpperCase() + mDataUser.get(position).getName().getFirst().substring(1);
        holder.mTextViewName.setText(output + " " + mDataUser.get(position).getName().getLast().toString().toUpperCase());
        holder.mTextViewAdress.setText(mDataUser.get(position).getLocation().getStreet().toString() + "\n" + mDataUser.get(position).getLocation().getPostcode().toString() + " " + mDataUser.get(position).getLocation().getCity().toString());
        holder.mTextViewMail.setText(mDataUser.get(position).getEmail().toString());
       // Picasso.get().load(mDataUser.get(position).getPicture().getLarge()).into(holder.mImageViewLogo);
        Picasso.get().load(mDataUser.get(position).getPicture().getLarge()).transform(new CircleTransform()).into(holder.mImageViewLogo);



    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataUser.size();
    }
}