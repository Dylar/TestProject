package dylar.bitb.testproject.ui.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dylar.bitb.testproject.R;


class GooViewHolder extends RecyclerView.ViewHolder implements IGooRowView {

    @BindView(R.id.adapter_dashboard_row_text1)
    protected TextView textView;

    public GooViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setText(String text){
        textView.setText("GOO: " + text);
    }
}
