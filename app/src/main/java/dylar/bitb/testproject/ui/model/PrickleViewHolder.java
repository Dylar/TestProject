package dylar.bitb.testproject.ui.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dylar.bitb.testproject.R;


class PrickleViewHolder extends RecyclerView.ViewHolder implements IPrickleRowView {

    @BindView(R.id.adapter_dashboard_row_text1)
    protected TextView textView;

    public PrickleViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setText(String text){
        textView.setText("PRICKLE: " + text);
    }
}
