package com.applex.snaplingo.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.applex.snaplingo.ActivityGrid;
import com.applex.snaplingo.R;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class DocAdapter extends RecyclerView.Adapter<DocViewHolder> {
    private Context mContext;
    private OnItemClickListener mListener;
    private ArrayList<DocModel> models;

    public interface OnItemClickListener {
        void onDeleteClick(int i);

        void onShareClick(int i);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mListener = onItemClickListener;
    }

    public DocAdapter(Context context, ArrayList<DocModel> arrayList) {
        this.models = arrayList;
        this.mContext = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DocViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new DocViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_doc_list, viewGroup, false), this.mListener);
    }

    public void onBindViewHolder(DocViewHolder docViewHolder, int i) {
        DocModel docModel = this.models.get(i);
        docViewHolder.docName.setText(docModel.getDocName());
        docViewHolder.docDate.setText(docModel.getDate());
        Picasso.get().load(docModel.getImageUri()).placeholder(R.drawable.image_background_grey).resizeDimen(R.dimen.doc_list_image_width, R.dimen.doc_list_image_height).memoryPolicy(MemoryPolicy.NO_CACHE, new MemoryPolicy[0]).priority(Picasso.Priority.HIGH).centerCrop().into(docViewHolder.image);
        docViewHolder.docLayout.setOnClickListener(new View.OnClickListener(docModel) {
            /* class com.applex.snaplingo.adapters.$$Lambda$DocAdapter$ghzPYgGVVH2SvURongAgV6zzXS0 */
            public final /* synthetic */ DocModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                DocAdapter.this.lambda$onBindViewHolder$0$DocAdapter(this.f$1, view);
            }
        });
        docViewHolder.image.setOnClickListener(new View.OnClickListener(docModel) {
            /* class com.applex.snaplingo.adapters.$$Lambda$DocAdapter$33SymF1KrXBzOeWoSz9evFeiRE */
            public final /* synthetic */ DocModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                DocAdapter.this.lambda$onBindViewHolder$1$DocAdapter(this.f$1, view);
            }
        });
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$DocAdapter(DocModel docModel, View view) {
        Intent intent = new Intent(this.mContext, ActivityGrid.class);
        intent.putExtra(AppMeasurementSdk.ConditionalUserProperty.NAME, docModel.getDocName());
        intent.putExtra("path", docModel.getPath());
        intent.putExtra("docBool", "1");
        this.mContext.startActivity(intent);
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$DocAdapter(DocModel docModel, View view) {
        Intent intent = new Intent(this.mContext, ActivityGrid.class);
        intent.putExtra(AppMeasurementSdk.ConditionalUserProperty.NAME, docModel.getDocName());
        intent.putExtra("path", docModel.getPath());
        intent.putExtra("docBool", "1");
        this.mContext.startActivity(intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.models.size();
    }

    public static class DocViewHolder extends RecyclerView.ViewHolder {
        ImageView delete;
        TextView docDate;
        LinearLayout docLayout;
        TextView docName;
        ImageView image;
        ImageView share;

        public DocViewHolder(View view, final OnItemClickListener onItemClickListener) {
            super(view);
            this.docName = (TextView) view.findViewById(R.id.doc_name);
            this.docDate = (TextView) view.findViewById(R.id.doc_date);
            this.image = (ImageView) view.findViewById(R.id.doc_image);
            this.docLayout = (LinearLayout) view.findViewById(R.id.doc_layout);
            this.delete = (ImageView) view.findViewById(R.id.delete);
            this.share = (ImageView) view.findViewById(R.id.share);
            this.delete.setOnClickListener(new View.OnClickListener() {
                /* class com.applex.snaplingo.adapters.DocAdapter.DocViewHolder.AnonymousClass1 */

                public void onClick(View view) {
                    int adapterPosition;
                    if (onItemClickListener != null && (adapterPosition = DocViewHolder.this.getAdapterPosition()) != -1) {
                        onItemClickListener.onDeleteClick(adapterPosition);
                    }
                }
            });
            this.share.setOnClickListener(new View.OnClickListener() {
                /* class com.applex.snaplingo.adapters.DocAdapter.DocViewHolder.AnonymousClass2 */

                public void onClick(View view) {
                    int adapterPosition;
                    if (onItemClickListener != null && (adapterPosition = DocViewHolder.this.getAdapterPosition()) != -1) {
                        onItemClickListener.onShareClick(adapterPosition);
                    }
                }
            });
        }
    }
}
